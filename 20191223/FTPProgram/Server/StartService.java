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
     * 1. 向客户端显示连接服务器成功
     * 2. 接收客户端指令：
     *      1)dir
     *      2)put
     *      3)get
     *      4)pwd
     */
    @Override
    public void run(){
        //1. 向客户端显示连接成功
        try {
            PrintWriter pw = new PrintWriter(this.socket.getOutputStream(),true);
            BufferedReader br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            String success = "*************连接服务器成功*************";
            pw.println(success);
            //跟客户端交互
            while(true){
                String recMsg = br.readLine();
                //收到‘exit’退出循环交互
                if(recMsg.equalsIgnoreCase("exit"))break;
                //收到‘dir’服务器的反应--显示当前配置的FTP服务器根目录的全路径
                else if(recMsg.equalsIgnoreCase("dir")){
                    //处理dir命令的逻辑
                    FtpUtil.directory(socket);
                }
                //收到‘help’或者‘?’服务器的反应--显示以实现的命令的帮助
                else if(recMsg.equalsIgnoreCase("help")||recMsg.equalsIgnoreCase("?")){
                    //TODO
                }
                //收到‘put’服务器的反应--上传文件
                else if(recMsg.equalsIgnoreCase("put")){
                    //TODO
                }
                //收到‘get’服务器的反应--下载文件
                else if(recMsg.equalsIgnoreCase("get")){
                    //TODO
                }
            }
            //关闭连接
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
