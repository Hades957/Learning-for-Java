package com.yunsi.homework;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;
import java.util.UUID;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 压缩文件线程
 * @author Administrator
 *
 */
public class CompressFileThread extends Thread{

	//共享区域
	private List<File> filesList;
	//配置信息
	private Properties props;
	
	public CompressFileThread(String string, List<File> filesList, Properties props) {
		super(string);
		this.filesList = filesList;
		this.props= props;
	}

	@Override
	public void run() {
		//不停的从临界区中获取File对象进行压缩处理
		while(true) {
			try {
				synchronized(filesList) {
				//1.测试临界区中有没有File，没有就休息
					while(filesList.size()<=0) {
						System.out.println(getName()+" 暂时没有文件可悲压缩，等待。。。。");
						filesList.wait();
					}
				//2.休息好了（被通知之后），起来干活
					File file = filesList.remove(0);
					System.out.println(getName()+" 获取文件："+file.getPath()+" ，马上去压缩他。。。");
					//具体压缩这个file
					File newFile = getNewFilename(file);
					compressFile(file,newFile);
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	private File getNewFilename(File file) {
		// TODO Auto-generated method stub
		String compressDir = props.getProperty("compressingDir");
		File dir = new File(compressDir);
		if(!dir.exists()) {
			dir.mkdirs();
		}
		String filename = file.getName();
		filename+=".zip";
		File newFile = new File(dir,filename);
		if(newFile.exists()) {
			//存在的滑，就定义一个名称
			String prefix = filename;
			String suffix = "";
			int dot = -1;
			dot = filename.lastIndexOf(".");
			if(dot!=-1) {
				//XXX.YYY
				prefix = filename.substring(0,dot);
				suffix = filename.substring(dot);
			}
			
			String uuidStr = UUID.randomUUID().toString().replace("-", "");
			newFile = new File(dir,prefix+uuidStr+suffix);
		}
		return newFile;
	}

	//压缩文件
	private void compressFile(File file,File dest) {
		InputStream in = null;
		ZipOutputStream zos = null;
		try {
			in = new FileInputStream(file);
			zos = new ZipOutputStream(new FileOutputStream(dest));
			zos.putNextEntry(new ZipEntry(file.getName()));
			byte[] buff = new byte[1024];
			int len = -1;
			while((len = in.read(buff))!=-1) {
				zos.write(buff,0,len);
			}
			zos.closeEntry();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				if(zos!=null) {
					zos.close();
				}
				if(in!=null) {
					in.close();
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
