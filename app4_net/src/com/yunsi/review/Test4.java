package com.yunsi.review;
/**
 * 编写多线程程序，每隔一秒，一个线程对变量i进行自增操作，另一个线程做自减操作
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
