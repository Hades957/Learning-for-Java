package com.yunsi.webSocket;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TcpServerMulPro extends Thread {

	
	public static void main(String[] args) {
		 //����socket���󶨵�65000�˿�
        ServerSocket serverSocket;
        int port = 8888;
        System.out.println("�����������ڱ�����"+port+"�˿��ϡ���������");
		try {
			serverSocket = new ServerSocket(port);
			//ѭ�����Լ���
	        while (true){//���Ƕ��̵߳ģ�ͨ��ѭ���������socket��ʵ��
	            //����8888�˿ڣ�ֱ���пͻ�����Ϣ������
	            Socket socket=serverSocket.accept();
	            //ִ����ز���
	            new ServerReverse(socket).start();
	        }
		} catch (IOException e) {
			e.printStackTrace();
		}
        
	}
}