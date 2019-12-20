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
 * ѹ���ļ��߳�
 * @author Administrator
 *
 */
public class CompressFileThread extends Thread{

	//��������
	private List<File> filesList;
	//������Ϣ
	private Properties props;
	
	public CompressFileThread(String string, List<File> filesList, Properties props) {
		super(string);
		this.filesList = filesList;
		this.props= props;
	}

	@Override
	public void run() {
		//��ͣ�Ĵ��ٽ����л�ȡFile�������ѹ������
		while(true) {
			try {
				synchronized(filesList) {
				//1.�����ٽ�������û��File��û�о���Ϣ
					while(filesList.size()<=0) {
						System.out.println(getName()+" ��ʱû���ļ��ɱ�ѹ�����ȴ���������");
						filesList.wait();
					}
				//2.��Ϣ���ˣ���֪֮ͨ�󣩣������ɻ�
					File file = filesList.remove(0);
					System.out.println(getName()+" ��ȡ�ļ���"+file.getPath()+" ������ȥѹ����������");
					//����ѹ�����file
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
			//���ڵĻ����Ͷ���һ������
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

	//ѹ���ļ�
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
