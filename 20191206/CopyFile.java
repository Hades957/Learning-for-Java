
import java.io.*;

public class CopyFile{
	public static void main(String[] args) {
		//实现文件复制
		//1.读取文件
		
		InputStream in = null;
		OutputStream out = null;
		try{
			in = new FileInputStream("jdk api 1.8.CHM");
			out = new FileOutputStream("jdk1.8.CHM3");
			int data = -1;
			long start = System.currentTimeMillis();
			//while((data=in.read())!=-1){
			//	out.write(data);
			//}
			byte[] arr = new byte[1024 * 8];
			int len;
			while((len = in.read(arr)) != -1) {       //如果忘记加arr,返回的就不是读取的字节个数,而是字节的码表值
				out.write(arr,0,len);
			}

			long end = System.currentTimeMillis();
			System.out.println(end-start+"ms");
		}catch(IOException e){
			System.out.println("异常发生了！");
		}finally{
			try{
				in.close();
			}catch(IOException e){}
			try{
				out.close();
			}catch(IOException e){}
			
		}
		
		
		//2.写入文件		
		
	}
}