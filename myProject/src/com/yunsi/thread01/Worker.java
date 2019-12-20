package com.yunsi.thread01;

public class Worker implements Runnable{
	private Printer p = new Printer();
	private String doc;
	public Worker(String doc,Printer p) {
		this.doc = doc;
		this.p = p;
	}
	@Override
	public void run() {
		p.doPrint(this.doc);
	}
}
