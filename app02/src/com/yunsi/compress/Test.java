package com.yunsi.compress;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class Test {

	public static void main(String[] args) throws Exception{
		//ѹ��������Ϊ�������������������߰�һ���ļ�ѹ��֮����XXX.zip���͵�ʹ�������
		//ѹ�����������ͨ�������ʹ�������ͬС�졣
		
		InputStream in = new FileInputStream("d:/jdk8.chm");
		
		//ZipOutputStream����һ����װ������װһ���ֽ������
		//ZipOutputSTream(OutputStream)
		OutputStream out = new FileOutputStream("d:/jdk8.chm.zip");
		ZipOutputStream zot = new ZipOutputStream(out);
		
		zot.putNextEntry(new ZipEntry("jdk8888.chm"));//��һ����Ŀ
		//ֱ�Ӱ�in�е�����д��zot��
		byte[] buff = new byte[1024];
		int len = -1;
		while((len =in.read(buff))!=-1) {
			zot.write(buff,0,len);
		}
		
		in.close();
		zot.closeEntry();//д����Ϣ���͹ر������Ŀ
		
		zot.close();
	}
}
