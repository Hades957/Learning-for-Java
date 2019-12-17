import java.io.*;
import java.util.*;


class Student{
	public String name;
	public int chineseScore;
	public int mathScore;
	public int sumScore;
	public Student(String name,int cs,int ms,int ss){
		this.name = name;
		this.chineseScore = cs;
		this.mathScore = ms;
		this.sumScore = ss;
	}
	public String toString(){
		return this.name+","+this.chineseScore+","+mathScore+","+sumScore;
	}
}

public class Homework3{
	public static void main(String[] args){
		readFile();
		writeFile();
	}
	public static void readFile(){
		try(
		BufferedReader br = new BufferedReader(new FileReader("data.txt"));
		PrintWriter pw = new PrintWriter(new FileWriter("calculation.txt",true));){
			String line = null;
			String[] data = null;
			String[] result = null;
			Comparator comp = new Comparator(){
				public int compare(Object o1,Object o2){
					if(o1!=null && o2!=null){
						Student s1 = (Student)o1;
						Student s2 = (Student)o2;
						if(s1.sumScore==s2.sumScore)return 1;
						else return s2.sumScore-s1.sumScore;
					}
					return 1;
				}
			};
			Set s = new TreeSet(comp);
			int sumScore = 0;
			while((line=br.readLine())!=null){
				if(line.startsWith("#"))continue;
				data = line.split(",");
				String name = data[0];
				int chineseScore = Integer.parseInt(data[1]);
				int mathScore = Integer.parseInt(data[2]);
				sumScore = chineseScore + mathScore;
				Student stu = new Student(name,chineseScore,mathScore,sumScore);
				s.add(stu);
			}
			Iterator it = s.iterator();
			while(it.hasNext()){
				//System.out.println(it.next());
				pw.println(it.next());
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public static void writeFile(){
		
	}
	
}