package com.yangshm.io;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Connection Per Thead
 */
public class ConnectionPerThead implements Runnable {
    static final int PORT = 8080;
    static final int SIZE = 1024;


    @Override
    public void run() {
        try {
            //服务器监听socket
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (!Thread.interrupted()) {
                Socket socket = serverSocket.accept();
                //接收一个连接后，为socket连接新建一个专属的处理器
                Handler handler = new Handler(socket);
                new Thread(handler).start();
            }
        } catch (Exception e) {
        }
    }

    static class Handler implements Runnable {
        final Socket socket;

        Handler(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            while (true) {
                try {
                    byte[] input = new byte[SIZE];
                    //读数据
                    socket.getInputStream().read(input);
                    byte[] ouput = null;
                    socket.getOutputStream().write(ouput);
                } catch (IOException e) {
                }
            }
        }
    }
}
