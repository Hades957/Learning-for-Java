package com.yunsi.app1.pojo.sub;
import com.yunsi.app1.pojo.Human;

public class Cooker extends Human
{
	//��������
	private int grade;//��ʦ����
	private double salary;

	//���췽��
	public Cooker(){}
	public Cooker(String id,String name,int age,int grade,double salary){
		super(id,name,age);
		this.grade = grade;
		this.salary =salary;
	}

	//��Ա����
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
	
	//��д���󷽷�
	public String getDetails(){
		/*
		return "������Ϣ��"+this.id+","+this.name+","+this.getAge()+
			"������Ϣ���ȼ�:"+this.grade+",нˮ��"+this.salary;
		*/
		return	getBaseInfo()+"������Ϣ������:"+this.grade+",нˮ��"+this.salary;
	}
}