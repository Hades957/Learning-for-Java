
class Dog implements Cloneable{
	public String name;

	public Dog(String name){
		this.name = name;
	}
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
class Student implements Cloneable{
	public String name;
	public int age;
	public Dog dog;
	public Student(String name,int age,Dog dog){
		this.name = name;
		this.age = age;
		this.dog = dog;
	}
	public Object clone(){
		Object cloneObj = null;
		try{
			cloneObj = super.clone();
			Student s = (Student)cloneObj;
			s.dog = (Dog)s.dog.clone();
		}catch(CloneNotSupportedException e){
			e.printStackTrace();
		}
		return cloneObj;
	}
}
public class DemoClone2{
	public static void main(String[] args){
		Student s1 = new Student("aaa",12,new Dog("Blue"));
		Student s2 =(Student)s1.clone();
		Student s3 =(Student)s1.clone();
		System.out.println("s1:"+s1+" s2:"+s2+" s3:"+s3);
		System.out.println("s1.dog:"+s1.dog+" s2.dog:"+s2.dog+" s3.dog:"+s3.dog);
	}
}