package Cliente;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class ClienteTCP {
    static void main(String[] args) {
        try(Socket socket = new Socket("localhost", 5000);) {

            DataOutputStream out = new DataOutputStream(socket.getOutputStream());
            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            BufferedReader teclado = new BufferedReader(new InputStreamReader(System.in));

            String num = teclado.readLine();

            out.writeUTF(num);

            out.flush();

            socket.shutdownInput();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
