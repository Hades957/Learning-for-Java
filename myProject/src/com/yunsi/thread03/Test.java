package com.yunsi.thread03;

public class Test {
	public static void main(String[] args) {
		Table table = new Table();
		
		Cooker c1 = new Cooker("��ʦ1",table);
		Cooker c2 = new Cooker("��ʦ2",table);
		Cooker c3 = new Cooker("��ʦ3",table);
		
		Consumer cc1 = new Consumer("�˿�1",table);
		Consumer cc2 = new Consumer("�˿�2",table);
		Consumer cc3 = new Consumer("�˿�3",table);
		Consumer cc4 = new Consumer("�˿�4",table);
		Consumer cc5 = new Consumer("�˿�5",table);
		
		c1.start();
		c2.start();
		
		cc1.start();
		cc2.start();
	}
}
