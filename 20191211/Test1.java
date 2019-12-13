import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.BufferedReader;



public class Test1{
	public static void main(String[] args) throws IOException{
		testInputStreamReader();
	}
	public static void testInputStreamReader() throws IOException{
		InputStream in = new FileInputStream("C:\\Users\\Bifeng\\Desktop\\day08【File类、递归】.md");
		//handle(in);
		//handle2(in);
		handle3(in);
	}
	public static void handle(InputStream in) throws IOException{
		/*字节输入流对字母和数字支持好，可是遇到中文就会乱码，因为一个中文是两个字节*/
		InputStreamReader isr = new InputStreamReader(in);
		int data = -1;
		while((data = isr.read())!=-1){
			System.out.print((char)data);
		}
		isr.close();
	}
	public static void handle2(InputStream in) throws IOException{
		//字节数组缓存数据
		InputStreamReader isr = new InputStreamReader(in);
		char[] chars = new char[1024*8];
		int readLen = -1;
		while((readLen = isr.read(chars))!=-1){
			String str = new String(chars,0,readLen);
			System.out.print(str);
		}
		isr.close();
	}
	//按行读入字符串
	public static void handle3(InputStream in) throws IOException{
		InputStreamReader isr = new InputStreamReader(in);
		BufferedReader br = new BufferedReader(isr);
		char[] chars = new char[1024*8];
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);
		}
		br.close();
	}
}