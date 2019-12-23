package com.yunsi.review;

public class Student {
	public String name;
	public int age;
	public Student(String name,int age) {
		this.name= name;
		this.age= age;
	}
	public void setName(String name) {
		this.name= name;
	}
	public String getName() {
		return this.name;
	}
	public void setAge(int age) {
		this.age= age;
	}
	public int getAge() {
		return this.age;
	}
	public String toString(){
		return "ĞÕÃû"+name+" , "+"ÄêÁä"+age;
	}
}
