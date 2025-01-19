package pojo_enviosproy;

import solicita_servicio.ISolicitaServicio;

public class Pojo_EnviosProy implements ISolicitaServicio {

    private long quienSoy;

    @Override
    public void prepara(long quienSoy, String host) {
        this.quienSoy = quienSoy;
        Clte.carga_lista_Cltes(); // Cargar la lista de clientes desde la clase Clte
    }

    @Override
    public long solicitaServicio(int vez) {
        Clte clte = Clte.selClte(); // Seleccionar cliente aleatoriamente
        int idPedido = 300 + vez;   // Generar un ID de pedido ficticio para la prueba
        clte.setId_pedido(idPedido);

        // Solicitar el envío
        long inicio = System.nanoTime();
        boolean blnSolEnv = solicitudEnvio(
                clte.getId_tda(),
                clte.getId_pedido(),
                clte.getName(),
                clte.getEmail(),
                clte.getPhone(),
                clte.getAddress(),
                clte.getCity_region());
        long fin = System.nanoTime();

        // Log de resultados
        synchronized (System.out) {
            System.out.println("-----------------------------------------------");
            System.out.println("Estresador: " + this.quienSoy + ", vez: " + vez);
            System.out.println("Se ha solicitado el envío del pedido " + clte.getId_pedido()
                    + " para el cliente " + clte.getName()
                    + " con email " + clte.getEmail()
                    + " con status " + blnSolEnv);
            System.out.println("-----------------------------------------------");
            System.out.println("Tiempo de procesamiento (nanosegundos): " + (fin - inicio));
            System.out.println("===============================================");
        }

        return fin - inicio;
    }

    @Override
    public void cierra() {
        System.out.println("El thread de stress " + this.quienSoy + " ha terminado su trabajo");
    }

    // Método para solicitar un envío al WSEnvios
    private static boolean solicitudEnvio(int idTda, int idPedido, String name, String email, String phone, String address, String cityRegion) {
        wsenvios.WSEnvios_Service service = new wsenvios.WSEnvios_Service();
        wsenvios.WSEnvios port = service.getWSEnviosPort();
        return port.solicitudEnvio(idTda, idPedido, name, email, phone, address, cityRegion);
    }

    // Método principal para pruebas
    public static void main(String[] args) {
        Pojo_EnviosProy pojo = new Pojo_EnviosProy();
        pojo.prepara(1, null); // Inicializar con un identificador
        int n_veces = args.length > 0 ? Integer.parseInt(args[0]) : 5; // Número de veces a estresar
        for (int vez = 1; vez <= n_veces; vez++) {
            pojo.solicitaServicio(vez);
        }
        pojo.cierra();
    }
}
