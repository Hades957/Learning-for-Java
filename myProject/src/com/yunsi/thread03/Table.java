package com.yunsi.thread03;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private List<String> cakeList = new ArrayList<String>();
	
	//�ŵ���
	public synchronized void putCake(String cake) {
		while(cakeList.size()>=10) {
			try {
				System.out.println(Thread.currentThread().getName()+" �����������ˣ���ʱ���ܷ��õ��⣡,������Ϣ����������");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cakeList.add(cake);
		this.notifyAll();
		System.out.println(Thread.currentThread().getName()+" ���� "+cake);
	}
	
	//ȡ����
	public synchronized String getCake() {
		while(cakeList.size()<=0) {
			try {
				System.out.println(Thread.currentThread().getName()+" �������ӿ��ˣ�û�е��⣩�����Եȴ�������������");
				this.wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}			
		}
		String cake = cakeList.remove(0);
		System.out.println(Thread.currentThread().getName()+" ��ȡ "+cake);
		
		this.notifyAll();
		return cake;
	}
}
