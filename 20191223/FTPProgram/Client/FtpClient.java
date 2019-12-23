package com.yunsi.ftpProgram.Client;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

/**
 * 服务端工具类
 */
public class FtpClient {
    private Socket socket;//客户端
    private BufferedReader key = new BufferedReader(new InputStreamReader(System.in));
    Scanner input = new Scanner(System.in);
    public FtpClient(String serverIP, int port) {
        try {
            socket = new Socket(serverIP,port);
            System.out.println("客户端正在连接服务器......");
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
                //System.out.println("收到来自服务器的消息："+respMsg);

                //向服务器发送命令
                System.out.print("ftp>>>");
                String command = input.next();
                pw.println(command);
                System.out.println("命令发送成功，等待服务器处理！！！");

                //接收服务器处理结果
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
