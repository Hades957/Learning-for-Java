package com.yunsi.thread2;

public class Test {

	public static void sleep(int seconds) {
		long start = System.currentTimeMillis();
		while((System.currentTimeMillis())-start<1000*seconds);
	}
	
	public static void main(String[] args) {
		//2个线程，一个main线程，一个由main启动的新线程
		//新线程执行完毕大约需要20秒，main线程在10秒钟左右，通知新线程停止（使用的技巧就是中断这个操作）
		//Thread类中有start方法其实也有stop方法，stop方法原本应该使停止的意思，只不过这个方法废弃了，有不安全的因素
		//那么我们就要想法做到中途停止一个线程，这边使用interrupt这个方法来代替他。
		
		//启动新线程
		Thread tt = new Thread() {
			public void run() {
				for(char c = 'A';c<='Z';c++) {
					System.out.println(c+" 中断状态："+this.isInterrupted());
					if(this.isInterrupted()) {
						break;
					}
					Test.sleep(1);
				}
			}
		};
		tt.start();
		
		System.out.println("main线程休息10秒。。。。。");
		sleep(10);
		
		System.out.println("main线程休息好了，立即让之前那个新线程中断状态，中断。");
		tt.interrupt();
	}
}
