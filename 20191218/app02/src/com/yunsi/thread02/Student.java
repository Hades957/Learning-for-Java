package com.yunsi.thread02;
/**
 * ѧ���������ĸ��˼���ȥ��ӡ���ӡ
 * @author Administrator
 *
 */
public class Student extends Thread {

	private Printer p;
	private String doc;//ѧ����Ҫ��ӡ�Ĳ���
	
	public Student(String doc,Printer p) {
		// TODO Auto-generated constructor stub
		this.p = p;
		this.doc = doc;
	}
	
	//��дThread�е�run����
	public void run() {
		//ѧ��ʹ�������ӡ����ӡ�Լ��Ĳ���
		synchronized(p) {
			p.doPrint(this.doc);
		}
		
	}

	
}
