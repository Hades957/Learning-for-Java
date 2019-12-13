package com.yunsi.app1.pojo;
import java.io.Serializable;

public class Cooker extends Human implements Serializable 
{
	private int grade;
	private int salary;

	public Cooker(){}
	public Cooker(String id,String name,int age,int grade,int salary){
		super(id,name,age);
		this.grade = grade;
		this.salary = salary;
	}

	public void setGrade(int grade){
		this.grade = grade;
	}
	public int getGrade(){
		return this.grade;
	}

	public void setSalary(int salary){
		this.salary = salary;
	}
	public int getSalary(){
		return this.salary;
	}

	
}