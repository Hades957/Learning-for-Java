package zbifeng1219;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 4���߳̽���ѹ������ѹ��֮����ļ��������һ���̶���Ŀ¼����ʹ��
 *	properties�ļ������Ŀ¼��������
 * @author Bifeng
 *
 */
public class Compress extends Thread {

	//ѹ��������Ϊ�������������������߰�һ���ļ�ѹ��֮����XXX.zip���͵�ʹ�������
	//ѹ�����������ͨ�������ʹ�������ͬС�졣
	public static void compress() throws Exception{
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
	
	@Override
	public void run() {
		try {
			Compress.compress();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
