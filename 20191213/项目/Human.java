package com.yunsi.app1.pojo;
import java.io.Serializable;

public abstract class Human implements Serializable
{
	private String name;
	private String id;
	private int age;

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