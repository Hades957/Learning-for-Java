package com.yunsi.ftpProgram.Server;

import com.yunsi.ftpProgram.util.FtpUtil;
import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class StartService implements Runnable {
    private Socket socket = null;
    StartService(Socket socket) {
        this.socket = socket;
    }

    /**
     * 1. ��ͻ�����ʾ���ӷ������ɹ�
     * 2. ���տͻ���ָ�
     *      1)dir
     *      2)put
     *      3)get
     *      4)pwd
     */
    @Override
    public void run(){
        //1. ��ͻ�����ʾ���ӳɹ�
        try {
            PrintWriter pw = new PrintWriter(this.socket.getOutputStream(),true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String success = "*************���ӷ������ɹ�*************";
            pw.println(success);
            //���ͻ��˽���
            while(true){
                String recMsg = br.readLine();
                //�յ���exit���˳�ѭ������
                if(recMsg.equalsIgnoreCase("exit"))break;
                //�յ���dir���������ķ�Ӧ--��ʾ��ǰ���õ�FTP��������Ŀ¼��ȫ·��
                else if(recMsg.equalsIgnoreCase("dir")){
                    //����dir������߼�
                    FtpUtil.directory(socket);
                }
                //�յ���help�����ߡ�?���������ķ�Ӧ--��ʾ��ʵ�ֵ�����İ���
                else if(recMsg.equalsIgnoreCase("help")||recMsg.equalsIgnoreCase("?")){
                    //TODO
                }
                //�յ���put���������ķ�Ӧ--�ϴ��ļ�
                else if(recMsg.equalsIgnoreCase("put")){
                    //TODO
                }
                //�յ���get���������ķ�Ӧ--�����ļ�
                else if(recMsg.equalsIgnoreCase("get")){
                    //TODO
                }
            }
            //�ر�����
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Start Service");
        System.out.println(Thread.currentThread().getName());
        try {
            Thread.sleep(60000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
