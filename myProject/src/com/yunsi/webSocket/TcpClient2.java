package com.yunsi.webSocket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class TcpClient2 {
	private Socket socket;//客户端
	private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
	
	public TcpClient2(String serverIP, int port) {	
		try {
			socket = new Socket(serverIP,port);
			System.out.println("客户端连接到服务器了......");
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
				System.out.println("请输入");
				String line = key.readLine();
				
				pw.println(line);
				if(line.equalsIgnoreCase("exit")) {
					break;
				}
				
				String respMsg = br.readLine();
				System.out.println("收到来自服务器的消息："+respMsg);
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
		TcpClient2 tc = new TcpClient2("192.168.10.51",8888);
		tc.startRequest();
	}

	
}
