package com.ajcentaur.network.tcp;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.charset.StandardCharsets;

/**
 * 网络编程-TCP编程
 * 服务端
 */
public class Server {

    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(6666);
        System.out.println("Server is running~~~");
        for(;;){
            Socket socket = ss.accept();
            System.out.println("connected from " + socket.getRemoteSocketAddress());
            Thread thread = new Handler(socket);
            thread.start();
        }
    }

}

class Handler extends Thread{
    Socket socket;

    public Handler(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try(InputStream input = this.socket.getInputStream()){
            try(OutputStream output = this.socket.getOutputStream()){
                handle(input, output);
            }
        } catch (Exception e){
            try {
                this.socket.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
            System.out.println("client disconnected.");
        }
    }

    private void handle(InputStream input, OutputStream output) throws IOException {
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(output, StandardCharsets.UTF_8));
        BufferedReader reader = new BufferedReader(new InputStreamReader(input, StandardCharsets.UTF_8));
        writer.write("hello\n");
        writer.flush();
        for(;;){
            String s = reader.readLine();
            if("bye".equals(s)){
                writer.write("bye\n");
                writer.flush();
                break;
            }
            writer.write("ok!"+ s + "\n");
            writer.flush();
        }
    }
}
