package com.yunsi.thread03;

public class Test {
	public static void main(String[] args) {
		Table table = new Table();
		
		Cooker c1 = new Cooker("厨师1",table);
		Cooker c2 = new Cooker("厨师2",table);
		Cooker c3 = new Cooker("厨师3",table);
		
		Consumer cc1 = new Consumer("顾客1",table);
		Consumer cc2 = new Consumer("顾客2",table);
		Consumer cc3 = new Consumer("顾客3",table);
		Consumer cc4 = new Consumer("顾客4",table);
		Consumer cc5 = new Consumer("顾客5",table);
		
		c1.start();
		c2.start();
		
		cc1.start();
		cc2.start();
	}
}
