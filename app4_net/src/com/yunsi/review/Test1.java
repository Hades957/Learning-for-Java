package com.yunsi.review;

import java.util.ArrayList;
import java.util.List;

/**
 
 	把List接口学过的方法，演练一下
 		主要围绕增删改查
 
 
 * 
 * 
 * @author Administrator
 *
 */
public class Test1 {
	
	public static void main(String[] args) {
			test1();
	}
	
	public static void test1() {
		
		List lst = new ArrayList();
		
		//增
		lst.add(1);
		lst.add("a");
		lst.add(4);
		System.out.print(lst);
		System.out.println(" ");
		//根据下标删
		
		lst.remove(1);
		System.out.print(lst);
		System.out.println(" ");
		//根据下标来修改、
		lst.set(0,false);
		System.out.print(lst);
		System.out.println(" ");
		//查
		Object[] eles = lst.toArray();
		
		for(Object ele:eles) {
			System.out.print("ele "+ele);
		}
		
		
		
	}
	
	

}
