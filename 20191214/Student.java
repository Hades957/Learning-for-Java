package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Student extends Human
{
	//私有属性
	private String major;
	//构造方法
	public Student(){}
	public Student(String id,String name,int age,String major){
		super(id,name,age);
		this.major = major;
	}
	//Getter/Setter
	public void setMajor(String major){
		this.major = major;
	}
	public String getMajor(){
		return this.major;
	}
}