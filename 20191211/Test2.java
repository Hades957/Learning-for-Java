
import java.io.PrintWriter;
import java.io.IOException;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.OutputStream;
public class Test2{
	public static void main(String[] args)throws IOException{
		//testOutputStreamWriter();
		//testPrintWriter();
		testPrintWriterAutoflush();
	}
	public static void testPrintWriterAutoflush() throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		// PrintWriter(FileOutputStream,boolean) 如果boolean为true则遇到println会自动flush
		PrintWriter pw = new PrintWriter(out,true);
		pw.write('中');
		pw.flush();
		pw.print('国');
		//pw.println('我');
		pw.write("\r\n哈哈");


	}
	public static void testPrintWriter() throws IOException{
		OutputStream out = new FileOutputStream("bbb.txt");
		PrintWriter pw = new PrintWriter(out);
		pw.write('中');
		pw.print('国');
		pw.println('我');
		pw.write("\r\n哈哈");
		pw.close();

	}
	public static void testOutputStreamWriter() throws IOException{
		OutputStream out = new FileOutputStream("a.txt");
		OutputStreamWriter w = new OutputStreamWriter(out);
		w.write('中');
		w.write("\r\n");
		w.write('a');
		w.close();
	}
}