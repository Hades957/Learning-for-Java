package com.yunsi.ftpProgram.util;

import jdk.internal.util.xml.impl.Input;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

/**
 * FTP������
 * ������
 * 1. �ļ��ϴ�
 * 2. �ļ�����
 * 3. ��ʾ�ļ����õ�FTP��������Ŀ¼�������ļ�
 */
public class FtpUtil extends Thread{
    public static void directory(Socket socket) {

    }

    /**
     * �ļ��ϴ�
     *
     * @param pathName ftp�����������ַ
     * @param fileName �ϴ������������ļ���
     * @param in       �����ļ���
     * @return �ϴ��ɹ����
     */
    public boolean uploadFile(String pathName, String fileName, InputStream in) {
        return false;
    }

    /**
     * �ļ�����
     * @param pathName  ftp�������ļ�Ŀ¼
     * @param fileName  �ļ�����
     * @param localPath ���غ���ļ�·��
     * @return  ���سɹ����
     */
    public boolean downloadFile(String pathName, String fileName, String localPath) {
        return false;
    }

    public void reverse(){


    }


}
