/*
	学生类
*/


public class Student extends Human{
	private String no;//学号
	public Student(){};
	public Student(String name,int age){
		super(name,age);
	}
	public Student(String name,int age,String no){
		super(name,age);
		this.no=no;
	}
	public void setNo(String no){
		this.no=no;
	}
	public String getNo(){
		return this.no;
	}
}