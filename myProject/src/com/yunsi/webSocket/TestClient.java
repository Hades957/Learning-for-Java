package com.yunsi.webSocket;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Date;

public class TestClient {
	//����ͻ���
	public static void main(String[] args) throws Exception {
		String serverIP = "192.168.10.51";
		int port = 8888;
		Socket socket = new Socket(serverIP,port);
		System.out.println("after new Socket()...");
		
		//������������ܵ�
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		//�������󵽷����
		pw.println("hello...."+new Date());
//		pw.flush();
		
		//3.���շ������������Ӧ
		String respMsg = br.readLine();
		System.out.println("������������Ӧ��Ϣ��"+respMsg);
		
		//4.�ر�֮ǰ�򿪵���Դ��io����������أ�
		pw.close();
		br.close();
		socket.close();
		
	}
	
}
