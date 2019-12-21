package com.yunsi.homework;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class Test {

	public static void main(String[] args) {
		List<File> filesList = new ArrayList<File>();
		Properties props = new Properties();
		try(InputStream in = 
				Test.class.getResourceAsStream("/com/yunsi/homework/config.properties")){
			props.load(in);
		}catch(IOException e) {
			e.printStackTrace();
		}
		
		
		//压缩文件线程开工了
		CompressFileThread[] cfts = new CompressFileThread[4];
		for(int i=0;i<cfts.length;i++) {
			cfts[i] = new CompressFileThread("压缩线程"+(i+1),filesList,props);
			cfts[i].start();
		}
		
		SearchFileThread sft = new SearchFileThread("查找线程",filesList,props);
		sft.start();
	}
}
