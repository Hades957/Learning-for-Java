package com.yunsi.app1.pojo.sub;

import com.yunsi.app1.pojo.Human;

public class Student extends Human
{
	//��������
	private String major;//רҵ

	//���췽��
	public Student(){}
	public Student(String id,String name,int age,String major){
		super(id,name,age);
		this.major = major;
	}
	//��Ա����
	public void setMajor(String m){
		major = m;
	}
	public String getMajor(){
		return major;
	}

	//��д
	public String getDetails(){
		return getBaseInfo()+" ������Ϣ��"+this.major;
	}

}