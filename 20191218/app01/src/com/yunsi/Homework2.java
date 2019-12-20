package com.yunsi;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Comparator;
import java.util.Date;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

/**
 * 对一个给定的文件夹进行统计，求出年月日，所对应的文件个数，并且写到一个物理文件中，格式如下：
 * 	2019-10-10,6
 * 	2019-10-9,3
 * 	2018-1-1,20
 * 	......
 * @author Administrator
 *
 */
public class Homework2 {

	public static void main(String[] args) {
		String path = "D:\\ftpserver\\javase-1118\\day23-1218\\新建文件夹";
		handle(path);
	}

	private static void handle(String path) {
		Comparator<String> comp = new Comparator<String>() {
			private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			@Override
			public int compare(String o1, String o2) {
				// TODO Auto-generated method stub
				try {
					Date d1 = sdf.parse(o1);
					Date d2 = sdf.parse(o2);
					return d1.before(d2) ? 1 :(d1.after(d2)?-1:0);
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return 0;
			}
		};
		TreeMap<String,Integer> map = new TreeMap<String,Integer>(comp);
		File f = new File(path);
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			if(files!=null && files.length>0) {
				for(File file : files) {
					if(file.isFile()) {
						//dateStr中只包含年月日信息（2000-1-1)
						String dateStr = getDateStr(file.lastModified());
						System.out.println(dateStr+" "+file.getName());
						if(map.containsKey(dateStr)) {
							map.put(dateStr, map.get(dateStr)+1);
						}
						else {
							map.put(dateStr, 1);
						}
					}
				}
			}
		}
		System.out.println(map);
		
		writeToFile(map,path);
	}

	private static void writeToFile(TreeMap<String, Integer> map, String path) {
		File f = new File(path);
		File newFile = new File(f.getParent(),f.getName()+"_copy");
		try(PrintWriter pw = new PrintWriter(newFile);){
			Set<Map.Entry<String,Integer>> set = map.entrySet();
			for(Map.Entry<String, Integer> me : set) {
				pw.println(me.getKey()+","+me.getValue());
			}
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}

	private static String getDateStr(long lastModified) {
		Date d = new Date(lastModified);
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		String resultStr = sdf.format(d);
		return resultStr;
	}
	
}
