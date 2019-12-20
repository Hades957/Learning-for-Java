package com.yunsi.thread01;

public class Test {

	public static void main(String[] args) {
		Printer p = new Printer();
		
		Object lock = new Object();
		
//		Student s = new Student("我是学生1，来自某个学校",p);	
//		Worker w = new Worker("I am a worker,from XXX company!",p);//Runnable子类
//
//		//启动线程
//		s.start();
//		new Thread(w).start();
		
		//第一次改进，在Printer中的doPrint方法上面既没有加上synchronized修饰方法，也没有使用synchronized块结构
		//需要大家改其他的类完成同步效果。（结果我们修改了Student和Workder中的调用doPrint逻辑，之前加上了synchronized块结构
		
		//第二次改进，假设Student和Worker对象不存在，需要大家使用匿名内部类完成类似Student和Worker这2个角色的代码。
		new Thread() {
			public void run() {
				//当做学生角色
				String doc = "我是学生";
				synchronized(lock) {
					p.doPrint(doc);
				}
			}
		}.start();
		new Thread() {
			public void run() {
				//当做工人角色
				String doc =" I am a worker.";
				synchronized(lock) {
					p.doPrint(doc);
				}
			}
		}.start();
		
		//第三次改进上面代码中的synchronized块中使用的对象不是p，使用其他的对象替代行不行？
		
		
		
	}
}
