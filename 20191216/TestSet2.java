

import java.util.*;

public class TestSet2{
	public static void main(String[] args){
		//test1();
		test2();
	}
	
	//LinkedHashSet() 可以保证添加顺序
	public static void test1(){
		Set s = new HashSet();
		//不能重复
		//如果添加多个null，多个null最终会剔除后添加的，保留先添加的
		s.add(null);
		s.add(3);
		s.add(true);
		s.add(4);
		s.add(3);
		s.add(1);

		System.out.println(s);

		//不重复，且能保证添加顺序
		Set s1 = new LinkedHashSet();
		s1.add(null);
		s1.add(3);
		s1.add(true);
		s1.add(4);
		s1.add(3);
		s1.add(1);
		System.out.println(s1);
	}


	/*带排序功能的Set(也算是子类特征)->TreeSet
		排序功能其实是别人提供的，然后Set使用这个规则，关系到两个接口
		java.util.Comparator;->public abstract int compare(Object o1,Object o2);
			重写这个方法，定义排序规则,int值：0相同，正整数大于，负整数小于
		带排序功能的Set(实现类TreeSet),它的构造方法一个无参，一个带参数Comparator
	*/
	public static void test2(){
		Comparator comp = new Comparator(){
			public int compare(Object o1,Object o2){
				if(o1!=null && o2!=null){
					Integer i1 = (Integer)o1;
					Integer i2 = (Integer)o2;
					//return i1<i2?1:(i1>i2?-1:0);
					return i1-i2;
				}
				return 0;
			}
		};
		Set s = new TreeSet(comp);
		//添加5个数
		s.add(2);
		s.add(1);
		s.add(3);
		s.add(5);
		s.add(4);
		System.out.println(s);
		
	}
	
	//无参构造方法TreeSet，搭配java.lang.Comparable
	//需排序的对象所在的类实现Comparable接口，
	public static void test3(){
		Set s = new TreeSet();
		s.add(2);
		s.add(1);
		s.add(3);
		s.add(5);
		s.add(4);
		System.out.println(s);
	}
	
}