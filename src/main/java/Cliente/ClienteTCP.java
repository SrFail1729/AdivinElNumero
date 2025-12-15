package Cliente;

import java.io.*;
import java.net.Socket;

public class ClienteTCP {
   public static void main(String[] args) throws IOException {
       menu();
   }

    private static void menu(){
        boolean continuar = true;
        while (continuar){
            try {
                System.out.print("""
                1. Nueva partida.
                2. Salir.
                """);

                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in)); // No hay que cerrar el BR

                String usuario = teclado.readLine();

                int opcion = Integer.parseInt(usuario);

                switch (opcion){
                    case 1:
                        comunicaciónServidor(teclado); //Hay que pasar el BR
                        break;
                    case 2:
                        continuar = false;
                        break;

                    default:
                        System.err.println("El valor introducido no esta contemplado.");

                }

            }catch (IOException e){
                System.err.println("Error de IO: " + e.getMessage());
            }
        }
    }

    private static  void comunicaciónServidor(BufferedReader teclado){
        try (
                Socket socket = new Socket("localhost", 65000);
                PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
                BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        ){
            System.out.println("Conectado al servidor");

            while (true) {
                System.out.print("Introduce un número (1-100): ");
                String numero = teclado.readLine();

                out.println(numero);              // Enviar
                String respuesta = in.readLine(); // Recibir

                System.out.println("Servidor: " + respuesta);

                if ("Ganaste".equals(respuesta)) {
                    break;
                }
            }

        } catch (IOException e) {
            System.err.println("Error comunicación: " + e.getMessage());
        }
    }
}
