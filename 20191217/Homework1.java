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
			Comparator comp = new Comparator(){
				public int compare(Object o1,Object o2){
					String[] data1 = ((String)o1).split("-");
					String[] data2 = ((String)o2).split("-");
					int year1 = Integer.parseInt(data1[0]);
					int year2 = Integer.parseInt(data2[0]);
					int month1 = Integer.parseInt(data1[1]);
					int month2 = Integer.parseInt(data2[1]);
					int day1 = Integer.parseInt(data1[2]);
					int day2 = Integer.parseInt(data2[2]);
					if(year1 == year2 ){
						if(month1 == month2){
							if(day1 == day2){
								return 1;
							}else{
								if(day1>day2){
									return 1;
								}else{
									return -1;
								}
							}
						}else{
							if(month1>month2){
								return 1;
							}else{
								return -1;
							}
						}
					}else{
						if(year1>year2){
							return 1;
						}else{
							return -1;
						}
					}
				}
			};
			Set set = map.keySet(comp);
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