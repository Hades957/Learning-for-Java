import java.io.IOException;
import java.io.FileInputStream;
import java.io.BufferedInputStream;
import java.io.InputStream;

public class BufferedInputStreamTest{
	public static void main(String[] args){
		InputStream in = null;
		try{
			in = new FileInputStream("E:\\Downloads\\115Downloads\\HIFI极品测试天碟《弦烧之梦》抒情小提琴.7z");
			in = new BufferedInputStream(in);
			byte[] buff = new byte[8192];
			int len = -1;
			long start = System.currentTimeMillis();
			while((len = in.read(buff))!=-1){
				//
			}
			long end = System.currentTimeMillis();
			System.out.println("FileInputStream读取文件耗时："+(end-start)+"ms");
		}catch(IOException e){
			e.printStackTrace();
		}finally{
			if(in!=null){
				try{
					in.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}