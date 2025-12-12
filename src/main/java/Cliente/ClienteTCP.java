package Cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP {
    static void main(String[] args) throws IOException {
       menu();
    }


    private static void menu(){

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

                    break;

                case 2:

                    break;

                default:
                    System.err.println("El valor introducido no esta contemplado.");

            }

        }catch (IOException e){
            System.err.println("Error de IO: " + e.getMessage());
        }
    }


}
