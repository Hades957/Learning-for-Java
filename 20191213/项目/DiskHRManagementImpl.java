package com.yunsi.app1.service.impl;

import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.pojo.Student;
import com.yunsi.app1.pojo.Teacher;
import com.yunsi.app1.pojo.Driver;
import com.yunsi.app1.pojo.Cooker;
import com.yunsi.app1.exception.HRManagementException;
import com.yunsi.app1.util.HumanTools;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.BufferedReader;
import java.io.PrintWriter;
import java.io.IOException;


public class DiskHRManagementImpl implements HRManagementIF
{
	private static final String FILE_NAME = "humans.txt";//文本文件，另外它里面的格式
	/*
		student@编号#姓名#年龄#...特有属性...
		teacher@编号#姓名#年龄#...特有属性...
		cooker@编号#姓名#年龄#...特有属性...
		driver@编号#姓名#年龄#...特有属性...
		student@编号#姓名#年龄#...特有属性...
	*/

	public DiskHRManagementImpl(){
		System.out.println("DiskHRManagementImpl()...");
	}

	//查询（获取）人员
	public Human[] query(){
		Human[] humans = new Human[2];//默认2个
		int addIdx = 0;
		try(BufferedReader br =
				new BufferedReader(
					new FileReader(FILE_NAME))){
			String line = null;
			while((line = br.readLine())!=null){
				Human hh = HumanTools.convertToHuman(line);
				if(addIdx>=humans.length){
					Human[] temp = new Human[humans.length*2];
					System.arraycopy(humans,0,temp,0,humans.length);
					humans = temp;
				}
				humans[addIdx++] = hh;
			}
			//压缩一下这个humans，因为可能有null
			if(addIdx>0){
				Human[] result = new Human[addIdx];
				System.arraycopy(humans,0,result,0,addIdx);
				return result;
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	//查询（获取）某个人员
	public Human query(String id){

		try(BufferedReader br = new BufferedReader(new FileReader("humans.txt"))){
			String line = null;
			while((line = br.readLine())!=null){
				Human h = HumanTools.convertToHuman(line);
				if(h!=null && h.getId().equals(id)){
					return h;
				}
			}
		}catch(IOException e){
			e.printStackTrace();
		}
		return null;
	}

	//添加人员
	public void saveHuman(Human h)throws HRManagementException{
		if(h!=null){
			Human hh = query(h.getId());
			if(hh!=null){
				throw new HRManagementException("查到真个人员重复了。。。");
			}
			String humanStr = HumanTools.geneHumanStr(h);
			try(
				PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME,true));//累加模式
			){
				pw.println(humanStr);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	//修改人员
	public void updateHuman(Human h){
		if(h!=null){
			Human[] humans = query();
			boolean exists = false;
			for(int i=0;i<humans.length;i++){
				Human hh = humans[i];
				if(hh.getId().equals(h.getId())){
					humans[i] = h;
					exists = true;
					break;
				}
			}
			if(exists){
				//覆盖文件
				try(PrintWriter pw =new PrintWriter(FILE_NAME);){
					for(Human hh : humans){
						pw.println(HumanTools.geneHumanStr(hh));
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}

	//删除人员
	public void removeHuman(String id){
		if(id!=null && !"".equals(id)){
			Human[] humans = query();
			int i=0;
			boolean exists= false;
			for(;i<humans.length;i++){
				Human h = humans[i];
				if(h.getId().equals(id)){
					exists = true;
					break;
				}
			}
			if(exists){
				for(int j=i;j<humans.length-1;j++){
					humans[j] = humans[j+1];
				}
				Human[] tempHumans = new Human[humans.length-1];
				System.arraycopy(humans,0,tempHumans,0,tempHumans.length);
				try(PrintWriter pw = new PrintWriter(FILE_NAME)){
					for(Human hh : tempHumans){
						pw.println(HumanTools.geneHumanStr(hh));
					}
				}catch(IOException e){
					e.printStackTrace();
				}
			}
		}
	}
}