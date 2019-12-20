package com.yunsi;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class Homework01 {

	public static void main(String[] args) {
		calculate("D:\\ftpserver\\javase-1118\\day23-1218\\Test6.java");
	}
	
	public static void calculate(String filepath) {
		if(filepath!=null && !"".equals(filepath)){
			Map<Character,Integer> map = new HashMap<Character,Integer>();
			File f = new File(filepath);
			try(BufferedReader br = new BufferedReader(new FileReader(f));){
				String line = null;
				while((line = br.readLine())!=null) {
					//System.out.println(line);
					line = line.trim();
					if(!"".equals(line)) {
						for(int i=0;i<line.length();i++) {
							char ch = line.charAt(i);
							if(ch==' '||ch=='\t') {
								continue;
							}
							if(map.containsKey(ch)) {
								map.put(ch, map.get(ch)+1);
							}
							else {
								map.put(ch, 1);
							}
						}
					}
				}
			}catch(IOException e) {
				e.printStackTrace();
			}
			System.out.println(map);
			
			//查找Map中value中出现最多的数字
			int maxNum = 0;
			Collection<Integer> coll = map.values();
			for(Integer i : coll) {
				if(maxNum<i) {
					maxNum = i;
				}
			}
			System.out.println(maxNum);
			System.out.println("=================================");
			Set<Map.Entry<Character,Integer>> set = map.entrySet();
			for(Map.Entry<Character, Integer> me : set) {
				if(me.getValue()==maxNum) {
					System.out.println(me.getKey());
				}
			}
		}
	}

}
