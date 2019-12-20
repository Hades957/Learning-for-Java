package com.yunsi.thread03;

public class Cooker extends Thread{
	
	private Table table;
	private static int no = 1;
	
	public Cooker(String cookerName,Table table) {
		super(cookerName);
		this.table = table;
	}
	
	@Override
	public void run() {
		while(true) {
			String cake = "µ°¸â"+geneNo();
			table.putCake(cake);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	private synchronized static int geneNo() {
		return no++;
	}
}
