package Cliente;

import java.io.*;
import java.net.Socket;

public class ClienteTCP {
    static void main(String[] args) throws IOException {
       menu();
    }


    private static void menu(){
        boolean continuar = true;
        while (continuar){
            try {
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

                System.out.print("""
                1. Nueva partida.
                
                2. Salir.
                """);

                String usuario = teclado.readLine();

                int opcion = Integer.parseInt(usuario);

                switch (opcion){
                    case 1:
                        comunicaciónServidor();
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

    private static  void comunicaciónServidor(){
        try(Socket socket = new Socket("localhost",65000)){
            boolean continuar = true;

            while (continuar){

                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));
                BufferedReader mostar = new BufferedReader(new InputStreamReader(socket.getInputStream()));

                System.out.println("Intenta adivinar el número del 1 al 100");
                System.out.println("Introduce un número: ");

                String linea;
                while ()

                if (mostar.readLine().equals("Ganaste")){
                    System.out.println(mostar.readLine());
                    continuar = false;
                }else {
                    System.out.println(mostar.readLine());
                }

            }

        }catch (IOException e){
            System.err.println("Error de comunicación" + e.getMessage());
        }
    }
}
