/*
	创建一个文件/文件夹
	删除文件/文件夹
	获取文件/文件夹
	判断文件/文件夹是否存在
	对文件夹进行遍历
	获取文件的大小	
	
	File类是一个与系统无关的类，任何的操作系统都可以使用
这个类中的方法


*/

import java.io.File;
public class FileDemo{
	public static void main(String[] args){
		//test1(); // File中的静态方法
		//test2("c:","a.txt"); // File中的构造方法	
		test3();//File中的常用方法
		
	}
	/*
	

	*/
	static void test3(){
		
	}



	static void test2(String parent,String child){
		/*	构造方法主要看其参数
		1. public File(String pathname)
		通过将给定的路径名字符串转换为抽象路径名来创建新的File实例。 如果给定的字符串是空字符串，则结果是空的抽象路径名。 
			参数 pathname - 路径名字符串 
			异常 NullPointerException - 如果 pathname参数是 null */
		//路径可以是文件结尾，也可以是文件夹结尾；可以是相对路径，也可以是绝对路径；可以存在，也可以不存在；
		//创建File对象，只是将字符串路径封装成File对象，不考虑路径的真假情况
		File f1 = new File("..\\20191207\\hello.txt");
		System.out.println(f1);//打印的就是上面传递给f1的路径，所以File类重写了toString()方法
		File f2 = new File("C:\\program files");//以文件夹结尾，同样可以
		System.out.println(f2);

		/*2.public File(String parent,String child)
		从父路径名字符串和子路径名字符串创建新的File实例。 
		如果parent是null则创建新的File实例，就像在给定的child路径名字符串上调用单参数File构造函数一样。否则，将使用parent路径名字符串来表示目录，并将child路径名字符串用于表示目录或文件。 如果child路径名字符串是绝对的，那么它将以系统相关的方式转换为相对路径名。 如果parent是空字符串，则通过将child转换为抽象路径名并根据系统相关的默认目录解析结果来创建新的File实例。 否则，每个路径名字符串将转换为抽象路径名，并且子抽象路径名将针对父对象进行解析。 
		参数 parent - 父路径名字符串 child - 子路径名字符串
			把路径分成两个部分，更加灵活 
		异常 NullPointerException - 如果 child是 null */
		//String parent = null;
		File f4 = new File(parent,"hello.txt");
		System.out.println("f4:"+f4);
		System.out.println("parent是空字符串:"+new File("","program\\hello.txt"));
		
		System.out.println(new File(parent,child));
		
		/*3. public File(File parent,String child)
		从父抽象路径名和子路径名字符串创建新的File实例。 
		如果parent是null则创建新的File实例，就像在给定的child路径名字符串上调用单参数File构造函数一样。否则，采用parent抽象路径名来表示目录，并将child路径名字符串用于表示目录或文件。 如果child路径名字符串是绝对的，那么它将以系统相关的方式转换为相对路径名。 如果parent是空的抽象路径名，那么新的File实例是通过将child转换为抽象路径名并根据系统相关的默认目录解析结果来创建的。 否则，每个路径名字符串将转换为抽象路径名，并且子抽象路径名将针对父对象进行解析。 
		参数 parent - 父抽象路径名 child - 子路径名字符串 
		异常 NullPointerException - 如果 child是 null */
		// 因为parent是File类型，我们可以对他进行一些操作后，再创建一个File对象
		File p = new File("c:");
		File file = new File(p,"Hello.java");
		System.out.println("(File parent,String child)"+file);
		
	}
	static void test1(){
		String pathSeparator = File.pathSeparator;
		System.out.println(pathSeparator);	//路径分隔符	
		char pathSeparatorChar = File.pathSeparatorChar;
		System.out.println(pathSeparatorChar);
		System.out.println(File.separator); //与系统相关的默认名称分隔符
		System.out.println(File.separatorChar);
	}
} 