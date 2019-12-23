package com.yunsi.ftpProgram.Server;

import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorCompletionService;
import java.util.concurrent.ExecutorService;

import static java.util.concurrent.Executors.newFixedThreadPool;

/**
 * FTP������
 */
public class FtpServer {
    public static void main(String[] args) {
        //�����̳߳�
        ExecutorService es = newFixedThreadPool(10);
        //����socket���󶨵�8888�˿�
        ServerSocket serverSocket;
        int port = 8888;
        System.out.println("�����������ڱ�����"+port+"�˿��ϡ���������");
        try {
            serverSocket = new ServerSocket(port);
            //ѭ�����Լ���
            while (true){//���Ƕ��̵߳ģ�ͨ��ѭ���������socket��ʵ��
                //����8888�˿ڣ�ֱ���пͻ�����Ϣ������
                Socket socket=serverSocket.accept();
                //��ȡ������Ϣ
                InetAddress clientIP = socket.getInetAddress();//�������ӵĿͻ���IP
                int clientPort = socket.getPort();//�������ӵĿͻ��˶˿�
                System.out.println("�ͻ���["+clientIP+"]ͨ���˿�"+clientPort+"���ӵ�������");
                //���̳߳���ȡ��һ���߳��������������
                es.submit(new StartService(socket));

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
