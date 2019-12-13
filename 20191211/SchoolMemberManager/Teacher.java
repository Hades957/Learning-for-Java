package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Teacher extends Human
{
	//独有属性
	private String course;//教授课程
	private double salary;//薪资

	//构造方法
	public Teacher(){}
	public Teacher(String id,String name,int age,String course,double salary){
		super(id,name,age);
		this.course = course;
		this.salary = salary;
	}

	//成员方法
	public void setSalary(double s){
		salary= s;
	}
	public double getSalary(){
		return salary;
	}
	public void setCourse(String course){
		this.course = course;
	}
	public String getCourse(){
		return this.course;
	}
	//重写
	public String getDetails(){
		return getBaseInfo()+" 独有信息："+this.course+","+this.salary;
	}

}