package com.yunsi.app1.pojo;
/*
	人类，抽象类所有人员的父类
*/

public abstract class Human
{
	//共享属性
	private String name;
	private String id;
	private int age;
	//构造方法
	public Human(){}
	public Human(String id,String name,int age){
		this.id = id;
		this.name = name;
		this.age = age;
	}
	public void setId(String id){
		this.id = id;
	}
	public String getId(){
		return this.id;
	}
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
}