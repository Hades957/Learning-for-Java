package zbifeng1219;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 4个线程进行压缩处理，压缩之后的文件，请放在一个固定的目录，请使用
 *	properties文件对这个目录进行配置
 * @author Bifeng
 *
 */
public class Compress extends Thread {

	//压缩流，分为输入流和输出流，而这边把一个文件压缩之后变成XXX.zip典型的使用输出流
	//压缩输出流与普通的输出流使用上面大同小异。
	public static void compress() throws Exception{
		InputStream in = new FileInputStream("d:/jdk8.chm");		
		//ZipOutputStream它是一个包装流，包装一个字节输出流
		//ZipOutputSTream(OutputStream)
		OutputStream out = new FileOutputStream("d:/jdk8.chm.zip");
		ZipOutputStream zot = new ZipOutputStream(out);
		
		zot.putNextEntry(new ZipEntry("jdk8888.chm"));//打开一个条目
		//直接吧in中的内容写到zot中
		byte[] buff = new byte[1024];
		int len = -1;
		while((len =in.read(buff))!=-1) {
			zot.write(buff,0,len);
		}
		
		in.close();
		zot.closeEntry();//写好信息，就关闭这个条目
		
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
