import java.io.*;


public class Test3{
	public static void main(String[] args) throws Exception{
		OutputStream out = new FileOutputStream("aaa.txt");
		out.write('x');
		out.write('y');
		out.write('y');
		out.close();
	}
}