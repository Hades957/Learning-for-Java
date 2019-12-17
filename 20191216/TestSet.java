/*
	Set常用实现类：
		HashSet/LinkedHashSet/TreeSet
	
		HashSet:基本上元素不能重复，不能保证添加顺序(下标变得没有什么意义)，
*/
import java.util.Set;
import java.util.HashSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

class Student
{
	public String name;
	public int age;
	public Student(String name,int age){
		this.name = name;
		this.age = age;
	}	
	//重写hashCode()
	public int hashCode(){
		int code = this.age;
		return code;
	}
	//重写equals()
	public boolean equals(Object obj){
		if(obj!=null && obj instanceof Student){
			Student stu = (Student)obj;
			if(this.name!=null && this.name.equals(stu.name)){
				return true;
			}
		}
		return false;
	}
}


public class TestSet{
	public static void main(String[] args){
		test3();
	}
	//测试Set中怎么实现元素不重复
	public static void test3(){
		Student s1 = new Student("aaa",19);
		Student s2 = new Student("aaa",19);
		Set s = new HashSet();
		s.add(s1);
		s.add(s2);

		System.out.println(s.size());
		System.out.println(s);
	}

	//演示Set的特征
	// 1. 不能保证添加顺序 2. 不能重复
	public static void test1(){
		Set s =  new HashSet();
		s.add("a");//boolean add(Object)
		s.add("c");
		s.add(3);
		s.add(4);
		s.add(true);
		s.add(true);
		System.out.println(s); //直接输出Set对象，直接调用toString()方法。
	}
		
	//演示Set的常用方法
	public static void test2(){
		Set s = new HashSet();
		//添加
		s.add(1);
		s.add("abc");
		
		List lst = new ArrayList();
		lst.add(3);lst.add(4);
		s.addAll(lst);

		System.out.println(s);
		//修改(替换)-没有这个功能

		//查询(都与下标无关)
		System.out.println("\n\nforEach循环遍历Set:");
		for(Object ele : s){
			System.out.println(ele+" ");
		}
		
		System.out.println("\n\nIterator对Set进行遍历：");
		Iterator it = s.iterator();
		while(it.hasNext()){
			Object ele = it.next();
			System.out.println(ele+" ");
		}
		//删除(没有下标)
		System.out.println();
		s.remove(3);
		System.out.println(s);

		//其他方法
		int size = s.size();
		boolean ie = s.isEmpty();
		
	}
}