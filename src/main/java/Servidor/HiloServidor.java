package Servidor;

import java.io.*;
import java.net.Socket;

public class HiloServidor implements Runnable{
    private  Socket socket;
    private static final int numRadom = (int) (Math.random() * (100 - 1 + 1));

    public HiloServidor(Socket s) {
        socket = s;
    }
    @Override
    public void run() {
        try{

            BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter out = new PrintWriter(socket.getOutputStream(),true);

            String datos = in.readLine();
            int numUsuario = Integer.parseInt(datos);
            out.println(comprobarNumero(numUsuario));

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String comprobarNumero(int numUsuario){
        String respuesta = "";

        if (numUsuario > numRadom){
            respuesta = "El número es más pequeño";
        }else if(numUsuario < numRadom ){
            respuesta = "El número es más grande";
        }else {
            respuesta = "Ganaste";
        }

        return respuesta;
    }
}
