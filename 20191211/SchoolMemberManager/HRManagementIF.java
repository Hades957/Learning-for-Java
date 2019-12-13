package com.yunsi.app1.service;

import java.io.*;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.exception.HRManagementException;


public interface HRManagementIF
{	

	//添加人员
	public void save(Human h)throws HRManagementException,IOException,ClassNotFoundException;

	//查询所有人员
	public Human[] queryAll() throws HRManagementException,IOException,ClassNotFoundException;


	//根据id查询某个人员
	public Human query(String id);


	//获取所有人员个数，0表示没有人员
	public int getSize();

	//根据id删除某个人员
	public void remove(String id)throws HRManagementException,IOException,ClassNotFoundException;

	public void update(Human h);

	//控制台输出人员信息
	public void printHumans(Human... humans);
}