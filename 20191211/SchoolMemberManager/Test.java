package com.yunsi.app1.test;

import java.io.IOException;
import com.yunsi.app1.pojo.*;
import com.yunsi.app1.pojo.sub.*;
import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.service.impl.*;
import com.yunsi.app1.exception.HRManagementException;
import com.yunsi.app1.util.*;
public class Test
{
	//main方法
	//入口函数（方法）
	public static void main(String[] arsg) throws HRManagementException,IOException,ClassNotFoundException{
		/*
		HRManagementIF hr = new HRManagementImpl(3);
		


		//构造学生，教师，厨师，驾驶员
		Student s = new Student("320114","学生1",20,"计算机");
		Teacher t = new Teacher("320115","教师1",50,"今生今世",8989);
		Cooker c = new Cooker("320116","厨师1",55,1,9090);
		Driver d = new Driver("320117","司机1",56,20,101010);
		Driver d2 = new Driver("320117","司机2",57,21,101011);
		//d2 = null;
		//Human human= new Human("hhh",30);

		//演示人力资源相关操作
		try{
			hr.save(s);//save(Human)
			hr.save(t);//save(Human)
			hr.save(c);//save(Human)
			hr.save(d);//save(Human);
			hr.save(d2);
		}catch(HRManagementException e){
			e.printStackTrace();
		}
//		hr.save(human);
		int size = hr.getSize();
		System.out.println("查看总人数："+size);


		//查询所有人员
		Human[] humans = hr.queryAll();
		//控制台打印这些人的信息
		System.out.println("$$添加人员之后，显示所有人信息：");
		hr.printHumans(humans);

		

		//删除人员
		//hr.remove(tt);
		try{
			String id = "320115";
			id = null;
			hr.remove(id);
		}catch(HRManagementException e){
			e.printStackTrace();
		}

		//再次查询所有人
		humans = hr.queryAll();
		System.out.println("$$删除之后显示所有人的信息：");
		hr.printHumans(humans);

		
		//查询某个人员
		Human h = hr.query("320117");
		System.out.println("$$查询320117这个人：");
		hr.printHumans(h);



		//修改人员
		Teacher tt = new Teacher("320117","教师2",51,"今天",7878);
		tt = null;
		hr.update(tt);
		System.out.println("\n\n$$修改320117这个人之后，显示所有人信息：");
		hr.printHumans(hr.queryAll());

*/
		
		IOHRManagementImpl iohr = new IOHRManagementImpl();
		Student s = new Student("320114","学生1",20,"计算机");
		Teacher t = new Teacher("320115","教师1",50,"今生今世",8989);
		Cooker c = new Cooker("320116","厨师1",55,1,9090);
		iohr.save(c);		
		iohr.save(t);
		iohr.save(s);
		iohr.saveAll();
		iohr.readAll();
		//Serialization.deserializable();
	} 
}