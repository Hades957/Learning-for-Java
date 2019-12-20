package com.yunsi.thread01;

import java.util.Random;

public class Printer {
	private Random r = new Random();
	public void doPrint(String doc) {
		synchronized(this) {
			for(int i=0;i<doc.length();i++) {
				char ch = doc.charAt(i);
				System.out.print(ch);
				try {
					Thread.sleep(r.nextInt(3000));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}		
		zd();
	}
	
	private void zd() {
		System.out.println("装订开始-----------------");
		try {
			Thread.sleep(r.nextInt(2000)+5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("装订结束-----------------");
	}
}
