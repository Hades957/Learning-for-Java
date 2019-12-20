package com.yunsi.test01;
/**
 * 多线程中有3个方法声明了InterruptedException	
 * 	1.sleep()
 * 	2.wait()
 * 	3.join()
 * @author Administrator
 *
 */
public class TestJoin {

	public static void main(String[] args) {
		//例子：3个线程，main，还有一个main创建的2个新线程（一个称为a，一个称为b）。
		//a线程计算1-50的累加和，而b线程计算51-100的累加和，最后交给main线程合并a，和b2个想成的累加结果，最后就是1-100的累加和，并且显示。
		final int[] sums = new int[2];
		Thread a = new Thread() {
			public void run() {
				int sum = 0;
				for(int i=1;i<=50;i++) {
					sum+=i;
				}
				sums[0]=sum;
				System.out.println("a线程计算1-50的累加和结果时："+sum);
			};
		};
		a.start();
		
		Thread b = new Thread() {
			public void run() {
				int sum = 0;
				for(int i=51;i<=100;i++) {
					sum+=i;
				}
				sums[1] = sum;
				System.out.println("b线程计算51-100的累加和结果时："+sum);
			};
		};
		b.start();


		//要注意main线程一定要在a，b线程执行之后，再执行下面的逻辑才能计算出正确的结果！！！！
		//那么要在a，b执行完再执行，就必须main等待a和b执行完毕。
		
		try {
			a.join();//执行这句话的线程等待调用join方法的线程执行完毕之后，执行这句话的线程再次执行。
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//main线程总结发言
		//???+XXXX
		int result = sums[0]+sums[1];
		System.out.println("main把a,b线程计算的结果合并之后是："+result);
	}
}
