package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Student extends Human
{
	//独有属性
	private String major;//专业

	//构造方法
	public Student(){}
	public Student(String id,String name,int age,String major){
		super(id,name,age);
		this.major = major;
	}
	//成员方法
	public void setMajor(String m){
		major = m;
	}
	public String getMajor(){
		return major;
	}

	//重写
	public String getDetails(){
		return getBaseInfo()+" 独有信息："+this.major;
	}

}