package com.yunsi.ftpProgram.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * FTP服务器
 */
public class FtpServer {
    public static void main(String[] args) {
        //创建线程池
        ExecutorService es = newFixedThreadPool(10);
        //创建socket，绑定到8888端口
        ServerSocket serverSocket;
        int port = 8888;
        System.out.println("服务器启动在本机的"+port+"端口上。。。。。");
        try {
            serverSocket = new ServerSocket(port);
            //循环用以监听
            while (true){//这是多线程的，通过循环创建多个socket来实现
                //监听8888端口，直到有客户端信息发过来
                Socket socket=serverSocket.accept();
                //获取连接信息
                InetAddress clientIP = socket.getInetAddress();//本次连接的客户端IP
                int clientPort = socket.getPort();//本次连接的客户端端口
                System.out.println("客户端["+clientIP+"]通过端口"+clientPort+"连接到服务器");
                //从线程池中取出一个线程来处理这个连接
                es.submit(new StartService(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
