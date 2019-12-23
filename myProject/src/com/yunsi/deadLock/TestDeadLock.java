package com.yunsi.deadLock;

public class TestDeadLock {

	public static void main(String[] args) {
		Object fork = new Object();//��
		Object knife = new Object();//��
		
		new Thread() {
			public void run() {
				synchronized (knife) {
					System.out.println("���õ��˵�����Ҫ�õ���");
					System.out.println("�ٺٺ٣����õ���������");
					try {
						Thread.sleep(1);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					synchronized(fork) {
						System.out.println("���Ͳ涼�õ���");
					}
				}
			};
		}.start();
		
		new Thread() {
			public void run() {
				synchronized (fork) {
					System.out.println("���õ��˲棬��Ҫ�õ���");
					synchronized(knife) {
						System.out.println("���Ͳ涼�õ���");
					}
				}
			};
		}.start();
	}
}
