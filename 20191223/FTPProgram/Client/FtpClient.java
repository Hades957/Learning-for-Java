package com.yunsi.ftpProgram.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * ����˹�����
 */
public class FtpClient {
    private Socket socket;//�ͻ���
    private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
    Scanner input = new Scanner(System.in);
    public FtpClient(String serverIP, int port) {
        try {
            socket = new Socket(serverIP,port);
            System.out.println("�ͻ����������ӷ�����......");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void startRequest() {
        PrintWriter pw = null;
        BufferedReader br = null;
        try {
            br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            pw = new PrintWriter(socket.getOutputStream(),true);
            while(true) {
                String respMsg = br.readLine();
                System.out.println(respMsg);
                //System.out.println("�յ����Է���������Ϣ��"+respMsg);

                //���������������
                System.out.print("ftp>>>");
                String command = input.next();
                pw.println(command);
                System.out.println("����ͳɹ����ȴ���������������");

                //���շ�����������
                String solution = br.readLine();
                System.out.println(solution);
            }
        }catch(IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(socket != null)socket.close();
            }catch(IOException e) {
                e.printStackTrace();
            }
        }

    }

    public static void main(String[] args) {
        FtpClient tc = new FtpClient("192.168.10.51",8888);
        tc.startRequest();

    }
}
