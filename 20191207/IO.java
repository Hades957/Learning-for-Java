/**
 *IO��
 * 1. ���췽���ж��֣�����������Ҫ֪�����Ǹ��ļ��йصĹ��췽����
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
	/* ��ȡ�ļ��е����� */
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