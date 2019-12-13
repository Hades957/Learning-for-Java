package com.yunsi.app1.exception;
/*
	这个异常是管什么的？
		1.对于人力资源而言，添加人员的时候，有一个编号，如果这个编号之前已经存在了，那么就报这个异常
		2.还有删除不存在的人员的时候，也会出现这个异常。
*/
public class HRManagementException extends Exception
{
	public HRManagementException(String msg){
		super(msg);
	}

}