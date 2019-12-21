package com.yunsi.webSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerMulPro extends Thread {

	
	public static void main(String[] args) {
		 //创建socket，绑定到65000端口
        ServerSocket serverSocket;
        int port = 8888;
        System.out.println("服务器启动在本机的"+port+"端口上。。。。。");
		try {
			serverSocket = new ServerSocket(port);
			//循环用以监听
	        while (true){//这是多线程的，通过循环创建多个socket来实现
	            //监听8888端口，直到有客户端信息发过来
	            Socket socket=serverSocket.accept();
	            //执行相关操作
	            new ServerReverse(socket).start();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}