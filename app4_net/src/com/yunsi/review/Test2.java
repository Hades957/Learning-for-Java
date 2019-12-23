package com.yunsi.review;
/**
 
 	针对List中的元素（例如Integer）进行一个降序排列。
 
 * @author Administrator
 *
 */
import java.util.*;
public class Test2
{
	public static void main(String[] args){
		List<Integer> lst=new ArrayList<>();
		lst.add(1);
		lst.add(5);
		lst.add(3);
		lst.add(4);
		Comparator<Integer> comp=new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				// TODO Auto-generated method stub
				return o2-o1;
			}
		};
		lst.sort(comp);
//		Collections.sort(list, c);
		System.out.println(lst);
	}
}