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
	//main����
	//��ں�����������
	public static void main(String[] arsg) throws HRManagementException,IOException,ClassNotFoundException{
		/*
		HRManagementIF hr = new HRManagementImpl(3);
		


		//����ѧ������ʦ����ʦ����ʻԱ
		Student s = new Student("320114","ѧ��1",20,"�����");
		Teacher t = new Teacher("320115","��ʦ1",50,"��������",8989);
		Cooker c = new Cooker("320116","��ʦ1",55,1,9090);
		Driver d = new Driver("320117","˾��1",56,20,101010);
		Driver d2 = new Driver("320117","˾��2",57,21,101011);
		//d2 = null;
		//Human human= new Human("hhh",30);

		//��ʾ������Դ��ز���
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
		System.out.println("�鿴��������"+size);


		//��ѯ������Ա
		Human[] humans = hr.queryAll();
		//����̨��ӡ��Щ�˵���Ϣ
		System.out.println("$$�����Ա֮����ʾ��������Ϣ��");
		hr.printHumans(humans);

		

		//ɾ����Ա
		//hr.remove(tt);
		try{
			String id = "320115";
			id = null;
			hr.remove(id);
		}catch(HRManagementException e){
			e.printStackTrace();
		}

		//�ٴβ�ѯ������
		humans = hr.queryAll();
		System.out.println("$$ɾ��֮����ʾ�����˵���Ϣ��");
		hr.printHumans(humans);

		
		//��ѯĳ����Ա
		Human h = hr.query("320117");
		System.out.println("$$��ѯ320117����ˣ�");
		hr.printHumans(h);



		//�޸���Ա
		Teacher tt = new Teacher("320117","��ʦ2",51,"����",7878);
		tt = null;
		hr.update(tt);
		System.out.println("\n\n$$�޸�320117�����֮����ʾ��������Ϣ��");
		hr.printHumans(hr.queryAll());

*/
		
		IOHRManagementImpl iohr = new IOHRManagementImpl();
		Student s = new Student("320114","ѧ��1",20,"�����");
		Teacher t = new Teacher("320115","��ʦ1",50,"��������",8989);
		Cooker c = new Cooker("320116","��ʦ1",55,1,9090);
		iohr.save(c);		
		iohr.save(t);
		iohr.save(s);
		iohr.saveAll();
		iohr.readAll();
		//Serialization.deserializable();
	} 
}