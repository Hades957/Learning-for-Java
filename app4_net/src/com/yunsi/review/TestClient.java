package com.yunsi.review;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;

public class TestClient {
	public static void main(String[] args) throws Exception {
		String serverIP = "192.168.12.254";
		int port = 8888;
		Socket socket =new Socket(serverIP,port);
		
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		pw.println("abcdefg");
		
		String read = br.readLine();
		System.out.println(read);
		
		
	}
}
