package com.yunsi.thread;

public class PrintNumRunnable implements Runnable {

	public void run() {
		Thread t = Thread.currentThread();
		System.out.println("PrintNumRunnable �߳����ƣ�"+t.getName());
		for(int i=1;i<=20;i++) {
			System.out.print(i+" ");
			/*
			 * long start = System.currentTimeMillis();
			 * while((System.currentTimeMillis()-start)<=1000) {}
			 */
		}
	}

}
