package com.yunsi.thread;

public class Test {

	public static void main(String[] args) {
		//1.�����̶߳���
		PrintCharThread pct = new PrintCharThread();
		pct.setName("�Ҿ���pct");
		//2.�����̣߳�������һ��������������Ĳ�����һ���ĵط���
		pct.start();//start������Thread���еĳ�Ա��������������֮��jvm�оͻ��´���һ���̣߳����Ұ�pct�е�run�����߼������Ǹ����߳������С�
		//pct.run();
		
		
		//����ʵ��Runnable�ӿڵ���Ҫ�뵱���߳���������������
		PrintNumRunnable pnr = new PrintNumRunnable();
		Thread t = new Thread(pnr,"PNR");//Thread(Runnable)
		t.start();
		
		//�ռ���ǰjvm�����е��̣߳����е��еģ�
		int count = Thread.activeCount();
		System.out.println("count="+count);
		
		Thread[] threads = new Thread[count];
		int realCount = Thread.enumerate(threads);
		
		System.out.println("��ȡ��Ч���߳�������"+realCount);
		for(Thread tt : threads) {
			System.out.println(tt.getName());
		}
		
	}
}
