package com.yunsi.review;
/**
 * ���д�����������������ֳ���
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
					System.out.println("���õ������ò�");
					synchronized(fork) {
						System.out.println("���˵���ͬʱ�ò�");
					}
				}
			};
		}.start();
		new Thread() {
			public void run() {
				synchronized(fork) {
					System.out.println("���ò棬���õ�");
					synchronized(knife) {
						System.out.println("���˲棬ͬʱ�õ�");
					}
				}
			};
		}.start();
	}

}
