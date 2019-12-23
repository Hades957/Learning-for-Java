package com.yunsi.test01;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPServer {

	public static void main(String[] args)throws IOException {
		//1.构造UDP服务器
		DatagramSocket server  = new DatagramSocket(9999);
		System.out.println("UDP服务器启动了，在本机9999端口上监听。。。。");
		//注意：DatagramSocket作为服务器端，构造对象的时候要显式的提供端口号
		//而作为最初的客户端是不需要的。
		
		DatagramPacket recPack = new DatagramPacket(new byte[1024],1024);
		DatagramPacket sendPack = null;
		//注意：发送的包使用的构造方法与接收信息的包构造方法是不一样的！！！
		
		
		//2.接收信息
		server.receive(recPack);//注：这个方法是阻塞的，一旦有客户端发送信息，这边就立即返回
		//2.1 解包（获取具体信息）
		byte[] datas = recPack.getData();
		int realLen = recPack.getLength();//实际数据的大小
		//2.2 字节数组信息转成字符串
		String dataStr = new String(datas,0,realLen);//String(byte[],int,int)
		//2.3获取udp客户端相关信息，例如客户端的ip地址以及走的端口
		System.out.println("UDP客户端【"+recPack.getAddress()+":"+recPack.getPort()+"】发送过来的消息："+dataStr);
		
		
		//3.响应信息
		String respMsg = new StringBuilder(dataStr).reverse().toString();
		byte[] sendData = respMsg.getBytes();//字符串转字节数组。byte[] getBytes()
		int sendDataLen = sendData.length;
		sendPack = new DatagramPacket(sendData,sendDataLen,recPack.getAddress(),recPack.getPort());
		server.send(sendPack);
		
		//4.关闭资源
		server.close();
	}
}
