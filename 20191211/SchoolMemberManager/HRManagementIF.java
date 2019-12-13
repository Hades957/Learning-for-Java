package com.yunsi.app1.service;

import java.io.*;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.exception.HRManagementException;


public interface HRManagementIF
{	

	//�����Ա
	public void save(Human h)throws HRManagementException,IOException,ClassNotFoundException;

	//��ѯ������Ա
	public Human[] queryAll() throws HRManagementException,IOException,ClassNotFoundException;


	//����id��ѯĳ����Ա
	public Human query(String id);


	//��ȡ������Ա������0��ʾû����Ա
	public int getSize();

	//����idɾ��ĳ����Ա
	public void remove(String id)throws HRManagementException,IOException,ClassNotFoundException;

	public void update(Human h);

	//����̨�����Ա��Ϣ
	public void printHumans(Human... humans);
}