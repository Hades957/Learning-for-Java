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
					System.out.println(c+"�ж�״̬��"+this.isInterrupted());
					if(this.isInterrupted()) {
						break;
					}
					Test_me.sleep(1);
				}
			}	
		};
		tt.start();
		System.out.println("main�߳���Ϣ10s......");
		sleep(10);
		
		System.out.println("main�߳���Ϣ���ˣ�������֮ǰ�Ǹ����߳��ж�״̬���ж�");
		tt.interrupt();
	}
}
