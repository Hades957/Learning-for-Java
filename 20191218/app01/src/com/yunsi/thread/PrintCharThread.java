package com.yunsi.thread;

public class PrintCharThread extends Thread{

	//һ��������Ƕ���Ҫ��дThread�е�run����
	public void run() {
		System.out.println("PrintCharThread����̵߳����ƣ�"+getName());
		for(char c='a';c<='z';c++) {
			System.out.print(c+" ");
			
			long start = System.currentTimeMillis();
			while((System.currentTimeMillis()-start)<=1000) {}
			 
		}
	}
}
