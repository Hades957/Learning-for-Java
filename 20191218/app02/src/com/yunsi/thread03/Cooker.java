package com.yunsi.thread03;

public class Cooker extends Thread{
	
	private Table table;//�����������õ���
	private static int no =1;

	public Cooker(String cookerName, Table table) {
		super(cookerName);//Thread(String threadName)
		this.table = table;
	}
	
	public void run() {
		//��Ϊ��ʦһֱ��ͣ�������⣨��Ȼֻ��һ���������ʱֹͣ�����Ӱڲ����ˣ�
		while(true) {
			String cake = "����"+geneNO();
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
