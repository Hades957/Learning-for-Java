package com.yunsi.deadLock;

public class TestJoin {
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		final int[] sums = new int[2];
		Thread a = new Thread() {
			public void run() {
				int sum = 0;
				for(int i=0;i<=50;i++) {
					sum += i;
				}
				sums[0]=sum;
			};
		};
		a.start();
		
		Thread b = new Thread() {
			public void run() {
				int sum = 0;
				for(int i = 51;i<=100;i++) {
					sum += i;
				}
				sums[1]=sum;
			};
		};
		b.start();
		
		try {
			a.join();
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		int result = sums[0]+sums[1];
		System.out.println(result);
		
	}
}
