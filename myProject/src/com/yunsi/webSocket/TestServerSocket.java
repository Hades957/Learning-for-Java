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
		//����TCP������
		int port = 8888;
		ServerSocket server = new ServerSocket(port);
		
		//����
		System.out.println("before accpet...");
		Socket socket = server.accept();
		
		//��ͻ��˽����ܵ�
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		//System.out.println("###########");
		
		String reqMsg = br.readLine();
		System.out.println("�ͻ��˷��͵���Ϣ��"+reqMsg);
		//4.����֮�󣬸���ͻ���Ӧ
		String respMsg = new StringBuilder(reqMsg).reverse().toString();
		pw.println(respMsg);
		
		//5.�Ͽ���ͻ�������
		pw.close();
		br.close();
		socket.close();
		//6.�رշ���������ʵ�Ϸ���������7*24Сʱ���ػ��ģ�
		server.close();
		
	}
}
