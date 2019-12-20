package com.yunsi.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	private Socket socket;//�ͻ���
	private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));//����
	
	public TCPClient(String serverIP,int serverPort) {
		try {
			socket = new Socket(serverIP,serverPort);
			System.out.println("�ͻ������ӵ����������ˡ�������");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startRequest() {
		//��ȡ���������
		PrintWriter pw= null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				//��ͣ�ļ��̽�����Ϣ��Ȼ����Ϊ�����͸���������
				System.out.print("�����룺");
				String line = key.readLine();
				
				
				
				//���͸�������
				pw.println(line);
				if(line.equalsIgnoreCase("exit")) {
					break;
					//�˳�
				}
				
				
				//Ȼ��ȴ���������Ӧ
				String respMsg = br.readLine();
				System.out.println("�յ����Ը�����������Ϣ��"+respMsg);
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
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

	public static void main(String[] args) {
		TCPClient tc = new TCPClient("192.168.12.254", 8888);
		tc.startRequest();
	}
}
