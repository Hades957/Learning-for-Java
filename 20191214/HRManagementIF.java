package com.yunsi.app1.service;

import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.exception.HRManagementException;

public interface HRManagementIF
{
	//查询人员
	public Human[] query();
	//查询某个人员
	public Human query(String id);
	//添加人员
	public void saveHuman(Human h) throws HRManagementException;
	//修改人员
	public void updateHuman(Human h);
	//删除人员
	public void removeHuman(String id);
}
