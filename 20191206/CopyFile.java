
import java.io.*;

public class CopyFile{
	public static void main(String[] args) {
		//ʵ���ļ�����
		//1.��ȡ�ļ�
		
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
			while((len = in.read(arr)) != -1) {       //������Ǽ�arr,���صľͲ��Ƕ�ȡ���ֽڸ���,�����ֽڵ����ֵ
				out.write(arr,0,len);
			}

			long end = System.currentTimeMillis();
			System.out.println(end-start+"ms");
		}catch(IOException e){
			System.out.println("�쳣�����ˣ�");
		}finally{
			try{
				in.close();
			}catch(IOException e){}
			try{
				out.close();
			}catch(IOException e){}
			
		}
		
		
		//2.д���ļ�		
		
	}
}