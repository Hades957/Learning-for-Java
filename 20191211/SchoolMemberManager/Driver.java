package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Driver extends Human
{
	//自己独有的属性
	private int driveAge;//驾龄
	private double salary;//薪资

	//构造方法
	public Driver(){}
	public Driver(String id,String name,int age,int driveAge,double salary){
		super(id,name,age);//利用调用父类构造方法这个机制Human(String name,int age)
		this.driveAge = driveAge;
		this.salary = salary;
		//this.name = name;
		//this.age = age;

		//this.setName(name);
		//this.setAge(age);
	}

	//成员方法
	public void setSalary(double s){
		salary= s;
	}
	public double getSalary(){
		return salary;
	}
	public void setDriveAge(int a){
		driveAge  =a;
	}
	public int getDriveAge(){
		return this.driveAge;
	}

	/*
	public static void main(String[] args){
		Driver d = new Driver("aaa",20,5,8888);
		d.showInfo();
	}
	*/

	//重写父类getDetails方法
	public String getDetails(){
		/*
		return "基本信息："+this.id+","+this.name+","+this.getAge()+
			"独有信息：驾龄:"+this.driveAge+",薪水："+this.salary;
		*/
		return	getBaseInfo()+"独有信息：驾龄:"+this.driveAge+",薪水："+this.salary;
	}
}