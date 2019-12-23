package com.yunsi.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args)throws IOException {
		//1.����UDP������
		DatagramSocket server  = new DatagramSocket(9999);
		System.out.println("UDP�����������ˣ��ڱ���9999�˿��ϼ�����������");
		//ע�⣺DatagramSocket��Ϊ�������ˣ���������ʱ��Ҫ��ʽ���ṩ�˿ں�
		//����Ϊ����Ŀͻ����ǲ���Ҫ�ġ�
		
		DatagramPacket recPack = new DatagramPacket(new byte[1024],1024);
		DatagramPacket sendPack = null;
		//ע�⣺���͵İ�ʹ�õĹ��췽���������Ϣ�İ����췽���ǲ�һ���ģ�����
		
		
		//2.������Ϣ
		server.receive(recPack);//ע����������������ģ�һ���пͻ��˷�����Ϣ����߾���������
		//2.1 �������ȡ������Ϣ��
		byte[] datas = recPack.getData();
		int realLen = recPack.getLength();//ʵ�����ݵĴ�С
		//2.2 �ֽ�������Ϣת���ַ���
		String dataStr = new String(datas,0,realLen);//String(byte[],int,int)
		//2.3��ȡudp�ͻ��������Ϣ������ͻ��˵�ip��ַ�Լ��ߵĶ˿�
		System.out.println("UDP�ͻ��ˡ�"+recPack.getAddress()+":"+recPack.getPort()+"�����͹�������Ϣ��"+dataStr);
		
		
		//3.��Ӧ��Ϣ
		String respMsg = new StringBuilder(dataStr).reverse().toString();
		byte[] sendData = respMsg.getBytes();//�ַ���ת�ֽ����顣byte[] getBytes()
		int sendDataLen = sendData.length;
		sendPack = new DatagramPacket(sendData,sendDataLen,recPack.getAddress(),recPack.getPort());
		server.send(sendPack);
		
		//4.�ر���Դ
		server.close();
	}
}
