//Human类型的操纵工具，例如把具体子类的所有属性（字符串）提取出来
package com.yunsi.app1.util;
import com.yunsi.app1.pojo.*;

public class HumanTools
{
	public static String getPrintInfoOnConsole(Human h){
		if(h!=null){
			StringBuilder buff = new StringBuilder("基本信息：");
			buff.append("编号:").append(h.getId());
			buff.append("姓名：").append(h.getName());
			buff.append("年龄：").append(h.getAge());

			if(h instanceof Student){
				Student s = (Student)h;
				buff.append("专业："+s.getMajor());
			}
			else if(h instanceof Teacher){
				Teacher t = (Teacher)h;
				buff.append("教授课程：").append(t.getCourse());
				buff.append("薪资：").append(t.getSalary());
			}
			else if( h instanceof Driver){
				Driver d = (Driver)h;
				buff.append("驾龄：").append(d.getDriveAge());
				buff.append("薪资：").append(d.getSalary());
			}
			else if(h instanceof Cooker){
				Cooker c = (Cooker)h;
				buff.append("级别：").append(c.getGrade());
				buff.append("薪资：").append(c.getSalary());
			}
			return buff.toString();
		}
		return "";
	}


	public static Human convertToHuman(String humanStr){
		if(!"".equals(humanStr)){
			//解开当前行是什么类型的对象（student，teacher，cooker，driver）
			String[] datas = humanStr.split("@");
			if(datas!=null && datas.length==2){
				String type = datas[0];
				datas = datas[1].split("#");
				//共有的信息
				String id = datas[0];
				String name = datas[1];
				int age =Integer.parseInt( datas[2]);
				Human h = null;
				if(type.equalsIgnoreCase("student")){
					//Student对象
					String major = datas[3];
					h = new Student(id,name,age,major);
				}
				else  if(type.equalsIgnoreCase("teacher")){
					String course = datas[3];
					int salary = Integer.parseInt(datas[4]);
					h = new Teacher(id,name,age,course,salary);
				}
				else if(type.equalsIgnoreCase("driver")){
					int driveAge =Integer.parseInt( datas[3]);
					int salary = Integer.parseInt(datas[4]);
					h = new Driver(id,name,age,driveAge,salary);
				}
				else if(type.equalsIgnoreCase("cooker")){
					int grade = Integer.parseInt(datas[3]);
					int salary = Integer.parseInt(datas[4]);
					h = new Cooker(id,name,age,grade,salary);

				}
				return h;
			}
		}
		return null;
	}

	//吧Human对象生成业务上需求的字符串
	public static String geneHumanStr(Human h){
		if(h!=null){
			StringBuilder buff = new StringBuilder();
			buff.append(h.getId());
			buff.append("#").append(h.getName());
			buff.append("#").append(h.getAge());

			if(h instanceof Student){
				Student s = (Student)h;
				buff.insert(0,"student@");
				buff.append("#").append(s.getMajor());
			}
			else if(h instanceof Teacher){
				Teacher t = (Teacher)h;
				buff.insert(0,"teacher@");
				buff.append("#").append(t.getCourse());
				buff.append("#").append(t.getSalary());
			}
			else if( h instanceof Driver){
				Driver d = (Driver)h;
				buff.insert(0,"driver@");
				buff.append("#").append(d.getDriveAge());
				buff.append("#").append(d.getSalary());
			}
			else if(h instanceof Cooker){
				Cooker c = (Cooker)h;
				buff.insert(0,"cooker@");
				buff.append("#").append(c.getGrade());
				buff.append("#").append(c.getSalary());
			}
			return buff.toString();
		}
		return null;
	}
}