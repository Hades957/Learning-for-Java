/*
	演示Properties功能
	1.就是Map的子类，有两个方法
		String getProperty(String key)
		void setProperty(String key,String value)
	2.它还具备读取特定格式文件内容的能力
		void load(InputStream)
		void load(Reader)
*/
import java.util.Properties;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.Reader;
import java.io.IOException;
public class TestProperties{
	public static void main(String[] args){
		//test1();
		//test2();
		test3();
	}

	/*
		为了解决Properties读取properties文件中信息的中文乱码问题，在不适用字符流的情况下，还可以使用jdk中提供的工具：native2ascii.exe，可以把本地的编码转成十六进制的编码，还是使用load(InputStream)只不过InputStream对应的这个文件，必须使用native2ascii.exe工具转换一下
	*/
	public static void test3(){
		Properties props = new Properties();
		try(InputStream in = new FileInputStream("database_cn.properties");){
			props.load(in);
			System.out.println(props);
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	/*
		使用Properties类读取XXX.properties这种特殊格式的文本文件
		如果properties文件中有中文，使用字节输入流就会出现乱码问题，
			1.使用字符输入流
	*/

	public static void test2(){
		Properties props = new Properties();
		/*try(InputStream in = new FileInputStream("database.properties");
		Reader r = new InputStreamReader(in);
		){*/
		//当class文件与database.properties在同一个目录的时候，还可以这样获取输入流
		try(InputStream in = TestProperties.class.getResourceAsStream("/database.properties");
		Reader r = new InputStreamReader(in);
		){
			props.load(r);
			System.out.println(props);
		}catch(IOException e){
			e.printStackTrace();
		}
	}

	//演示它的方法
	public static void test1(){
		Properties props = new Properties();
		props.setProperty("name","美国");
		props.setProperty("name","中国");
		props.put("age","30");//Map的方法
		props.setProperty("addr","江苏");

		System.out.println(props);

		//String name = props.get("name");//报错

		//独有方法
		String name = props.getProperty("name");
		System.out.println(name);
		//getProperty重载方法，第二个参数意思就是当第一个参数作为键找不到值时，就用第二个参数做为方法的返回值
		String addr = props.getProperty("addr","南京");
		System.out.println(addr);
	}
}