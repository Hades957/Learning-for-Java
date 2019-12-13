package com.yunsi.app1.pojo.sub;
import com.yunsi.app1.pojo.Human;

public class Cooker extends Human
{
	//独有属性
	private int grade;//厨师级别
	private double salary;

	//构造方法
	public Cooker(){}
	public Cooker(String id,String name,int age,int grade,double salary){
		super(id,name,age);
		this.grade = grade;
		this.salary =salary;
	}

	//成员方法
	public void setGrade(int grade){
		this.grade = grade;
	}
	public int getGrade(){
		return this.grade;
	}
	public void setSalary(double s){
		salary= s;
	}
	public double getSalary(){
		return salary;
	}
	
	//重写抽象方法
	public String getDetails(){
		/*
		return "基本信息："+this.id+","+this.name+","+this.getAge()+
			"独有信息：等级:"+this.grade+",薪水："+this.salary;
		*/
		return	getBaseInfo()+"独有信息：驾龄:"+this.grade+",薪水："+this.salary;
	}
}