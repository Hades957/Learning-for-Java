package com.yunsi.thread03;

public class Consumer extends Thread{
	
	private Table table;
	
	public Consumer(String consumerName,Table table) {
		super(consumerName);
		this.table = table;
	}
	
	public void run() {
		while(true) {
			table.getCake();
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
