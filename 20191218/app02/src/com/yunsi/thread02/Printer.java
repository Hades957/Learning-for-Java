package com.yunsi.thread02;

import java.util.Random;

public class Printer {

	private static  Random r = new Random();
	private static Object obj = new Object();
	//打印机打印传递过来的材料
	//注意的是：有可能多个人（其实就是多个线程）会同时找我打印信息
	//多个线程必须要获取Test类中定义的p这个（Printer类型）对象的锁定或者叫做监视器，获取到以后才能进入synchronized修饰的这个doPrint方法
	//没有获取到的线程怎么办？只能在外面等着，一旦进入synchronized方法的线程执行完整个方法之后，会把锁定还回去，那么曾经等待的那些线程
	//就可以继续先获取锁定然后再执行。
	public static void doPrint(String doc) {
		synchronized(obj) {//或者synchronized(Printer.class){...}
			//模拟打印，就在控制台输出具体的字符信息，为了看到更加清晰的效果，我们参数doc中的每一个字符打印完毕之后会间隔1秒钟
			for(int i=0;i<doc.length();i++) {
				char ch = doc.charAt(i);
				System.out.print(ch);
				try {
					Thread.sleep(r.nextInt(3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//}
		}
		
		//zd();
	}
	
	
	private void zd() {
		System.out.println("装订开始-----------------------------"+Thread.currentThread());
		try {
			Thread.sleep(r.nextInt(3000)+5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("装订结束------------------------------"+Thread.currentThread());
	}
	
}
