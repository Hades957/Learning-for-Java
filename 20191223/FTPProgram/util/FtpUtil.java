package com.yunsi.ftpProgram.util;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * FTP工具类
 * 包含：
 * 1. 文件上传
 * 2. 文件下载
 * 3. 显示文件配置的FTP服务器根目录的所有文件
 */
public class FtpUtil extends Thread{
    public static void directory(Socket socket) {

    }

    /**
     * 文件上传
     *
     * @param pathName ftp服务器保存地址
     * @param fileName 上传到服务器的文件名
     * @param in       输入文件流
     * @return 上传成功与否
     */
    public boolean uploadFile(String pathName, String fileName, InputStream in) {
        return false;
    }

    /**
     * 文件下载
     * @param pathName  ftp服务器文件目录
     * @param fileName  文件名称
     * @param localPath 下载后的文件路径
     * @return  下载成功与否
     */
    public boolean downloadFile(String pathName, String fileName, String localPath) {
        return false;
    }

    public void reverse(){


    }


}
