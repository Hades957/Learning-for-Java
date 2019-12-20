package com.yunsi.test01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(1);
		
		//把任务提交到pool中，pool只认Runnable对象为具体任务。
		Runnable printCharTask = new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("打印字母的线程是："+t);
				for(int i='c';i<='z' && !t.isInterrupted();i++) {
					System.out.print((char)i+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						t.interrupt();
					}
				}
			}
		};
		
		Runnable printNumTask = new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("打印数字的线程是："+t);
				for(int i=1;i<=20;i++) {
					System.out.print(i+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		pool.execute(printCharTask);
		pool.execute(printNumTask);
		
		//shutdown就是池中线程还在工作状态，就不会结束，一旦工作完毕了之后，就立即关闭线程池		
		//pool.shutdown();
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		pool.shutdownNow();
		
	}
}
