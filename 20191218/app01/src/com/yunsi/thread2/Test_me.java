package com.yunsi.thread2;

public class Test_me {
	public static void sleep(int seconds) {
		long start = System.currentTimeMillis();
		while((System.currentTimeMillis())-start<1000*seconds);
	}
	public static void main(String[] args) {
		Thread tt = new Thread() {
			public void run() {
				for(char c = 'A';c<='Z';c++) {
					System.out.println(c+"中断状态："+this.isInterrupted());
					if(this.isInterrupted()) {
						break;
					}
					Test_me.sleep(1);
				}
			}	
		};
		tt.start();
		System.out.println("main线程休息10s......");
		sleep(10);
		
		System.out.println("main线程休息好了，立即让之前那个新线程中断状态，中断");
		tt.interrupt();
	}
}
