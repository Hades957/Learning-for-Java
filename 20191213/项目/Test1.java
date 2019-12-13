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
	InputStreamReader�Ĺ��췽����
		InputStreamReader(InputStream)
		InputStreamReader(InputStream,String charset)

	OutputStreamWriter�Ĺ��췽����
		OutputStreamWriter(OutputStream)

	������һ��������ɫ�����ǿ��԰��ֽ���ת���ַ�����Ȼ������ַ�����Ĳ�����

	ע�⣺OutputStreamWriter��ʵ�ǿ��Ա�PrintWriter�滻�����棩�ġ�
	PrintWriter�߱���װ�ֽ�������Ĺ��ܣ����ͬʱ����д�ַ�����Ϣ���Ի��л������ɡ�

	PrintWriter���췽����
		PrintWriter(OutputStream)
		PrintWriter(OutputStream,boolean autoflush)	
	
*/
public class Test1
{
	public static void main(String[] args)throws IOException{
		
//		testInputStreamReader();
//		testInputStreamReader2();//���ڵײ�����������Ϣ�ı������⣨����ַ���Ϣ������gbk���룬�����utf-8��ô����ʹ��ƽ̨Ĭ�ϵı���gbk���������⣩

//		testOutputStreamWriter();
		//testPrintWriter();

		testPrintWriterAutoflush();
	}

	//��ʾPrintWriter��autoflush����
	public static void testPrintWriterAutoflush()throws IOException{
		PrintWriter pw = new PrintWriter(new FileOutputStream("ccc.txt"),true);
		pw.print("ssss");
		//pw.flush();
		pw.println("bbbb");
		pw.println("cccc");
		pw.print("xxx");

		//�������ǹر�pw�ˡ�
		pw.close();
	}

	//��ʾPrintWriter�滻OutputStreamWriter
	public static void testPrintWriter()throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		
		//OutputStreamWriter w = new OutputStreamWriter(out);
		PrintWriter w = new PrintWriter(out);
		w.write('��');
		w.print('��');
		w.println();
		w.println("�����");
		w.write("\r\n������");
		w.close();
	}

	//��ʾOutputStreamWriter
	public static void testOutputStreamWriter()throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		//����OutputStream���˴��ݹ���������Ҫ��һЩ�ı���Ϣд��������
		//������Ϣ���������ַ�����Ϊ�ֽ������������ô�����ַ�д�������֮�󣬻��������
		/*
		out.write('��');
		out.write('��');
		out.write('a');
		out.write('b');
		out.write('c');
		out.close();
		*/
		//���ֽ����������ת��������ַ�������������Ͳ������������������ˡ�
		OutputStreamWriter w = new OutputStreamWriter(out);
		w.write('��');
		w.write('��');
		w.write('a');
		w.write('b');
		w.write('c');
		w.write("\r\n������");
		w.close();
	}


	//�����ȡ���ļ����벻��ƽ̨Ĭ�ϵ�gbk���룬��utf-8
	public static void testInputStreamReader2()throws IOException{
		//�����ȡ����ļ���utf-8���룬���������������ַ���Ϣ
		InputStream in = new FileInputStream(new File("aaa_utf8.txt"));
		InputStreamReader isr =new InputStreamReader(in,"utf-8");
		int data = -1;
		while((data = isr.read())!=-1)
		{
			System.out.print((char)data);
		}
		isr.close();
	}

	//��ʾInputStreamReader
	public static void testInputStreamReader()throws IOException{
		//������˹�����һ��InputStream�������ǵĴ�����Ҫ��ȡ�ڲ�����
		//���������п����������ַ�����ȡ����Ϣ��������Ҫ�����ٴδ���
		//��ߵĴ�������ֱ�ӿ���̨�����
		InputStream in = new FileInputStream("��ҵ.txt");
		//handle(in);
		//handle2(in);
		handle3(in);
	}

	private static void handle(InputStream in){
		//���ֽ�������ת���ַ�����������������2���ֽڵ��ַ����ԾͲ����������ˡ�
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