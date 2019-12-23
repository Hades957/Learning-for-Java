package com.yunsi.review;
/**
 * 请编写程序把死锁现象给呈现出来
 * @author Administrator
 *
 */
public class Test5 {
	public static void main(String[] args) {
		Object knife=new Object();
		Object fork=new Object();
		new Thread() {
			public void run() {
				synchronized(knife) {
					try {
						Thread.sleep(100);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("先拿刀，再拿叉");
					synchronized(fork) {
						System.out.println("拿了刀，同时拿叉");
					}
				}
			};
		}.start();
		new Thread() {
			public void run() {
				synchronized(fork) {
					System.out.println("先拿叉，再拿刀");
					synchronized(knife) {
						System.out.println("拿了叉，同时拿刀");
					}
				}
			};
		}.start();
	}

}
