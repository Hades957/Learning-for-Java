/*
 
*/


import java.io.*;
public class Demo01{
	public static void main(String[] args) throws IOException{
		test2();
		//test1();
		
	}
	public static void test1() throws IOException{
		FileInputStream fis = new FileInputStream("E:\\Software\\EditPlus5202450x64SC.zip");
		int data = -1;
		long start = System.currentTimeMillis();
		while((data = fis.read())!=-1){
		}
		long end = System.currentTimeMillis();
		fis.close();
		System.out.println("用时："+(end-start)+"ms");
	}
	public static void test2() throws IOException{
		FileInputStream fis = new FileInputStream("E:\\Software\\jdk-8u231-windows-x64.exe");
		BufferedInputStream bis = new BufferedInputStream(fis);
		byte[] arr = new byte[210*1024*1024];
		int len ;
		long start = System.currentTimeMillis();
		while((len =bis.read(arr))!=-1){
		}
		long end = System.currentTimeMillis();
		System.out.println("用时："+(end-start)+"ms");
	}
}