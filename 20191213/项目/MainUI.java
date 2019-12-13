//界面类
package com.yunsi.app1.ui;

import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.pojo.Driver;
import com.yunsi.app1.pojo.Teacher;
import com.yunsi.app1.pojo.Student;
import com.yunsi.app1.pojo.Cooker;
import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.service.impl.MemHRManagementImpl;
import com.yunsi.app1.service.impl.DiskHRManagementImpl;
import com.yunsi.app1.exception.HRManagementException;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

import com.yunsi.app1.util.HumanTools;

public class MainUI
{

	private BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
	//private HRManagementIF hr = new MemHRManagementImpl();
	private HRManagementIF hr = new DiskHRManagementImpl();

	//启动界面
	public void start(){
		outer:while(true){
			showMainFrame();
			
			System.out.println("请输入指令：");
			try{
				String oper = br.readLine();
				int command = Integer.parseInt(oper);
				switch(command){
					case 1:showAddHumanFrame();break;
					case 2:showQueryAllFrame();break;
					case 3:showQueryFrame();break;
					case 4:showUpdateHumanFrame();break;
					case 5:showRemoveHumanFrame();break;
					case 6:break outer;
				}
			}catch(IOException e){
				e.printStackTrace();
			}catch(NumberFormatException e){
				//...
				System.out.println("***没有这个指令，请重新输入***");
			}
		}
	}
	
	//主界面
	private void showMainFrame(){
		System.out.println("****人员管理****");
		System.out.println("*1.添加人员     *");
        System.out.println("*2.查询所有人员 *");
        System.out.println("*3.查询某个人   *");
        System.out.println("*4.更新人员     *");
        System.out.println("*5.删除人员     *");
        System.out.println("*6.退出应用     *");
		System.out.println("*****************");  
	}

	//删除界面
	private void showRemoveHumanFrame()throws IOException{
		System.out.println("***删除人员界面***");
		System.out.println("请输入编号：");
		String id = br.readLine();
		hr.removeHuman(id);

		
	}

	//更新人员界面
	//添加人员界面
	private void showUpdateHumanFrame()throws IOException{
		System.out.println("***更新人员界面***");
		Human h = null;
		while(true){
			System.out.println("编号:");
			String id = br.readLine();

			//让此人所有信息显示
			h = hr.query(id);
			if(h==null){
				System.out.println("找不到要更新的人员");
			}
			else{
				System.out.println(HumanTools.getPrintInfoOnConsole(h));
				break;
			}
		}


		System.out.println("姓名：("+h.getName()+",修改请输入)");
		String name = br.readLine();
		if(name!=null &&!"".equals(name)){
			h.setName(name);
		}

		int age = -1;
		while(true){
			System.out.println("年龄：("+h.getAge()+")");

			String ageStr = br.readLine();
			if(ageStr==null || "".equals(ageStr)){
				age = h.getAge();
				break;
			}
			else{
				try{
					age = Integer.parseInt(ageStr);
					h.setAge(age);
					break;
				}catch(NumberFormatException e){
					//...
					System.out.println("**年龄不是数字请输入数字表示年龄。**");
				}
			}
		}

		if(h instanceof Student){
			Student s = (Student)h;
			System.out.println("专业：("+s.getMajor()+")");
			String major = br.readLine();
			if(major!=null && !"".equals(major)){
				s.setMajor(major);
			}
			
		}
		else if(h instanceof Teacher){
			Teacher t = (Teacher)h;			
			System.out.println("教授课程：("+t.getCourse()+")");
			String course = br.readLine();
			if(course!=null && !"".equals(course)){
				t.setCourse(course);
			}
			System.out.println("薪资：("+t.getSalary()+")");
			String salary = br.readLine();
			if(salary!=null && !"".equals(salary)){
				t.setSalary(Integer.parseInt(salary));
			}
		}
		else if( h instanceof Driver){
			Driver d = (Driver)h;
			System.out.println("驾龄：("+d.getDriveAge()+")");
			String driveAge = br.readLine();
			if(driveAge!=null && !"".equals(driveAge)){
				d.setDriveAge(Integer.parseInt(driveAge));
			}
			System.out.println("薪资：("+d.getSalary()+")");
			String salary = br.readLine();
			if(salary!=null && !"".equals(salary)){
				d.setSalary(Integer.parseInt(salary));
			}
		}
		else if(h instanceof Cooker){
			Cooker c = (Cooker)h;
			System.out.println("级别：("+c.getGrade()+")");
			String grade = br.readLine();
			if(grade!=null && !"".equals(grade)){
				c.setGrade(Integer.parseInt(grade));
			}
			System.out.println("薪资：("+c.getSalary()+")");
			String salary = br.readLine();
			if(salary!=null && !"".equals(salary)){
				c.setSalary(Integer.parseInt(salary));
			}
		}
		
		
		//找service执行实际添加操作		
		hr.updateHuman(h);
		System.out.println("**更新人员完毕**");		
	}

