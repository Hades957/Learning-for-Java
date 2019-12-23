package com.yunsi.review;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * ��дһ��Socket��Server����ֻ��Ҫ�ͻ��˷���һ���ı���Ϣ�������յ���������Ӧ��ȥ�����������⣩
 * @author Administrator
 *
 */
public class Test6 {
	public static void main(String[] args) throws Exception {
		int port = 8888;
		ServerSocket server = new ServerSocket(port);
		
		Socket socket = server.accept();
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		String str = br.readLine();
		str = new StringBuilder(str).reverse().toString();
		pw.println(str);
		
		
	}
}
