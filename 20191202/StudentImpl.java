package com.yunsi.impl;

import com.yunsi.ISinger;
import com.yunsi.IChess;

public class StudentImpl implements IChess,ISinger{
	public void sing(){
		System.out.println("Sing...");
	}
	public void chess(){
		System.out.println("Chess...");
	}
}