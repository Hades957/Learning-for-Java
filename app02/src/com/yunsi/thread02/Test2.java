package com.yunsi.thread02;

public class Test2 {

	public static void main(String[] args) {
		//���ĴΣ��и����󣬶������synchronized�������䡣
		//���2���̷ֱ߳����һ��Printer���������,��ʱPrinter������doPrint��������synchronized
		
		Printer p1 = new Printer();
		Printer p2 = new Printer();
		
		Student s = new Student("����ѧ��",p1);
		Worker w = new Worker("I  am worker.",p2);
		
		s.start();
		new Thread(w).start();
	}
}
