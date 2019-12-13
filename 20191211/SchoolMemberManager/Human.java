package com.yunsi.app1.pojo;

import java.io.Serializable;

public abstract class Human implements Serializable
{
	//属性（是4个类共有的属性，这样方便子类继承）
	protected String id;//身份证号码
	protected String name;
	private int age;
	private static final long serialVersionUID = 5103951948063716640L;
	//构造方法
	public Human(){}
	public Human(String name,int age){
		this(null,name,age);
	}
	public Human(String id,String name,int age){
		this.id = id;
		this.name= name;
		this.age  =age;
	}

	//成员方法（getter，setter）
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return this.name;
	}

	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return this.age;
	}
	public String getId(){
		return id;
	}
	public void setId(String id){
		this.id = id;
	}


	public void showInfo(){
		System.out.println("Human showInfo name="+name+",age="+age);
	}

	//获取基本信息
	public String getBaseInfo(){
		return "基本信息："+this.id+","+this.name+","+this.age+" ";

	}
	public abstract String getDetails();
}