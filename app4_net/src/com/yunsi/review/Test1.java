package com.yunsi.review;

import java.util.ArrayList;
import java.util.List;

/**
 
 	��List�ӿ�ѧ���ķ���������һ��
 		��ҪΧ����ɾ�Ĳ�
 
 
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
		
		//��
		lst.add(1);
		lst.add("a");
		lst.add(4);
		System.out.print(lst);
		System.out.println(" ");
		//�����±�ɾ
		
		lst.remove(1);
		System.out.print(lst);
		System.out.println(" ");
		//�����±����޸ġ�
		lst.set(0,false);
		System.out.print(lst);
		System.out.println(" ");
		//��
		Object[] eles = lst.toArray();
		
		for(Object ele:eles) {
			System.out.print("ele "+ele);
		}
		
		
		
	}
	
	

}
