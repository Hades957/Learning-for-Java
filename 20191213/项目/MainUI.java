//������
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

	//��������
	public void start(){
		outer:while(true){
			showMainFrame();
			
			System.out.println("������ָ�");
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
				System.out.println("***û�����ָ�����������***");
			}
		}
	}
	
	//������
	private void showMainFrame(){
		System.out.println("****��Ա����****");
		System.out.println("*1.�����Ա     *");
        System.out.println("*2.��ѯ������Ա *");
        System.out.println("*3.��ѯĳ����   *");
        System.out.println("*4.������Ա     *");
        System.out.println("*5.ɾ����Ա     *");
        System.out.println("*6.�˳�Ӧ��     *");
		System.out.println("*****************");  
	}

	//ɾ������
	private void showRemoveHumanFrame()throws IOException{
		System.out.println("***ɾ����Ա����***");
		System.out.println("�������ţ�");
		String id = br.readLine();
		hr.removeHuman(id);

		
	}

	//������Ա����
	//�����Ա����
	private void showUpdateHumanFrame()throws IOException{
		System.out.println("***������Ա����***");
		Human h = null;
		while(true){
			System.out.println("���:");
			String id = br.readLine();

			//�ô���������Ϣ��ʾ
			h = hr.query(id);
			if(h==null){
				System.out.println("�Ҳ���Ҫ���µ���Ա");
			}
			else{
				System.out.println(HumanTools.getPrintInfoOnConsole(h));
				break;
			}
		}


		System.out.println("������("+h.getName()+",�޸�������)");
		String name = br.readLine();
		if(name!=null &&!"".equals(name)){
			h.setName(name);
		}

		int age = -1;
		while(true){
			System.out.println("���䣺("+h.getAge()+")");

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
					System.out.println("**���䲻���������������ֱ�ʾ���䡣**");
				}
			}
		}

		if(h instanceof Student){
			Student s = (Student)h;
			System.out.println("רҵ��("+s.getMajor()+")");
			String major = br.readLine();
			if(major!=null && !"".equals(major)){
				s.setMajor(major);
			}
			
		}
		else if(h instanceof Teacher){
			Teacher t = (Teacher)h;			
			System.out.println("���ڿγ̣�("+t.getCourse()+")");
			String course = br.readLine();
			if(course!=null && !"".equals(course)){
				t.setCourse(course);
			}
			System.out.println("н�ʣ�("+t.getSalary()+")");
			String salary = br.readLine();
			if(salary!=null && !"".equals(salary)){
				t.setSalary(Integer.parseInt(salary));
			}
		}
		else if( h instanceof Driver){
			Driver d = (Driver)h;
			System.out.println("���䣺("+d.getDriveAge()+")");
			String driveAge = br.readLine();
			if(driveAge!=null && !"".equals(driveAge)){
				d.setDriveAge(Integer.parseInt(driveAge));
			}
			System.out.println("н�ʣ�("+d.getSalary()+")");
			String salary = br.readLine();
			if(salary!=null && !"".equals(salary)){
				d.setSalary(Integer.parseInt(salary));
			}
		}
		else if(h instanceof Cooker){
			Cooker c = (Cooker)h;
			System.out.println("����("+c.getGrade()+")");
			String grade = br.readLine();
			if(grade!=null && !"".equals(grade)){
				c.setGrade(Integer.parseInt(grade));
			}
			System.out.println("н�ʣ�("+c.getSalary()+")");
			String salary = br.readLine();
			if(salary!=null && !"".equals(salary)){
				c.setSalary(Integer.parseInt(salary));
			}
		}
		
		
		//��serviceִ��ʵ����Ӳ���		
		hr.updateHuman(h);
		System.out.println("**������Ա���**");		
	}

	//��ѯĳ����Ա����
	private void showQueryFrame()throws IOException{
		System.out.println("***��ѯĳ���˽���***");
		System.out.println("��������:");
		String id = br.readLine();
		Human human = hr.query(id);
		if(human!=null){
			System.out.println(HumanTools.getPrintInfoOnConsole(human));			
		}
		else{
			System.out.println("���޴���");
		}
	}
	//��ѯ������Ա����
	private void showQueryAllFrame(){
		System.out.println("***��ѯ�����˽���***");
		Human[] humans = hr.query();
		if(humans!=null){
			for(Human h : humans){
				System.out.println(HumanTools.getPrintInfoOnConsole(h));
			}
		}
	}

	//�����Ա����
	private void showAddHumanFrame()throws IOException{
		System.out.println("***�����Ա����***");
		System.out.println("���:");
		String id = br.readLine();

		System.out.println("������");
		String name = br.readLine();

		int age = -1;
		while(true){
			System.out.println("���䣺");
			String ageStr = br.readLine();
			try{
				age = Integer.parseInt(ageStr);
				break;
			}catch(NumberFormatException e){
				//...
				System.out.println("**���䲻���������������ֱ�ʾ���䡣**");
			}
		}

		Human savingHuman = null;
		//�����ǻ�����Ϣ��������������Ϣ
		System.out.println("ѡ����ӵ���Ա���ͣ�ѧ��(S),��ʦ(T),��ʦ(C),��ʻԱ(D),Ĭ��ѧ����");
		String type = br.readLine();
		if(type==null || "".equals(type) || type.equalsIgnoreCase("S")){
			//ѧ��
			System.out.println("רҵ:");
			String major = br.readLine();
			savingHuman = new Student(id,name,age,major);
		}
		else if(type.equalsIgnoreCase("T")){
			//��ʦ
			System.out.println("�γ̣�");
			String course = br.readLine();

			System.out.println("н��:");
			int salary = Integer.parseInt(br.readLine());
			//�����ж�

			savingHuman = new Teacher(id,name,age,course,salary);

		}
		else if(type.equalsIgnoreCase("C")){
			//��ʦ
			System.out.println("�ȼ���");
			int grade = Integer.parseInt(br.readLine());

			System.out.println("н��:");
			int salary = Integer.parseInt(br.readLine());
			//�����ж�
			savingHuman = new Cooker(id,name,age,grade,salary);
		}
		else if(type.equalsIgnoreCase("D")){
			//��ʻԱ
			System.out.println("���䣺");
			int driveAge = Integer.parseInt(br.readLine());
			
			System.out.println("н��:");
			int salary = Integer.parseInt(br.readLine());
			//�����ж�

			savingHuman = new Driver(id,name,age,driveAge,salary);

		}

		//��serviceִ��ʵ����Ӳ���
		try{
			hr.saveHuman(savingHuman);
			System.out.println("**������Ա���**");
		}catch(HRManagementException e){
			e.printStackTrace();
		}
	}
}
