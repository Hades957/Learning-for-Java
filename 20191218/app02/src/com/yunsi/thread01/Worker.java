package com.yunsi.thread01;

/**
 * ���˴��Ź������ϴ�ӡ
 * @author Administrator
 *
 */
public class Worker implements Runnable {

	private Printer p;
	private String doc;
	
	public Worker(String doc, Printer p) {
		// TODO Auto-generated constructor stub
		this.doc = doc;
		this.p = p;
	}

	public void run() {
		//����ʹ�ô�ӡ����ӡ�Լ��Ĳ���
		//synchronized(p) {
			p.doPrint(this.doc);
		//}
	}
	
}
