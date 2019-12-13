package com.yunsi.app1.service;

import com.yunsi.app1.exception.HRManagementException;
import com.yunsi.app1.pojo.Human;


public interface HRManagementIF
{
	//��ѯ����ȡ����Ա
	public Human[] query();

	//��ѯ����ȡ��ĳ����Ա
	public Human query(String id);

	//�����Ա
	public void saveHuman(Human h)throws HRManagementException;

	//�޸���Ա
	public void updateHuman(Human h);

	//ɾ����Ա
	public void removeHuman(String id);
}