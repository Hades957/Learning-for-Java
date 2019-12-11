/*
	将给定的字符串通过FileWriter写入文件中，
	通过FileReader读取文件中的字符 
*/

import java.io.*;
public class Demo02{
	public static void main(String[] args) throws IOException{
		test1();
		test2();
	}
	public static void test1() throws IOException{
		String str = "我是中国人124abc";
		File file = new File("a.txt");
		FileWriter fw = new FileWriter(file);
		//write(str),write(char[],int,int),write(str,int,int),..
		fw.write(str,0,str.length());
		fw.close();
	}
	public static void test2() throws IOException{
		File file = new File("a.txt");
		FileReader fr = new FileReader(file);
		char[] charArr = new char[10];
		int len = -1;
		while((len=fr.read(charArr))!=-1){
			String str = new String(charArr,0,len);
			System.out.print(str);
		}
		fr.close();
	}
}