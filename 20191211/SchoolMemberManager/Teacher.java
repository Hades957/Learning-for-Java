package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Teacher extends Human
{
	//��������
	private String course;//���ڿγ�
	private double salary;//н��

	//���췽��
	public Teacher(){}
	public Teacher(String id,String name,int age,String course,double salary){
		super(id,name,age);
		this.course = course;
		this.salary = salary;
	}

	//��Ա����
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
	//��д
	public String getDetails(){
		return getBaseInfo()+" ������Ϣ��"+this.course+","+this.salary;
	}

}