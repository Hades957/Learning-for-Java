import java.io.InputStreamReader;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;


import java.io.IOException;
/*
	InputStreamReader的构造方法：
		InputStreamReader(InputStream)
		InputStreamReader(InputStream,String charset)

	OutputStreamWriter的构造方法：
		OutputStreamWriter(OutputStream)

	上面这一对最大的特色，就是可以把字节流转成字符流，然后进行字符层面的操作。

	注意：OutputStreamWriter其实是可以被PrintWriter替换（代替）的。
	PrintWriter具备包装字节输出流的功能，与此同时对于写字符串信息而言换行还很轻松。

	PrintWriter构造方法：
		PrintWriter(OutputStream)
		PrintWriter(OutputStream,boolean autoflush)	
	
*/
public class Test1
{
	public static void main(String[] args)throws IOException{
		
//		testInputStreamReader();
//		testInputStreamReader2();//关于底层输入流中信息的编码问题（如果字符信息本身不是gbk编码，如果是utf-8那么我们使用平台默认的编码gbk还会有问题）

//		testOutputStreamWriter();
		//testPrintWriter();

		testPrintWriterAutoflush();
	}

	//演示PrintWriter，autoflush问题
	public static void testPrintWriterAutoflush()throws IOException{
		PrintWriter pw = new PrintWriter(new FileOutputStream("ccc.txt"),true);
		pw.print("ssss");
		//pw.flush();
		pw.println("bbbb");
		pw.println("cccc");
		pw.print("xxx");

		//故意忘记关闭pw了。
		pw.close();
	}

	//演示PrintWriter替换OutputStreamWriter
	public static void testPrintWriter()throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		
		//OutputStreamWriter w = new OutputStreamWriter(out);
		PrintWriter w = new PrintWriter(out);
		w.write('中');
		w.print('国');
		w.println();
		w.println("红红火火");
		w.write("\r\n哈哈哈");
		w.close();
	}

	//演示OutputStreamWriter
	public static void testOutputStreamWriter()throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		//假设OutputStream别人传递过来，我们要将一些文本信息写到它里面
		//正好信息中有中文字符，作为字节流输出流，那么中文字符写到输出流之后，会出现乱码
		/*
		out.write('中');
		out.write('国');
		out.write('a');
		out.write('b');
		out.write('c');
		out.close();
		*/
		//对字节输出流进行转换，变成字符输出流，那样就不会出现上面这个问题了。
		OutputStreamWriter w = new OutputStreamWriter(out);
		w.write('中');
		w.write('国');
		w.write('a');
		w.write('b');
		w.write('c');
		w.write("\r\n哈哈哈");
		w.close();
	}


	//故意读取的文件编码不是平台默认的gbk编码，是utf-8
	public static void testInputStreamReader2()throws IOException{
		//假设读取这个文件是utf-8编码，并且里面有中文字符信息
		InputStream in = new FileInputStream(new File("aaa_utf8.txt"));
		InputStreamReader isr =new InputStreamReader(in,"utf-8");
		int data = -1;
		while((data = isr.read())!=-1)
		{
			System.out.print((char)data);
		}
		isr.close();
	}

	//演示InputStreamReader
	public static void testInputStreamReader()throws IOException{
		//假设别人构造了一个InputStream对象，我们的代码需要读取内部内容
		//正好内容中可能有中文字符。读取的信息，我们需要进行再次处理。
		//这边的处理，就是直接控制台输出。
		InputStream in = new FileInputStream("作业.txt");
		//handle(in);
		//handle2(in);
		handle3(in);
	}

	private static void handle(InputStream in){
		//吧字节输入流转成字符输入流，对于那种2个字节的字符而言就不会有问题了。
		InputStreamReader isr = new InputStreamReader(in);
		try{
			int data = -1;
			while((data = isr.read())!=-1){
				System.out.print((char)data);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
			if(isr!=null)isr.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	private static void handle2(InputStream in){
		InputStreamReader isr = new InputStreamReader(in);
		try{
			char[] chs = new char[1000];
			int readLen = -1;
			while((readLen = isr.read(chs))!=-1){
				String str = new String(chs,0,readLen);//String(char[],int,int)
				System.out.print(str);
			}
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(isr!=null)isr.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
	private static void handle3(InputStream in){
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		try{
			String line = null;
			while((line = br.readLine())!=null){
				System.out.println(line);
			}
			
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			try{
				if(br!=null)br.close();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}