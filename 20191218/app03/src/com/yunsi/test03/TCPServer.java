package com.yunsi.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServer {

	private ServerSocket server;
	
	public TCPServer() {
		this(8888);
	}
	public TCPServer(int port) {
		try {
			server = new ServerSocket(port);
			System.out.println("服务器启动在本机的"+port+"端口上。。。。。");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//启动服务器
	public void startServer() {
		//socket就是服务器与客户端对应的
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		while(true) {
			try {
				socket = server.accept();
				
				//获取输入输出流
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(),true);
				
				
				while(true) {
					//！！要注意，先读取信息（收取），再写信息（响应）
					InetAddress clientIP = socket.getInetAddress();
					int clientPort = socket.getPort();
					String reqMsg = br.readLine();
					System.out.println("来自["+clientIP+":"+clientPort+"] 客户端消息："+reqMsg);
					
					if(reqMsg.equalsIgnoreCase("exit")) {
						System.out.println("来自["+clientIP+":"+clientPort+"]的客户推出了。。。。");
						break;
					}
					
					//响应
					StringBuilder buff = new StringBuilder(reqMsg);
					pw.println(buff.reverse().toString());
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			finally {
				try {
					if(br!=null)br.close();
					if(pw!=null)pw.close();
					if(socket!=null)socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
	public static void main(String[] args) {
		TCPServer ss = new TCPServer();
		ss.startServer();
	}
}
