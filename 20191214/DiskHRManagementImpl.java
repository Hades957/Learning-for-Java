package com.yunsi.app1.service.impl;

import com.yunsi.app1.service.*;
import com.yunsi.app1.pojo.*;
import com.yunsi.app1.pojo.sub.*;
import com.yunsi.app1.exception.HRManagementException;
import com.yunsi.app1.util.*;
import java.io.*;

public class DiskHRManagementImpl implements HRManagementIF
{
	//读取的文件
	private static final String FILE_NAME = "human.txt";
		
	//构造方法
	public DiskHRManagementImpl(){
		System.out.println("DiskHRManagementImpl()...");
		
	}


	//查询人员
	public Human[] query(){
		Human[] humans = new Human[2];
		int addIdx = 0;
		checkFile();
		try(BufferedReader br = new BufferedReader(new FileReader(FILE_NAME))){
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
			//压缩,可能有Null
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

	//查询某个人员
	public Human query(String id){
		checkFile();
		try(BufferedReader br = new BufferedReader(new FileReader("human.txt"))){
			String line = null;
			while((line = br.readLine())!=null){
				//读取到的字符串再转成Human对象
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
	public void saveHuman(Human h) throws HRManagementException{
		if(h!=null){
			//查询是否重复重复就抛出异常
			if(exists(h)){//若存在
				throw new HRManagementException("这个人已经存在!!!");
			}else{//若不存在,存入磁盘
				//1. 先将h转成字符串
				String humanStr = HumanTools.geneHumanStr(h);
				checkFile();
				//2. 通过PrintWriter将字符串写入文件
				try(					
					PrintWriter pw = new PrintWriter(new FileWriter(FILE_NAME,true));//累加
				){
					pw.println(humanStr);
				}catch(IOException e){
					e.printStackTrace();
				}
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
				try(PrintWriter pw = new PrintWriter(FILE_NAME);){
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
			//将文件中所有信息取出
			Human[] humans = query();
			int i = 0;
			//判断是否存在要删除的对象
			boolean exists = false;
			for(;i<humans.length;i++){
				Human h = humans[i];
				if(h.getId().equals(id)){
					exists = true;
					break;
				}
			}
			if(exists){
				//用后一个将前一个覆盖的方法删除
				for(int j=i;j<humans.length-1;j++){
					humans[j]=humans[j+1];
				}
				Human[] tempHumans = new Human[humans.length-1];
				System.arraycopy(humans,0,tempHumans,0,tempHumans.length);
				//将删除后的数组，重新写入文件中
				checkFile();
				try(PrintWriter pw = new PrintWriter(FILE_NAME)){
					for(Human hh : tempHumans){
						pw.println(HumanTools.geneHumanStr(hh));
					}
				}catch(IOException e){
					e.printStackTrace();
				}
				System.out.println("删除成功!!!");
			}
		}
	}
	
	//查询是否已经存在
	public boolean exists(Human h){
		if(h!=null){
			Human hh = query(h.getId());
			if(hh!=null){
				return true;
			}
			return false;			
		}
		return false;
	}
	
	//检查存档文件是否存在，如果不存在则新建文件防止出现找不到文件异常
	public void checkFile(){
		File file = new File("human.txt");
		if(!file.exists()){
			try{
				file.createNewFile();
			}catch(IOException e){
				e.printStackTrace();
			}
		}
	}
}