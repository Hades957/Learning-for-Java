
/*
	集合并不是一个接口或者一个类，它是一堆接口和类组成的一个技术，与数组很相似
	数组的不足：
		1. 使用前必须要确定长度
		2. 数组中没有内置删除/更新等操作
	集合的出现对以上数组暴露出的不足的地方，全面改进了
	集合所在的包：java.util.*
	最顶层的类（接口）java.lang.Iterable(可迭代的) 只要知道两点
		1. 这个接口的子类对象可以使用foreach循环对他们进行遍历
		2. 这个接口的子类可以调用这个方法：Iterator iterator()
	Collection这个接口我们需要了解的信息：
		1. 它就是集合，并且有两个子类(子接口)List和Set
		2. 它的存在的意义就是在最大普遍性使用集合的地方使用它
		3. 它定义了List和Set公共的方法(都具备的),对List和Set有指导意义	
*/

import java.util.List;
import java.util.Collection;
import java.util.ArrayList;
public class Test1{
	public static void main(String[] args){
		// 子类对象当作父类对象使用（大部分情况下这样做是推荐的）
		
		test2();
		
	}
	// 集合中使用自动装箱和拆箱
	public static void test3(){
		List t = new ArrayList();
		int num = 300;
		t.add(num);
		Integer i = (Integer)t.get(0);
		System.out.println(i);	
	}
	public static void test2(){
		List list = new ArrayList();
		list.add(100);
		list.add(false);
		list.add(0,200);
		System.out.println(list);
		List list2 = new ArrayList();
		list2.add(300);list2.add(400);
		list.addAll(list2);
		System.out.println("list.addAll"+list);
		list.add(list2);
		System.out.println("list.add"+list);  
		System.out.println(list.set(2,true));
		System.out.println(list);
	}
}