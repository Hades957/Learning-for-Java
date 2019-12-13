
class Dog implements Cloneable{
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


class Student implements Cloneable{
	public String name;
	public int age;
	public Dog dog;
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

public class DemoObjectClone{
	public static void main(String[] args){
		Student stu1 = new Student();		
		Dog dog = new Dog();
		dog.name = "Yellow";

		stu1.name = "aaa";
		stu1.age = 18;
		stu1.dog = dog;

		Student stu2 = (Student)stu1.clone();
		System.out.println("s1.name:"+stu1.name+" s1.age:"+stu1.age
			+" s1.dog"+stu1.dog.name+stu1.dog);
		System.out.println("s2.name:"+stu2.name+" s2.age:"+stu2.age
			+" s2.dog"+stu2.dog.name+stu2.dog);
	}
}