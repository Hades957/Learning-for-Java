package com.yunsi.test03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TCPClient {
	
	private Socket socket;//客户端
	private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));//键盘
	
	public TCPClient(String serverIP,int serverPort) {
		try {
			socket = new Socket(serverIP,serverPort);
			System.out.println("客户端连接到服务器端了。。。。");
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void startRequest() {
		//获取输入输出流
		PrintWriter pw= null;
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			pw = new PrintWriter(socket.getOutputStream(),true);
			while(true) {
				//不停的键盘接收信息，然后作为请求发送给服务器端
				System.out.print("请输入：");
				String line = key.readLine();
				
				
				
				//发送给服务器
				pw.println(line);
				if(line.equalsIgnoreCase("exit")) {
					break;
					//退出
				}
				
				
				//然后等待服务器响应
				String respMsg = br.readLine();
				System.out.println("收到来自付服务器的消息："+respMsg);
				
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
