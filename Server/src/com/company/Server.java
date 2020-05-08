package com.company;

import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) {



        try(ServerSocket serverSocket = new ServerSocket(2000)) {

            while (true){
                System.out.println("Main server waits");
                Socket socket = serverSocket.accept();
                System.out.println("Client connected");

                ServerThread serverThread = new ServerThread(socket);
                serverThread.start();
            }


        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
