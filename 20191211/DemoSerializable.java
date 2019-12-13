/*
	clone是Object类中的方法，作用正如他的名字那样，复制一个对象
	需要clone的类要实现Cloneable接口，若需要Clone的类中含有其他的类
		1)其他的类没有实现Cloneable接口：只能浅拷贝，复制的对象中的此类的对象指向同一个内存地址
		2)包含的类实现了Cloneable接口：深拷贝，将创建两个独立的不同的对象
	1/实现Cloneable接口
	2/重写clone方法 将访问修饰符从protected扩大到public
*/
import java.io.Serializable;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
class Dog implements Serializable,Cloneable{
	public String name;
	
	public Object clone(){
		Object obj = null;
		try{
			obj = super.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return obj;
	}
	
}
class Student implements Serializable,Cloneable{
	public String name;
	public int age;
	public Dog dog;
	//Getter.Setter...
	public String showInfo(){
		return "name="+name+" age="+age+" dog="+dog+" dog的属性:"+dog.name;
	}
	//重写clone方法
	public Object clone(){
		Object cloneObj = null;
		try{
			cloneObj = super.clone();
			Student s = (Student)cloneObj;
			s.dog = (Dog)(s.dog.clone());
			
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return cloneObj;
	}
}

public class DemoSerializable{
	public static void main(String[] args){
		//通过new复制一个对象
		Dog dog1 = new Dog();
		dog1.name = "小狗";
		Dog dog2 = new Dog();
		dog2.name = dog1.name;
		//System.out.println("dog1:"+dog1.name+" dog2:"+dog2.name);
		//通过序列化复制一个对象
		Student s1 = new Student();
		
		s1.name = "China";
		s1.age = 70;
		s1.dog = dog1;
		Student s2 = (Student)copyBySerializable(s1);
		//System.out.println("s2.name:"+s2.name+" s2.age:"+s2.age);
		

		//通过clone技术(来自于Object类)
		//protected Object clone() throws CloneNotSupportedException
		Student s3 = (Student)s1.clone();
		System.out.println("s3.name(clone):"+s3.name+" s3.age(clone):"+s3.age);
		Dog doga = s1.dog;
		Dog dogb = s3.dog;
		System.out.println("doga:"+doga);
		System.out.println("dogb:"+dogb);
	}
	
	public static Object copyBySerializable(Object obj){
		if(obj!=null){
			ObjectOutputStream oos = null;
			ObjectInputStream ois = null;		
			try{
				ByteArrayOutputStream bos = new ByteArrayOutputStream();
				oos = new ObjectOutputStream(bos);
				//将传入的对象序列化写入字节流中
				oos.writeObject(obj);
				oos.flush();
				byte[] datas = bos.toByteArray();	
				
				ByteArrayInputStream bis = new ByteArrayInputStream(datas);
				ois = new ObjectInputStream(bis);
				Object copyObject = ois.readObject();
				return copyObject;
			}catch(IOException | ClassNotFoundException e){
				e.printStackTrace();
			}finally{
				try{
					if(oos!=null)oos.close();
					if(ois!=null)ois.close();
				}catch(IOException e){
					e.printStackTrace();
				}
			}			
		}
		return null;
	}
}