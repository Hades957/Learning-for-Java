package com.yunsi.thread02;
/**
 * 学生带着他的个人简历去打印店打印
 * @author Administrator
 *
 */
public class Student extends Thread {

	private Printer p;
	private String doc;//学生需要打印的材料
	
	public Student(String doc,Printer p) {
		// TODO Auto-generated constructor stub
		this.p = p;
		this.doc = doc;
	}
	
	//重写Thread中的run方法
	public void run() {
		//学生使用这个打印机打印自己的材料
		synchronized(p) {
			p.doPrint(this.doc);
		}
		
	}

	
}
