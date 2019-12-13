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
	private static final String FILE_NAME = "humans.txt";//�ı��ļ�������������ĸ�ʽ
	/*
		student@���#����#����#...��������...
		teacher@���#����#����#...��������...
		cooker@���#����#����#...��������...
		driver@���#����#����#...��������...
		student@���#����#����#...��������...
	*/

	public DiskHRManagementImpl(){
		System.out.println("DiskHRManagementImpl()...");
	}

	//��ѯ����ȡ����Ա
	public Human[] query(){
		Human[] humans = new Human[2];//Ĭ��2��
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
			//ѹ��һ�����humans����Ϊ������null
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

	//��ѯ����ȡ��ĳ����Ա
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

	//�����Ա
	public void saveHuman(Human h)throws HRManagementException{
		if(h!=null){
			Human hh = query(h.getId());
			if(hh!=null){
				throw new HRManagementException("�鵽�����Ա�ظ��ˡ�����");
			}
			String humanStr = HumanTools.geneHumanStr(h);
			try(
				PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME,true));//�ۼ�ģʽ
			){
				pw.println(humanStr);
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}

	//�޸���Ա
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
				//�����ļ�
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

	//ɾ����Ա
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