package com.yunsi.review;
/**
 * ��д���̳߳���ÿ��һ�룬һ���̶߳Ա���i����������������һ���߳����Լ�����
 * @author Administrator
 *
 */

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Test4 {
	
	static Runnable Char =new Runnable(){
		@Override
		public void run() {
			// TODO Auto-generated method stub
			for(int i=1;i<=50;i++) {
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
	static Runnable Num = new Runnable() {
		public void run() {
			for(int i=50;i<=100;i--) {
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
	public static void main(String[] args) {
		new Thread(Char).start();
		new Thread(Num).start();
	}
}
