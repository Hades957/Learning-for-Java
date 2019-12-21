package com.yunsi.test01;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test {

	public static void main(String[] args) {
		ExecutorService pool = Executors.newFixedThreadPool(1);
		
		//�������ύ��pool�У�poolֻ��Runnable����Ϊ��������
		Runnable printCharTask = new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("��ӡ��ĸ���߳��ǣ�"+t);
				for(int i='c';i<='z' && !t.isInterrupted();i++) {
					System.out.print((char)i+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						t.interrupt();
					}
				}
			}
		};
		
		Runnable printNumTask = new Runnable() {
			@Override
			public void run() {
				Thread t = Thread.currentThread();
				System.out.println("��ӡ���ֵ��߳��ǣ�"+t);
				for(int i=1;i<=20;i++) {
					System.out.print(i+" ");
					try {
						Thread.sleep(1000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		};
		pool.execute(printCharTask);
		pool.execute(printNumTask);
		
		//shutdown���ǳ����̻߳��ڹ���״̬���Ͳ��������һ�����������֮�󣬾������ر��̳߳�		
		//pool.shutdown();
		
//		try {
//			Thread.sleep(3000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		
//		pool.shutdownNow();
		
	}
}
