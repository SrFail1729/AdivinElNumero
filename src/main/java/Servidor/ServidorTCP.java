package Servidor;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ServidorTCP {
    static void main(String[] args) {

        try (ServerSocket serverSocket = new ServerSocket(65000)){

            while (true){
                Socket clienteSocket = serverSocket.accept();
                HiloServidor hilo = new HiloServidor(clienteSocket);
                new Thread(hilo).start();
            }

        } catch (IOException e) {
            System.err.println("Error de conexión: " + e.getMessage());
        }
    }
}
