package com.yunsi.thread02;

public class Test2 {

	public static void main(String[] args) {
		//第四次，有个现象，对上面的synchronized做个补充。
		//如果2个线程分别持有一个Printer对象会怎样,及时Printer对象中doPrint方法加了synchronized
		
		Printer p1 = new Printer();
		Printer p2 = new Printer();
		
		Student s = new Student("我是学生",p1);
		Worker w = new Worker("I  am worker.",p2);
		
		s.start();
		new Thread(w).start();
	}
}
