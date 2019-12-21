package com.yunsi.webSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;

public class ServerReverse extends Thread {
    //��SocketΪ��Ա����
    private Socket socket;
    public ServerReverse(Socket socket) {
    	this.socket=socket;
    }
    
    @Override
    public void run(){
    	BufferedReader br = null;
		PrintWriter pw = null;
		while(true) {
			try {
				br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
				pw = new PrintWriter(socket.getOutputStream(),true);
				
				while(true) {
					InetAddress clientIP = socket.getInetAddress();
					int clientPort = socket.getPort();
					String reqMsg = br.readLine();
					System.out.println("����["+clientIP+":"+clientPort+"] �ͻ�����Ϣ��"+reqMsg);
					
					if(reqMsg.equalsIgnoreCase("exit")) {
						System.out.println("����["+clientIP+":"+clientPort+"]�Ŀͻ��˳��ˡ�������");
						break;
					}
					
					StringBuilder buff = new StringBuilder(reqMsg);
					pw.println(buff.reverse().toString());
				}
			}catch(IOException e) {
				e.printStackTrace();
			}finally {
				try {
					if(socket!=null)socket.close();
				}catch(IOException e) {
					e.printStackTrace();
				}
			}
		}
    }
}

