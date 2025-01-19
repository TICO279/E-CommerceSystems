/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pojo_envios_libros;

/**
 *
 * @author eduar
 */
public class Pojo_Envios_Libros {

    public static void main(String[] args) 
    {
        Clte.carga_lista_Cltes();
        Clte clte = null;
        
        boolean blnSolEnv = false; 
        
        for( int k = 300;k <= 305; k++)
        {
          clte = Clte.selClte();
          clte.setId_pedido(k);
          
          blnSolEnv = solicitudEnvio(clte.getId_tda(),
                                     clte.getId_pedido(),
                                     clte.getName(),
                                     clte.getEmail(),
                                     clte.getPhone(),
                                     clte.getAddress(),
                                     clte.getCity_region());
          System.out.println("Se ha solicitado el envio del pedido " + clte.getId_pedido() + " para el clte " + clte.getName() +
                             " con email "  + clte.getEmail() + "con status " + blnSolEnv); 
        }
    }

    private static boolean solicitudEnvio(int idTda, int idPedido, java.lang.String name, java.lang.String email, java.lang.String phone, java.lang.String address, java.lang.String cityRegion) {
        wsenvios.WSEnvios_Service service = new wsenvios.WSEnvios_Service();
        wsenvios.WSEnvios port = service.getWSEnviosPort();
        return port.solicitudEnvio(idTda, idPedido, name, email, phone, address, cityRegion);
    }
    
    
    
}
