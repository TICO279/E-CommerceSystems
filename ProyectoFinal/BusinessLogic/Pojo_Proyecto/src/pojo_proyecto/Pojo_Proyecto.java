/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo_proyecto;

import java.math.BigInteger;
import static java.time.Clock.system;
import solicita_servicio.ISolicitaServicio;
import wsproy.RespuestaGestionaPedido;
import wsproy.WSSolicitaOperationFault;
import wsproy.WSSolicitaOperationFault;

/**
 *
 * @author eduar
 */
public class Pojo_Proyecto implements ISolicitaServicio {

    long quienSoy;
    String host = null;
    
    java.util.List<wspedidos.Customer> listaCltes = new java.util.ArrayList<>();
    java.util.List<wspedidos.Product>  listaProds = new java.util.ArrayList<>();
    
    int num_cltes;
    int num_prods;
 
    @Override
    public void prepara(long quienSoy, String host) 
    {
        this.quienSoy = quienSoy;
        this.host     = host;        // NOTA: no se utiliza
        
        listaCltes    = catalogoCltes();
        listaProds    = catalogoProds();
        num_cltes     = listaCltes.size();
        num_prods     = listaProds.size();
    }

    @Override
    public long solicitaServicio(int vez) 
    {
        java.util.List<wspedidos.ClsItem>  listaIt    = new java.util.ArrayList<>();
        
        int num_pedido;
        int id_clte;
        int num_it;
        int cantidad;
        long id_prod;

        int queClte,queProd = 0;
       
        wspedidos.ClsItem item;
        
        queClte = (int) ( num_cltes * Math.random());
        id_clte = listaCltes.get(queClte).getId();


        num_it = (int) (1.0 + 10.0 * Math.random());
        num_it = num_it <= this.num_prods ? num_it : this.num_prods;
        
        //
        // para controlar que no se repitan los id_prod de los items
        //
        int [] arr_id_prod = new int[num_it];
        boolean ya_esta;
        //
        // Se generan los items para el pedido
        //
        for( int k = 0; k <  num_it; k++)
        {
            ya_esta = true;
            while(ya_esta)
            {
              queProd = (int) ( num_prods * Math.random());
              if( k == 0)
                  ya_esta = false;
              else
              {   
                  ya_esta = false;
                  for( int j = 0; j < k; j++)
                      ya_esta = ya_esta | queProd == arr_id_prod[j]; 
              }
            }
            arr_id_prod[k] = queProd;
            
            id_prod  = listaProds.get(queProd).getId();
            cantidad = (int)( 5.0 + 100 * Math.random() );
            item = new wspedidos.ClsItem();
            item.setIdProd(id_prod);
            item.setCantidad(cantidad);
            listaIt.add(item);
        }
        
        synchronized(System.out) {
        System.out.println("-----------------------------------------------");
        System.out.println("Estresador:" + this.quienSoy + ", vez:" + vez + ", Clte:" + id_clte);
        System.out.println("-----------------------------------------------");
        boolean A;
        
        wsproy.GestionaPedido entrada = new wsproy.GestionaPedido ();
        for(wspedidos.ClsItem it : listaIt){
            wsproy.ClsItem itProy = new wsproy.ClsItem();
            itProy.setCantidad(it.getCantidad());
            itProy.setIdProd(BigInteger.valueOf( it.getIdProd()));
            entrada.getListaItems().add(itProy);
            System.out.println("Prod_id:" + it.getIdProd() + ", cantidad:" + it.getCantidad() );
        }
        System.out.println("-----------------------------------------------");
        
        
        wsproy.RespuestaGestionaPedido salida;
        entrada.setIdClte(id_clte);
        
        wsproy.ExcepcionGenerica ex;
        
        long d2=System.nanoTime();
        long d1=System.nanoTime();
        try{
            salida=wsSolicitaOperation(entrada);
            System.out.println("Num_Pedido: "+salida.getRespuesta());
        }catch( WSSolicitaOperationFault e){
            
            ex=e.getFaultInfo();
            System.out.println(ex.getMessage());
        }
        //
        //   Se solicita registrar el pedido en el WS
        //
        //num_pedido = altaPedido(id_clte,listaIt);
        
        
       
        
        return d2-d1;
    }
    }

    @Override
    public void cierra() 
    {
         System.out.println("El thread de stress " + this.quienSoy + " ha terminado su trabajo"); 
    }

    // =========================================================================
    //                    main para probar el pojo  
    // =========================================================================
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
        Pojo_Proyecto objServ = new Pojo_Proyecto();
        
        objServ.prepara(25, null);
        int n_veces = args.length > 0 ? Integer.parseInt(args[0]):5;
        for( int vez = 1; vez <= n_veces; vez++)
            objServ.solicitaServicio(vez);
        objServ.cierra();
        
    }

    private static java.util.List<wspedidos.Customer> catalogoCltes() {
        wspedidos.WSPedido_Service service = new wspedidos.WSPedido_Service();
        wspedidos.WSPedido port = service.getWSPedidoPort();
        return port.catalogoCltes();
    }

    private static java.util.List<wspedidos.Product> catalogoProds() {
        wspedidos.WSPedido_Service service = new wspedidos.WSPedido_Service();
        wspedidos.WSPedido port = service.getWSPedidoPort();
        return port.catalogoProds();
    }

    private static RespuestaGestionaPedido wsSolicitaOperation(wsproy.GestionaPedido datosEntrada) throws WSSolicitaOperationFault {
        wsproy.CAProyectoService1 service = new wsproy.CAProyectoService1();
        wsproy.WSSolicitaPortType port = service.getCasaPort1();
        return port.wsSolicitaOperation(datosEntrada);
    }

    


}