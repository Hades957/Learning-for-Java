package com.yunsi.webSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServer {
	
	private ServerSocket server;
	
	public TcpServer() {
		this(8888);
	}
	
	public TcpServer(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("服务器启动在本机的"+port+"端口上。。。。。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void startServer() {
		Socket socket = null;
		BufferedReader br = null;
		PrintWriter pw = null;
		while(true) {
			try {
				socket = server.accept();
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(),true);
				
				while(true) {
					InetAddress clientIP = socket.getInetAddress();
					int clientPort = socket.getPort();
					String reqMsg = br.readLine();
					System.out.println("来自["+clientIP+":"+clientPort+"] 客户端消息："+reqMsg);
					
					if(reqMsg.equalsIgnoreCase("exit")) {
						System.out.println("来自["+clientIP+":"+clientPort+"]的客户退出了。。。。");
						break;
					}
					
					StringBuilder buff = new StringBuilder(reqMsg);
					pw.println(buff.reverse().toString());
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(socket!=null)socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
	
	
	public static void main(String[] args) {
		TcpServer ss = new TcpServer();
		ss.startServer();
	}
}