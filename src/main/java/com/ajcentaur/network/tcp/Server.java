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

