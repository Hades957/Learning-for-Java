package com.yunsi.thread02;

import java.util.Random;

public class Printer {

	private static  Random r = new Random();
	private static Object obj = new Object();
	//��ӡ����ӡ���ݹ����Ĳ���
	//ע����ǣ��п��ܶ���ˣ���ʵ���Ƕ���̣߳���ͬʱ���Ҵ�ӡ��Ϣ
	//����̱߳���Ҫ��ȡTest���ж����p�����Printer���ͣ�������������߽�������������ȡ���Ժ���ܽ���synchronized���ε����doPrint����
	//û�л�ȡ�����߳���ô�죿ֻ����������ţ�һ������synchronized�������߳�ִ������������֮�󣬻����������ȥ����ô�����ȴ�����Щ�߳�
	//�Ϳ��Լ����Ȼ�ȡ����Ȼ����ִ�С�
	public static void doPrint(String doc) {
		synchronized(obj) {//����synchronized(Printer.class){...}
			//ģ���ӡ�����ڿ���̨���������ַ���Ϣ��Ϊ�˿�������������Ч�������ǲ���doc�е�ÿһ���ַ���ӡ���֮�����1����
			for(int i=0;i<doc.length();i++) {
				char ch = doc.charAt(i);
				System.out.print(ch);
				try {
					Thread.sleep(r.nextInt(3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		//}
		}
		
		//zd();
	}
	
	
	private void zd() {
		System.out.println("װ����ʼ-----------------------------"+Thread.currentThread());
		try {
			Thread.sleep(r.nextInt(3000)+5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("װ������------------------------------"+Thread.currentThread());
	}
	
}
