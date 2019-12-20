package com.yunsi.thread;

public class PrintCharThread extends Thread{

	//一般而言我们都是要重写Thread中的run方法
	public void run() {
		System.out.println("PrintCharThread这个线程的名称："+getName());
		for(char c='a';c<='z';c++) {
			System.out.print(c+" ");
			
			long start = System.currentTimeMillis();
			while((System.currentTimeMillis()-start)<=1000) {}
			 
		}
	}
}
