package com.bruce.concurrentdemo.chapter4;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by wuteng1 on 2016/7/21.
 */
public class SimpleHttpServer {
    static ThreadPool<HttpRequestHandler> threadPool = new DefaultThreadPool<HttpRequestHandler>();
    static String basePath;
    static ServerSocket serverSocket;

    static int port = 8080;

    public static void setPort(int port){
        if(port > 0){
            SimpleHttpServer.port = port;
        }
    }
    public static void setBasePath(String basePath){
        if(basePath != null && new File(basePath).exists() && new File(basePath).isDirectory()){
            SimpleHttpServer.basePath = basePath;
        }
    }

    //start simplehttpServer
    public static void start() throws IOException {
        serverSocket = new ServerSocket(port);
        Socket socket = null;
        while((socket = serverSocket.accept()) != null){
            //accept client socket, and put into threadpool
            threadPool.execute(new HttpRequestHandler(socket));
        }
        serverSocket.close();
    }
    static class HttpRequestHandler implements Runnable{
        private Socket socket;

        public HttpRequestHandler(Socket socket) {
            this.socket = socket;
        }

        public void run() {
            String line = null;
            BufferedReader br = null;
            BufferedReader reader = null;
            PrintWriter out = null;
            InputStream in = null;
            try {
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                String header = reader.readLine();

            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
