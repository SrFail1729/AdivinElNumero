package Servidor;

import java.io.*;
import java.net.Socket;

public class HiloServidor implements Runnable {

    private Socket socket;
    private int numero;

    public HiloServidor(Socket socket) {
        this.socket = socket;
        this.numero = (int)(Math.random() * 100) + 1;
        System.out.println("Número generado: " + numero);
    }

    @Override
    public void run() {
        try (
                //Flujo de entrada salida, además hay que crearlos fuera del servidor
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true)
        ) {
            String linea;

            while ((linea = in.readLine()) != null) {
                System.out.println("Recibido: " + linea); //Aviso para ver si llega

                int num = Integer.parseInt(linea); // Recibimos y lo convertimos a entero

                String respuesta = comprobarNumero(num); // Obtenemos la contestación del servidor

                System.out.println("Enviando: " + respuesta); //Imprimimos la respuesta como un "log"
                out.println(respuesta); //Enviamos la respuesta

                if (respuesta.equals("Ganaste")) {
                    break;
                }
            }
        } catch (Exception e) {
            System.err.println("Error en hilo: " + e.getMessage());
        }
    }


    private String comprobarNumero(int numeroUsuario){
        String respuesta;

        if (numeroUsuario > numero) {
            respuesta = "El número es más pequeño";
        } else if (numeroUsuario < numero) {
            respuesta = "El número es más grande";
        } else{
            respuesta = "Ganaste";
        }

        return respuesta;
    }
}

