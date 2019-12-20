package com.yunsi.webSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class TestServerSocket {
	public static void main(String[] args) throws IOException {
		//构造TCP服务器
		int port = 8888;
		ServerSocket server = new ServerSocket(port);
		
		//启动
		System.out.println("before accpet...");
		Socket socket = server.accept();
		
		//与客户端建立管道
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		//System.out.println("###########");
		
		String reqMsg = br.readLine();
		System.out.println("客户端发送的消息："+reqMsg);
		//4.处理之后，给予客户响应
		String respMsg = new StringBuilder(reqMsg).reverse().toString();
		pw.println(respMsg);
		
		//5.断开与客户的连接
		pw.close();
		br.close();
		socket.close();
		//6.关闭服务器（事实上服务器几乎7*24小时不关机的）
		server.close();
		
	}
}
