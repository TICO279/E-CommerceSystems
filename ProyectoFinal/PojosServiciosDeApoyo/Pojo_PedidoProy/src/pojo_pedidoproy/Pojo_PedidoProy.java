package pojo_pedidoproy;

import java.util.ArrayList;
import java.util.List;
import solicita_servicio.ISolicitaServicio;
import wspedido.WSPedido_Service;
import wspedido.WSPedido;
import wspedido.ClsItem;

public class Pojo_PedidoProy implements ISolicitaServicio {

    private long quienSoy;
    private List<wspedido.Customer> listaCltes;
    private List<wspedido.Product> listaProds;
    private int num_cltes;
    private int num_prods;

    @Override
    public void prepara(long quienSoy, String host) {
        this.quienSoy = quienSoy;
        this.listaCltes = catalogoCltes();
        this.listaProds = catalogoProds();
        this.num_cltes = listaCltes.size();
        this.num_prods = listaProds.size();
    }

    @Override
    public long solicitaServicio(int vez) {
        List<ClsItem> listaIt = new ArrayList<>();
        int id_clte = seleccionarCliente();
        int num_it = generarNumeroItems();

        // Generar los items para el pedido
        long[] arr_id_prod = new long[num_it];
        for (int i = 0; i < num_it; i++) {
            long id_prod = seleccionarProducto(arr_id_prod, i);
            int cantidad = (int) (5.0 + 100 * Math.random());
            ClsItem item = new ClsItem();
            item.setIdProd(id_prod);
            item.setCantidad(cantidad);
            listaIt.add(item);
        }

        // Mostrar información del pedido
        synchronized (System.out) {
            System.out.println("-----------------------------------------------");
            System.out.println("Estresador: " + this.quienSoy + ", vez: " + vez + ", Cliente: " + id_clte);
            listaIt.forEach(it -> System.out.println("Producto ID: " + it.getIdProd() + ", Cantidad: " + it.getCantidad()));
            System.out.println("-----------------------------------------------");
        }

        // Realizar alta de pedido
        long inicio = System.nanoTime();
        int num_pedido = altaPedido(id_clte, listaIt);
        long fin = System.nanoTime();

        // Mostrar resultado
        System.out.println("Número de Pedido: " + num_pedido);
        System.out.println("Tiempo de procesamiento (nanosegundos): " + (fin - inicio));
        System.out.println("===============================================");
        return fin - inicio;
    }

    @Override
    public void cierra() {
        System.out.println("El thread de stress " + this.quienSoy + " ha terminado su trabajo");
    }

    // Métodos de soporte
    private int seleccionarCliente() {
        return listaCltes.get((int) (num_cltes * Math.random())).getId();
    }

    private int generarNumeroItems() {
        return Math.min((int) (1.0 + 10.0 * Math.random()), num_prods);
    }

    private long seleccionarProducto(long[] arr_id_prod, int index) {
        int queProd;
        boolean yaEsta;
        do {
            queProd = (int) (num_prods * Math.random());
            yaEsta = false;
            for (int j = 0; j < index; j++) {
                if (arr_id_prod[j] == queProd) {
                    yaEsta = true;
                    break;
                }
            }
        } while (yaEsta);
        arr_id_prod[index] = queProd;
        return listaProds.get(queProd).getId();
    }

    private int altaPedido(int idClte, List<ClsItem> listaIt) {
        WSPedido_Service service = new WSPedido_Service();
        WSPedido port = service.getWSPedidoPort();
        return port.altaPedido(idClte, listaIt);
    }

    private List<wspedido.Customer> catalogoCltes() {
        WSPedido_Service service = new WSPedido_Service();
        WSPedido port = service.getWSPedidoPort();
        return port.catalogoCltes();
    }

    private List<wspedido.Product> catalogoProds() {
        WSPedido_Service service = new WSPedido_Service();
        WSPedido port = service.getWSPedidoPort();
        return port.catalogoProds();
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        Pojo_PedidoProy pojo = new Pojo_PedidoProy();
        pojo.prepara(1, null);
        int n_veces = args.length > 0 ? Integer.parseInt(args[0]) : 5;
        for (int vez = 1; vez <= n_veces; vez++) {
            pojo.solicitaServicio(vez);
        }
        pojo.cierra();
    }
}
