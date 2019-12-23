package com.yunsi.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args)throws IOException {
		//1.构造UDP客户端
		DatagramSocket client= new DatagramSocket();//注意：最初的客户端不需要提供任何信息
		//2.组织信息，以DatagramPacket形式发送（void send(DatagramPacket))
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("请输入：");
		String reqMsg = br.readLine();
		
		byte[] sendData = reqMsg.getBytes();
		int sendDataLen = sendData.length;
		
		String ip = "192.168.12.5";
		InetAddress ipAddr = InetAddress.getByName(ip);
		DatagramPacket sendPack = new DatagramPacket(sendData,sendDataLen,ipAddr,9999);
		
		client.send(sendPack);
		
		//3.接收响应。调用(void receive(DatagramPacket))
		DatagramPacket recPack = new DatagramPacket(new byte[1024],1024);
		client.receive(recPack);
		//解包
		String respMsg = new String(recPack.getData(),0,recPack.getLength());
		System.out.println("收到UDP服务器的消息："+respMsg);
		
		//4.关闭资源
		client.close();
		
		
	}
}
