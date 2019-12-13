package com.yunsi.app1.pojo;
import java.io.Serializable;

public class Teacher extends Human implements Serializable
{
	private String course;
	private int salary;

	public Teacher(){}
	public Teacher(String id,String name,int age,String course,int salary){
		super(id,name,age);
		this.course = course;
		this.salary = salary;
	}

	public void setCourse(String course){
		this.course = course;
	}
	public String getCourse(){
		return this.course;
	}

	public void setSalary(int salary){
		this.salary = salary;
	}
	public int getSalary(){
		return this.salary;
	}

	
}