package com.yunsi.review;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.rmi.UnknownHostException;
/**
 * �ղ�Test6�е�socket�����ǲ���֧�ֶ�οͻ��������޸ĳɶ�οͻ�����ͨ�����̣�
 * @author Administrator
 *
 */
public class Test8 {
	private Socket socket;
	private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
	
	public Test8(String serverIP,int serverPort) {
		try {
			socket = new Socket(serverIP,serverPort);
			System.out.println("���ӵ�������");
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
				System.out.println("������");
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
