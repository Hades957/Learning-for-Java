package com.yunsi.webSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient1 {
	private Socket socket;//�ͻ���
	private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
	
	public TcpClient1(String serverIP, int port) {	
		try {
			socket = new Socket(serverIP,port);
			System.out.println("�ͻ������ӵ���������......");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void startRequest() {
		PrintWriter pw = null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));			
			pw = new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				System.out.println("������");
				String line = key.readLine();
				
				pw.println(line);
				if(line.equalsIgnoreCase("exit")) {
					break;
				}
				
				String respMsg = br.readLine();
				System.out.println("�յ����Է���������Ϣ��"+respMsg);
			}
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			try {
				if(socket != null)socket.close();
			}catch(IOException e) {
				e.printStackTrace();
			}
		}
		
	}
	
	public static void main(String[] args) {
		TcpClient1 tc = new TcpClient1("192.168.10.51",8888);
		tc.startRequest();
	}

	
}
