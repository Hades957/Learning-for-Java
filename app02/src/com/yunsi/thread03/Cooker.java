package com.yunsi.thread03;

public class Cooker extends Thread{
	
	private Table table;//桌子用来放置蛋糕
	private static int no =1;

	public Cooker(String cookerName, Table table) {
		super(cookerName);//Thread(String threadName)
		this.table = table;
	}
	
	public void run() {
		//作为厨师一直不停的做蛋糕（当然只有一种情况会暂时停止，桌子摆不下了）
		while(true) {
			String cake = "蛋糕"+geneNO();
			table.putCake(cake);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	private synchronized static int geneNO() {
		return no++;
	}

}
