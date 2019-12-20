package com.yunsi.thread01;

/**
 * 工人带着工作材料打印
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
		//工人使用打印机打印自己的材料
		//synchronized(p) {
			p.doPrint(this.doc);
		//}
	}
	
}
