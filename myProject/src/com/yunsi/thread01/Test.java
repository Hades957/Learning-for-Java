package com.yunsi.thread01;

public class Test {
	public static void main(String[] args) {
		Printer p = new Printer();
		
		Student s = new Student("����һ��ѧ��",p);
		Worker w = new Worker("I am a worker",p);
		
		s.start();
		new Thread(w).start();
	}
}
