package com.yunsi.test02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TestClient {

	public static void main(String[] args) throws Exception{
		//1.构造客户端(一旦对象构造出来，没有报异常，就连接到服务器端了，作为服务器端此时accept方法会立即返回）
		String serverIP = "192.168.12.254";
		int port = 8888;
		Socket socket = new Socket(serverIP,port);//Socket(String ip,int port)
		System.out.println("after new Socket()....");
		
		//1.1 与服务器端建立管道
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		//2.发送请求到服务器端
		pw.println("hello...."+new Date());
//		pw.flush();
		
		//3.接收服务器给予的响应
		String respMsg = br.readLine();
		System.out.println("服务器给的响应消息："+respMsg);
		
		//4.关闭之前打开的资源（io，网络编程相关）
		pw.close();
		br.close();
		socket.close();
	}
}
