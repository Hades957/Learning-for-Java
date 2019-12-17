import java.util.*;

class Student{
	private String name;
	private int age;
	private int money;
	public Student(String name,int age,int money){
		this.name=name;
		this.age=age;
		this.money=money;
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
	public int getMoney(){
		return this.money;
	}
	public void setMoney(int money){
		this.money=money;
	}

	public String toString(){
		return "姓名："+this.name+" 年龄："+this.age+" 生活费："+this.money;
	}
}
public class TestStudentSort{
	public static void main(String[] args){
		test1();
	}

	/*
		对自定义对象Student进行排序
		排序规则：根据年龄降序排序，年龄相同的情况下，生活费升序排序
	
	*/
	//带参数排序
	public static void test1(){
		Comparator comp = new Comparator(){
			public int compare(Object o1,Object o2){
				if(o1!=null && o2!=null){
					Student s1 = (Student)o1;
					Student s2 = (Student)o2;
					/*if(s1.getAge()>s2.getAge()){
						return -1;
					}else if(s1.getAge()<s2.getAge()){
						return 1;
					}else{
						if(s1.getMoney()>s2.getMoney()){
							return 1;
						}else if(s1.getMoney()<s2.getMoney()){
							return -1;
						}else{
							return 1;
						}
					}*/
					
					//return s1.getAge()>s2.getAge()?-1:s1.getAge()<s2.getAge()?1:s1.getMoney()>s2.getMoney()?1:s1.getMoney()<s2.getMoney()?-1:1;
					return s1.getAge()==s2.getAge()?(s1.getMoney()==s2.getMoney()?(1):s1.getMoney()-s2.getMoney()):s2.getAge()-s1.getAge();
					
				}
				return 0;
			}
		};
		Set s = new TreeSet(comp);
		Student s1 = new Student("姓名1",18,4000);		
		Student s2 = new Student("姓名2",17,3500);		
		Student s3 = new Student("姓名3",17,3000);		
		Student s4 = new Student("姓名4",20,5000);
		Student s5 = new Student("姓名5",17,3000);
		Student s6 = new Student("姓名6",18,4500);
		s.add(s1);s.add(s2);s.add(s3);s.add(s4);s.add(s5);s.add(s6);

		Iterator it = s.iterator();
		while(it.hasNext()){
			System.out.println(it.next());
		}
	}

	//不带参数排序

}