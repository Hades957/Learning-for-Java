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
		
		
		//ѹ���ļ��߳̿�����
		CompressFileThread[] cfts = new CompressFileThread[4];
		for(int i=0;i<cfts.length;i++) {
			cfts[i] = new CompressFileThread("ѹ���߳�"+(i+1),filesList,props);
			cfts[i].start();
		}
		
		SearchFileThread sft = new SearchFileThread("�����߳�",filesList,props);
		sft.start();
	}
}
