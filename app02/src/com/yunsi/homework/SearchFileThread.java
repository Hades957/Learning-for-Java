package com.yunsi.homework;

import java.io.File;
import java.util.List;
import java.util.Properties;

/**
 * 查找文件线程
 * @author Administrator
 *
 */
public class SearchFileThread extends Thread {

	//临界区
	private List<File> filesList;
	//配置信息
	private Properties props;
	
	public SearchFileThread(String string, List<File> filesList, Properties props) {
		super(string);
		this.filesList = filesList;
		this.props = props;
	}
	
	@Override
	public void run() {
		//查找某个目录（来自于配置参数props中），是不停的查找
		String searchDir = props.getProperty("searchDir");
		
		doSearch(searchDir);
		
		System.out.println(getName()+"查找文件完毕，我结束了。。。。。。。");
	}
	
	private void doSearch(String dir) {
		if(dir!=null && !"".equals(dir)) {
			File fDir = new File(dir);
			if(fDir.isFile()) {
				//直接放入临界区中，同时把休息区中的那些压缩线程给叫醒
				synchronized(filesList) {
					filesList.add(fDir);
					filesList.notifyAll();
					System.out.println(getName()+" 找到 "+fDir.getPath());
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
