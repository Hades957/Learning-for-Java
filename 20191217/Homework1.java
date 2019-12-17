/*
	给定一个指定的文件夹，给其中文件的数量按照时间年月日进行统计排序之后，写到一个物理文件中
	TreeMap
*/
import java.io.*;
import java.util.*;
import java.text.SimpleDateFormat;
public class Homework1{
	public static void main(String[] args){
		try(
		PrintWriter pw = new PrintWriter(new FileOutputStream("data.txt"));){
			String path = "Demo";
			File file = new File(path);
			//TreeMap存储“时间”->“数量”
			Map<String,Integer> map = new TreeMap();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			File[] fs = file.listFiles();
			for(File f : fs){
				long time = f.lastModified();
				//对时间进行处理
				String date = sdf.format(time).toString();
				if(map.containsKey(date)){
					int i = map.get(date);
					map.put(date,++i);
				}else{
					map.put(date,1);	
				}
					
			}
			Set set = map.entrySet();
			Iterator it = set.iterator();
			while(it.hasNext()){
				Map.Entry obj = (Map.Entry)it.next();
				pw.println(obj.getKey()+" "+obj.getValue());
				//System.out.println(it.next());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
	}
}