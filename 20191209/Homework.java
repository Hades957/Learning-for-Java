/*
	1209
	使用对象流完成对象的复制操作，使用的过程中不希望有临时文件存在
*/

import java.io.*;
// 要想将对象转化成流，必须实现Serielizable空接口
// transient 修饰的属性不参与对象序列化
class Student implements Serializable{
	private String name;
	private int age;
	public Student(){}
	public Student(String name,int age){
		this.name=name;
		this.age=age;
	}
	public String getName(){
		return this.name;
	}
	public void setName(String name){
		this.name=name;
	}
	public int getAge(){
		return this.age;
	}
	public void setAge(int age){
		this.age=age;
	}
}
public class Homework{
	public static void main(String[] args) throws IOException,ClassNotFoundException{
		//创建Student对象
		/*
		Student stu = new Student("张三",29);
		Object obj = copyObject(stu);

		//对读取的对象进行还原
		Student ss = null;
		if(obj instanceof Student){
			ss = (Student)obj;
		}
		System.out.println("反序列化之后的stu: name="+ss.getName()+" age="+ss.getAge());
		*/
		String str = "abcdefg";
		Object obj = copyObject(str);
		System.out.println(obj);	
	}
	public static Object copyObject(Object obj) throws IOException,ClassNotFoundException{
		//创建OutputStream对象...OutputStream out = new ByteArrayOutputStream(byte[] buf, int offset, int length) 
		OutputStream out = new ByteArrayOutputStream();
		//转换成对象流...ObjectOutputStream(OutputStream in) 
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(obj);//NotSerializableException

		oos.flush();
		oos.close();
		

		//读取刚刚存入的stu对象
		//对OutputStream对象转型为ByteArrayOutputStream
		ByteArrayOutputStream bos = (ByteArrayOutputStream)out;
		//通过ToByteArray()将ByteArrayOutputStream对象转换成字节数组之后创建InputStream对象!!!为了不产生缓存文件
		InputStream is = new ByteArrayInputStream(bos.toByteArray());
		//创建对象输入流对象ois
		ObjectInputStream ois = new ObjectInputStream(is);
		//读出对象
		Object object = ois.readObject();
		is.close();
		
		
		return object;
		
	}
}