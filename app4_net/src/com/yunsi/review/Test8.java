package com.yunsi.review;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
/**
 * 刚才Test6中的socket程序是不能支持多次客户请求，请修改成多次客户请求（通过键盘）
 * @author Administrator
 *
 */
public class Test8 {
	private Socket socket;
	private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
	
	public Test8(String serverIP,int serverPort) {
		try {
			socket = new Socket(serverIP,serverPort);
			System.out.println("连接到服务器");
		}catch(UnknownHostException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	public void statRequest() {
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
				System.out.println(respMsg);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally {
			try {
				if(br!=null)br.close();
				if(pw!=null)pw.close();
				if(socket!=null)socket.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}
