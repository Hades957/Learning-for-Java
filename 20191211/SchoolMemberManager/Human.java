package com.yunsi.app1.pojo;

import java.io.Serializable;

public abstract class Human implements Serializable
{
	//���ԣ���4���๲�е����ԣ�������������̳У�
	protected String id;//���֤����
	protected String name;
	private int age;
	private static final long serialVersionUID = 5103951948063716640L;
	//���췽��
	public Human(){}
	public Human(String name,int age){
		this(null,name,age);
	}
	public Human(String id,String name,int age){
		this.id = id;
		this.name= name;
		this.age  =age;
	}

	//��Ա������getter��setter��
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

	//��ȡ������Ϣ
	public String getBaseInfo(){
		return "������Ϣ��"+this.id+","+this.name+","+this.age+" ";

	}
	public abstract String getDetails();
}