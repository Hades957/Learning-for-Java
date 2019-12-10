package com.yunsi.test;

import com.yunsi.*;
import com.yunsi.impl.StudentImpl;
public class Test{
	public static void main(String[] args){
		StudentImpl s = new StudentImpl();
		s.sing();
		s.chess();
		ISinger ss = s;
		ss.sing();
	}
}