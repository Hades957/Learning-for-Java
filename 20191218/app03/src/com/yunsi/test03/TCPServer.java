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
			System.out.println("�����������ڱ�����"+port+"�˿��ϡ���������");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	
	//����������
	public void startServer() {
		//socket���Ƿ�������ͻ��˶�Ӧ��
		BufferedReader br = null;
		PrintWriter pw = null;
		Socket socket = null;
		while(true) {
			try {
				socket = server.accept();
				
				//��ȡ���������
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(),true);
				
				
				while(true) {
					//����Ҫע�⣬�ȶ�ȡ��Ϣ����ȡ������д��Ϣ����Ӧ��
					InetAddress clientIP = socket.getInetAddress();
					int clientPort = socket.getPort();
					String reqMsg = br.readLine();
					System.out.println("����["+clientIP+":"+clientPort+"] �ͻ�����Ϣ��"+reqMsg);
					
					if(reqMsg.equalsIgnoreCase("exit")) {
						System.out.println("����["+clientIP+":"+clientPort+"]�Ŀͻ��Ƴ��ˡ�������");
						break;
					}
					
					//��Ӧ
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
