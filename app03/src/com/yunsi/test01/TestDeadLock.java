package com.yunsi.test01;

/**
 * 演示死锁
 * @author Administrator
 *
 */
public class TestDeadLock {

	public static void main(String[] args) {
		//一个比较著名的例子，刀叉问题（很好演示死锁现象）
		Object fork = new Object();//叉子
		Object knife = new Object();//刀
		
		new Thread() {
			public void run() {
				//先持有刀，想要再次持有叉子
				synchronized(knife) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("先持有了刀，先要再持有叉子。。。。");
					synchronized(fork) {
						System.out.println("持有刀，同时持有了叉子！！！");
					}
				}
			};
		}.start();
		
		

		new Thread() {
			public void run() {
				//先持有叉子，想要再次持有刀
				synchronized(fork) {
					System.out.println("先持有了叉子，先要再持有刀。。。。");
					synchronized(knife) {
						System.out.println("持有叉子，同时持有了刀！！！");
					}
				}
			};
		}.start();
	}
}
