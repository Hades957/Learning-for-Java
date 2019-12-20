package com.yunsi.thread03;

public class Consumer extends Thread{

	private Table table;
	
	public Consumer(String consumerName, Table table) {
		// TODO Auto-generated constructor stub
		super(consumerName);
		this.table = table;
	}

	public void run() {
		while(true) {
			//²»Í£µÄÈ¡µ°¸â
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
