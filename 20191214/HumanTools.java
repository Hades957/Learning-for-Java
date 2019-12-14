package com.yunsi.app1.util;

import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.pojo.sub.*;

public class HumanTools
{
	//将信息打印到控制台
	public static String getPrintInfoOnConsole(Human h){
		if(h!=null){
			StringBuilder buff = new StringBuilder("基本信息：");
			buff.append("编号：").append(h.getId());
			buff.append("年龄：").append(h.getAge());
			
			if(h instanceof Student){
				Student s = (Student)h;
				buff.append("专业："+s.getMajor());
			}else if(h instanceof Teacher){
				Teacher t = (Teacher)h;
				buff.append("教授课程：").append(t.getCourse());
				buff.append("薪资：").append(t.getSalary());
			}
			return buff.toString();
		}
		return "";
	}

	//将读取的字符串转换为Human对象
	public static Human convertToHuman(String humanStr){
		if(!"".equals(humanStr)){
			//1.解析类型
			String[] datas = humanStr.split("@");
			if(datas!=null && datas.length==2){
				String type = datas[0];
				datas = datas[1].split("#");
				//共有的信息	//2.解析属性
				String id = datas[0];
				String name = datas[1];
				int age = Integer.parseInt(datas[2]);
				Human h = null;
				if(type.equalsIgnoreCase("student")){
					String major = datas[3];
					h = new Student(id,name,age,major);
				}else if(type.equalsIgnoreCase("Teacher")){
					String course = datas[3];
					int salary = Integer.parseInt(datas[4]);
					h = new Teacher(id,name,age,course,salary);
				}
				return h;
			}			
		}
		return null;
	}
	
	//把Human对象转换成字符串
	public static String geneHumanStr(Human h){
		if(h!=null){
			//属性之间加上"#"分隔
			StringBuilder buff = new StringBuilder();
			buff.append(h.getId());
			buff.append("#").append(h.getName());
			buff.append("#").append(h.getAge());
			
			//在不同类型的数据前加上类名@
			if(h instanceof Student){
				Student s = (Student)h;
				buff.insert(0,"Student@");
				buff.append("#").append(s.getMajor());
			}else if(h instanceof Teacher){
				Teacher t = (Teacher)h;
				buff.insert(0,"Teacher@");
				buff.append("#").append(t.getCourse());
				buff.append("#").append(t.getSalary());
			}
			return buff.toString();
		}
		return null;
	}	
}