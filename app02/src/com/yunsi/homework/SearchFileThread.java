package com.yunsi.homework;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * �����ļ��߳�
 * @author Administrator
 *
 */
public class SearchFileThread extends Thread {

	//�ٽ���
	private List<File> filesList;
	//������Ϣ
	private Properties props;
	
	public SearchFileThread(String string, List<File> filesList, Properties props) {
		super(string);
		this.filesList = filesList;
		this.props = props;
	}
	
	@Override
	public void run() {
		//����ĳ��Ŀ¼�����������ò���props�У����ǲ�ͣ�Ĳ���
		String searchDir = props.getProperty("searchDir");
		
		doSearch(searchDir);
		
		System.out.println(getName()+"�����ļ���ϣ��ҽ����ˡ�������������");
	}
	
	private void doSearch(String dir) {
		if(dir!=null && !"".equals(dir)) {
			File fDir = new File(dir);
			if(fDir.isFile()) {
				//ֱ�ӷ����ٽ����У�ͬʱ����Ϣ���е���Щѹ���̸߳�����
				synchronized(filesList) {
					filesList.add(fDir);
					filesList.notifyAll();
					System.out.println(getName()+" �ҵ� "+fDir.getPath());
				}
				
				
			}
			else if(fDir.isDirectory()) {
				File[] files = fDir.listFiles();
				if(files!=null && files.length>0) {
					for(File file : files) {
						doSearch(file.getPath());
					}
				}
			}
		}
	}

}
