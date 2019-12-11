/*
使用BufferedReader读取字符
注意：readLine会将读取到的换行去掉
	结尾以null为标记忆

*/
import java.io.Reader;
import java.io.FileReader;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.Writer;
public class Test1{
	public static void main(String[] args) throws IOException{
		Reader r = new FileReader("temp.txt");
		BufferedReader br = new BufferedReader(r);
		String line = null;
		while((line = br.readLine())!=null){
			System.out.println(line);//手动换行
		}
		br.close();

		//BufferedWriter有个方法void newLine()
		Writer w = new FileWriter("temp2.txt");
		BufferedWriter bw = new BufferedWriter(w);
		bw.write("我爱中国");
		bw.newLine();
		bw.write("我爱我家");
		bw.close();
	}
}