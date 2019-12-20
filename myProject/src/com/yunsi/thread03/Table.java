package com.yunsi.thread03;

import java.util.ArrayList;
import java.util.List;

public class Table {
	private List<String> cakeList = new ArrayList<String>();
	
	//放蛋糕
	public synchronized void putCake(String cake) {
		while(cakeList.size()>=10) {
			try {
				System.out.println(Thread.currentThread().getName()+" 由于桌子满了，暂时不能放置蛋糕！,所以休息。。。。。");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		cakeList.add(cake);
		this.notifyAll();
		System.out.println(Thread.currentThread().getName()+" 放置 "+cake);
	}
	
	//取蛋糕
	public synchronized String getCake() {
		while(cakeList.size()<=0) {
			try {
				System.out.println(Thread.currentThread().getName()+" 由于桌子空了（没有蛋糕），所以等待。。。。。。");
				this.wait();
			} catch(InterruptedException e){
				e.printStackTrace();
			}			
		}
		String cake = cakeList.remove(0);
		System.out.println(Thread.currentThread().getName()+" 获取 "+cake);
		
		this.notifyAll();
		return cake;
	}
}
