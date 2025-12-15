package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {

    public static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(65000)){

            while (true){
                Socket clienteSocket = serverSocket.accept();
                new Thread(new HiloServidor(clienteSocket)).start();
            }


        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}
