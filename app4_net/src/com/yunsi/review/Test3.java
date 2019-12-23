package com.yunsi.review;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 
 编写一个多线程程序，每个5秒钟在控制台输出当前系统时间（年-月-日 时：分：秒）
 
 
 * @author Administrator
 *
 */
public class Test3 {
	public static void main(String[] args) {
		Thread t=new Thread();
		long l=0;
		Date d=null;
		SimpleDateFormat sm=null;
		/*
		for(int i=0;i<=10;i++) {
			try {
				t.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println(d);
		}
		*/
		sm=new SimpleDateFormat("YYYY-MM-dd hh:mm:ss");
		while(true) {
			//l=System.currentTimeMillis();
			//d=new Date(l);
			d = new Date();
			System.out.println(sm.format(d));
			try {
				t.sleep(5000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
