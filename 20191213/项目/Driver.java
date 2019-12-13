package com.yunsi.app1.pojo;
import java.io.Serializable;

public class Driver extends Human implements Serializable 
{
	private int driveAge;
	private int salary;

	public Driver(){}
	public Driver(String id,String name,int age,int driveAge,int salary){
		super(id,name,age);
		this.driveAge = driveAge;
		this.salary = salary;
	}

	public void setDriveAge(int driveAge){
		this.driveAge = driveAge;
	}
	public int getDriveAge(){
		return this.driveAge;
	}

	public void setSalary(int salary){
		this.salary = salary;
	}
	public int getSalary(){
		return this.salary;
	}

	
}