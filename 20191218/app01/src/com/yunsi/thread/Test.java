package com.yunsi.thread;

public class Test {

	public static void main(String[] args) {
		//1.创建线程对象
		PrintCharThread pct = new PrintCharThread();
		pct.setName("我就是pct");
		//2.启动线程（启动这一步是与其他对象的操作不一样的地方）
		pct.start();//start方法是Thread类中的成员方法，它被调用之后，jvm中就会新创建一个线程，并且把pct中的run方法逻辑放入那个新线程中运行。
		//pct.run();
		
		
		//对于实现Runnable接口的类要想当做线程启动，必须这样
		PrintNumRunnable pnr = new PrintNumRunnable();
		Thread t = new Thread(pnr,"PNR");//Thread(Runnable)
		t.start();
		
		//收集当前jvm中所有的线程（运行当中的）
		int count = Thread.activeCount();
		System.out.println("count="+count);
		
		Thread[] threads = new Thread[count];
		int realCount = Thread.enumerate(threads);
		
		System.out.println("获取有效的线程数量："+realCount);
		for(Thread tt : threads) {
			System.out.println(tt.getName());
		}
		
	}
}
