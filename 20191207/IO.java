/**
 *IO流
 * 1. 构造方法有多种，现在我们需要知道的是跟文件有关的构造方法：
 *	---FileInputStream(File file)
 *	---FileInputStream(FileDescriptor fdObj)
 *	---FileInputStream(String name)
 */

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.File;
public class IO{
	public static void main(String[] args) throws Exception{
		test1();
	}
	/* 读取文件中的内容 */
	static void test1() throws Exception{
		File f = new File("hello.txt");
		System.out.println(f);
		InputStream in = new FileInputStream(f);
		System.out.println(in);
		int data;
		while((data=in.read())!=-1){
			System.out.print((char)data);
		}
	}
}