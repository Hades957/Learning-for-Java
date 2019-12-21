package com.yunsi.test02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 服务器端编程
 * @author Administrator
 *
 */
public class TestServerSocket {

	public static void main(String[] args) throws Exception{
		//1.构造TCP服务器
		int port = 8888;
		ServerSocket server = new ServerSocket(port);//网络上要想找到一个特定机器上面的特定进程，必须具备2个条件，先ip地址（定位机器），再之后就是监听端口号（一般《=1024端口都是留给os另作他用），
		
		//2.启动
		System.out.println("before accept....");
		Socket socket = server.accept();//启动之后，等待客户，这是一个阻塞方法（只要没有客户连接就一直卡这边）
		//一旦客户连接到服务器，accept立即返回一个Socket对象，这个Socket对象与客户端的Socket正好对应。形成了管道的一端和另一端。
		
		//2.1 与客户端建立管道
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		//3.有客户连接之后，先获取客户请求信息
//		System.out.println("##########");
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
