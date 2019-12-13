//自定义异常
package com.yunsi.app1.exception;
/**
业务上面有要求
*/
public class HRManagementException extends Exception
{
	public HRManagementException(String msg){
		super(msg);
	}

}