	//查询某个人员界面
	private void showQueryFrame()throws IOException{
		System.out.println("***查询某个人界面***");
		System.out.println("请输入编号:");
		String id = br.readLine();
		Human human = hr.query(id);
		if(human!=null){
			System.out.println(HumanTools.getPrintInfoOnConsole(human));			
		}
		else{
			System.out.println("查无此人");
		}
	}
	//查询所有人员界面
	private void showQueryAllFrame(){
		System.out.println("***查询所有人界面***");
		Human[] humans = hr.query();
		if(humans!=null){
			for(Human h : humans){
				System.out.println(HumanTools.getPrintInfoOnConsole(h));
			}
		}
	}

	//添加人员界面
	private void showAddHumanFrame()throws IOException{
		System.out.println("***添加人员界面***");
		System.out.println("编号:");
		String id = br.readLine();

		System.out.println("姓名：");
		String name = br.readLine();

		int age = -1;
		while(true){
			System.out.println("年龄：");
			String ageStr = br.readLine();
			try{
				age = Integer.parseInt(ageStr);
				break;
			}catch(NumberFormatException e){
				//...
				System.out.println("**年龄不是数字请输入数字表示年龄。**");
			}
		}

		Human savingHuman = null;
		//以上是基本信息，下面是特有信息
		System.out.println("选择添加的人员类型：学生(S),教师(T),厨师(C),驾驶员(D),默认学生。");
		String type = br.readLine();
		if(type==null || "".equals(type) || type.equalsIgnoreCase("S")){
			//学生
			System.out.println("专业:");
			String major = br.readLine();
			savingHuman = new Student(id,name,age,major);
		}
		else if(type.equalsIgnoreCase("T")){
			//教师
			System.out.println("课程：");
			String course = br.readLine();

			System.out.println("薪资:");
			int salary = Integer.parseInt(br.readLine());
			//忽略判断

			savingHuman = new Teacher(id,name,age,course,salary);

		}
		else if(type.equalsIgnoreCase("C")){
			//厨师
			System.out.println("等级：");
			int grade = Integer.parseInt(br.readLine());

			System.out.println("薪资:");
			int salary = Integer.parseInt(br.readLine());
			//忽略判断
			savingHuman = new Cooker(id,name,age,grade,salary);
		}
		else if(type.equalsIgnoreCase("D")){
			//驾驶员
			System.out.println("驾龄：");
			int driveAge = Integer.parseInt(br.readLine());
			
			System.out.println("薪资:");
			int salary = Integer.parseInt(br.readLine());
			//忽略判断

			savingHuman = new Driver(id,name,age,driveAge,salary);

		}

		//找service执行实际添加操作
		try{
			hr.saveHuman(savingHuman);
			System.out.println("**保存人员完毕**");
		}catch(HRManagementException e){
			e.printStackTrace();
		}
	}
}
