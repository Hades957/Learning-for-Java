
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.IOException;
public class Test1{
	public static void main(String[] args) throws IOException{
		//test2();
		test3();
	}
	public static void test2() throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		byte[] bytes = new byte[36];
		for(int i=0;i<26;i++){
			bytes[i]=(byte)(i+97);
		}
		for(int i=26;i<bytes.length;i++){
			bytes[i]=(byte)(i+22);
		}
		out.write(bytes);
		
	}
	public static void test3(){
		
	}
}