package com.yunsi.test01;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPClient {

	public static void main(String[] args)throws IOException {
		//1.����UDP�ͻ���
		DatagramSocket client= new DatagramSocket();//ע�⣺����Ŀͻ��˲���Ҫ�ṩ�κ���Ϣ
		//2.��֯��Ϣ����DatagramPacket��ʽ���ͣ�void send(DatagramPacket))
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("�����룺");
		String reqMsg = br.readLine();
		
		byte[] sendData = reqMsg.getBytes();
		int sendDataLen = sendData.length;
		
		String ip = "192.168.12.5";
		InetAddress ipAddr = InetAddress.getByName(ip);
		DatagramPacket sendPack = new DatagramPacket(sendData,sendDataLen,ipAddr,9999);
		
		client.send(sendPack);
		
		//3.������Ӧ������(void receive(DatagramPacket))
		DatagramPacket recPack = new DatagramPacket(new byte[1024],1024);
		client.receive(recPack);
		//���
		String respMsg = new String(recPack.getData(),0,recPack.getLength());
		System.out.println("�յ�UDP����������Ϣ��"+respMsg);
		
		//4.�ر���Դ
		client.close();
		
		
	}
}
