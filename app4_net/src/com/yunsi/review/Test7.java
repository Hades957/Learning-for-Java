package com.yunsi.review;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

/**
 
 ��Set�е�Ԫ�����磨Student������������������2�����ԣ�,�����������������
 
 * @author Administrator
 *
 */

public class Test7 {
	public static void main(String[] args) {
		test();
	}
	public static void test() {
		Comparator<Student> comp= new Comparator<Student>(){
			public int compare(Student ss1,Student ss2) {
				//if(o1 instanceof Student&& o2 instanceof Student) {
//					Student ss1= (Student)o1;
//					Student ss2= (Student)o2;
					return ss1.age-ss2.age;
				//}
				//return 0;
			}
		};
		Set<Student> s = new TreeSet<>(comp);
		Student s1= new Student("����",24);
		Student s2= new Student("����",20);
		Student s3= new Student("����",22);
		s.add(s1);s.add(s2);s.add(s3);
		Iterator<Student> it = s.iterator();
		while(it.hasNext()) {
			Student ele= it.next();
			System.out.println(ele);
		}
	}
}
