package com.yunsi;

import java.io.Serializable;

public class HelloWorld implements Cloneable, Serializable, Comparable<Integer> {

	private String name;
	private int age;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Thread t = Thread.currentThread();//static Thread currentThread() �Żص�ǰִ���߳�
		System.out.println("t="+t);
		
		System.out.print("hello world!����");
		
		long start  = System.currentTimeMillis();
		while(System.currentTimeMillis()-start<10000);
	}

	@Override
	public int compareTo(Integer o) {
		// TODO Auto-generated method stub
		return 0;
	}

}
