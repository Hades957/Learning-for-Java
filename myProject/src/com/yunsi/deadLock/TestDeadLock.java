package com.yunsi.deadLock;

public class TestDeadLock {

	public static void main(String[] args) {
		Object fork = new Object();//刀
		Object knife = new Object();//叉
		
		new Thread() {
			public void run() {
				synchronized (knife) {
					System.out.println("先拿到了刀，想要拿到叉");
					System.out.println("嘿嘿嘿，我拿到刀啦啦啦");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(fork) {
						System.out.println("刀和叉都拿到了");
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				synchronized (fork) {
					System.out.println("先拿到了叉，想要拿到刀");
					synchronized(knife) {
						System.out.println("刀和叉都拿到了");
					}
				}
			};
		}.start();
	}
}
