package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Driver extends Human
{
	//�Լ����е�����
	private int driveAge;//����
	private double salary;//н��

	//���췽��
	public Driver(){}
	public Driver(String id,String name,int age,int driveAge,double salary){
		super(id,name,age);//���õ��ø��๹�췽���������Human(String name,int age)
		this.driveAge = driveAge;
		this.salary = salary;
		//this.name = name;
		//this.age = age;

		//this.setName(name);
		//this.setAge(age);
	}

	//��Ա����
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

	//��д����getDetails����
	public String getDetails(){
		/*
		return "������Ϣ��"+this.id+","+this.name+","+this.getAge()+
			"������Ϣ������:"+this.driveAge+",нˮ��"+this.salary;
		*/
		return	getBaseInfo()+"������Ϣ������:"+this.driveAge+",нˮ��"+this.salary;
	}
}