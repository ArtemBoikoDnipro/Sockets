package com.example.sockets;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    @SuppressWarnings("InfiniteLoopStatement")
    public static void main(String[] args) throws IOException {
        try (ServerSocket serverSocket = new ServerSocket(8080)) {
            while (true) {
                Socket client = serverSocket.accept();
                InputStreamReader in = new InputStreamReader(client.getInputStream());
                BufferedReader reader = new BufferedReader(in);
                reader.lines().forEach(System.out::println);
            }
        } catch (RuntimeException e) {
            System.out.println("Oops");
        }
    }
}
