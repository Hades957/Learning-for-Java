package com.yunsi.app1.pojo;
import java.io.Serializable;

public class Student extends Human implements Serializable
{
	private String major;
	public Student(){}
	public Student(String id,String name,int age,String major){
		super(id,name,age);
		this.major = major;
	}

	public void setMajor(String major){
		this.major = major;
	}
	public String getMajor(){
		return this.major;
	}

	
}