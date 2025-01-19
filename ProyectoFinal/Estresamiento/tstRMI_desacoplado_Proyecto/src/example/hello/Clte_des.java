//================================================================
// Código del Cliente actualizado para manejar la excepción de división por cero
//================================================================
package example.hello;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
//import interfazservicioestres.InterfazServicioEstres;
import solicita_servicio.ISolicitaServicio;

public class Clte_des {

    public static void main(String[] args) {

        solicita_servicio.ISolicitaServicio objServ; // Objeto de servicio de tipo interfaz

        long lngQuienSoy;
        long sumDeltaT, sumDeltaT2, dtMin = 0, dtMax = 0;
        long lngCuantosMilisFaltan;

        String host = (args.length < 1) ? null : args[0];
        long i, n, dt;
        n = (args.length < 2) ? 300 : Integer.parseInt(args[1]);
        
        /*
        int operacion = 5; // Valor por defecto: Suma
        if (args.length > 2) {
            operacion = Integer.parseInt(args[2]); // Obtenemos la operación desde los argumentos
        }
        */

        try {
            // Instanciamos el nuevo cliente ClienteOperWS
            objServ = (ISolicitaServicio) Class.forName("pojo_proyecto.Pojo_Proyecto").newInstance(); // Cambio a ClienteOperWS

            Registry registry = LocateRegistry.getRegistry(host);
            IServDisparo servDisparo = (IServDisparo) registry.lookup("ServidorDeDisparo");
            lngQuienSoy = servDisparo.quienSoy(); // Pido quien soy

            objServ.prepara((int) lngQuienSoy, host); // Inicializamos el servicio

            lngCuantosMilisFaltan = servDisparo.deltaTEnMilis();
            System.out.println("Cliente " + lngQuienSoy + " faltan " + lngCuantosMilisFaltan + " milisegundos");
            sumDeltaT = 0;
            sumDeltaT2 = 0;

            Thread.currentThread().sleep(lngCuantosMilisFaltan);

            // Ejecutamos el loop de invocación del servicio
            for (i = 0; i < n; i++) {
                try {
                    dt = objServ.solicitaServicio((int) i); // Invocamos el servicio con dos parámetros: iteración y operación

                    sumDeltaT += dt;
                    sumDeltaT2 += dt * dt;
                    if (i == 0) {
                        dtMin = dt;
                        dtMax = dt;
                    } else {
                        if (dt < dtMin) dtMin = dt;
                        if (dt > dtMax) dtMax = dt;
                    }
                } catch (IllegalArgumentException e) {
                    System.err.println("Error: Se produjo un error en  " + i + ": " + e.getMessage());
                }
            }

            // Acumulamos resultados en el servidor
            servDisparo.acumula(sumDeltaT, sumDeltaT2, n, dtMax, dtMin);

            // Cerramos el servicio
            objServ.cierra();
        } catch (Exception e) {
            System.err.println("Client exception: " + e.toString());
            e.printStackTrace();
        }
    }
}
//================================================================
