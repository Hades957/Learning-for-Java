package com.yunsi.test02;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * �������˱��
 * @author Administrator
 *
 */
public class TestServerSocket {

	public static void main(String[] args) throws Exception{
		//1.����TCP������
		int port = 8888;
		ServerSocket server = new ServerSocket(port);//������Ҫ���ҵ�һ���ض�����������ض����̣�����߱�2����������ip��ַ����λ����������֮����Ǽ����˿ںţ�һ�㡶=1024�˿ڶ�������os�������ã���
		
		//2.����
		System.out.println("before accept....");
		Socket socket = server.accept();//����֮�󣬵ȴ��ͻ�������һ������������ֻҪû�пͻ����Ӿ�һֱ����ߣ�
		//һ���ͻ����ӵ���������accept��������һ��Socket�������Socket������ͻ��˵�Socket���ö�Ӧ���γ��˹ܵ���һ�˺���һ�ˡ�
		
		//2.1 ��ͻ��˽����ܵ�
		InputStream in = socket.getInputStream();
		OutputStream out = socket.getOutputStream();
		BufferedReader br = new BufferedReader(new InputStreamReader(in));
		PrintWriter pw = new PrintWriter(out,true);
		
		//3.�пͻ�����֮���Ȼ�ȡ�ͻ�������Ϣ
//		System.out.println("##########");
		String reqMsg = br.readLine();
		System.out.println("�ͻ��˷��͵���Ϣ��"+reqMsg);
		//4.����֮�󣬸���ͻ���Ӧ
		String respMsg = new StringBuilder(reqMsg).reverse().toString();
		pw.println(respMsg);
		
		//5.�Ͽ���ͻ�������
		pw.close();
		br.close();
		socket.close();
		//6.�رշ���������ʵ�Ϸ���������7*24Сʱ���ػ��ģ�
		server.close();
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}
}
