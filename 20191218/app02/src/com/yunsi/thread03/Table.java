package com.yunsi.thread03;

import java.util.ArrayList;
import java.util.List;

/**
 * 桌子，专门用来放置蛋糕
 * @author Administrator
 *
 */
public class Table {

	private List<String> cakeList = new ArrayList<String>();
	
	//放蛋糕
	public synchronized void putCake(String cake) {
		//1.先检查桌子有没有空位，如果没有就等待（暂停）
		while(cakeList.size()>=10) {
			//等待？？？
			try {
				System.out.println(Thread.currentThread().getName()+" 由于桌子满了，暂时不能放置蛋糕！,所以休息。。。。。");
				this.wait();				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//2.放蛋糕
		cakeList.add(cake);
		
		//***厨师一旦放入蛋糕，就可以到休息区中叫醒休息去中的人，尤其是顾客们
		this.notifyAll();
		System.out.println(Thread.currentThread().getName()+" 放置 "+cake);
		
	}
	
	//取蛋糕
	public synchronized String getCake() {
		//1.检查桌子有没有蛋糕，没有就等待（暂停）
		while(cakeList.size()<=0) {
			//等待？？？
			try {
				System.out.println(Thread.currentThread().getName()+" 由于桌子空了（没有蛋糕），所以等待。。。。。。");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String cake = cakeList.remove(0);
		System.out.println(Thread.currentThread().getName()+" 获取 "+cake);
		//2.取蛋糕
		
		//***一定要通知在this休息区休息的人，桌子不是满的至少厨师可以放置蛋糕了
		//this.notify();//推荐大家使用notifyAll()
		this.notifyAll();
		return cake;
	}
	
	
}
