package com.yunsi.app1.service.impl;

import java.io.*;
import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.pojo.sub.*;
import com.yunsi.app1.exception.HRManagementException;
import com.yunsi.app1.util.*;


public class IOHRManagementImpl implements HRManagementIF{
	private Human[] humans;
	private Human[] readHumans;
	private int idx = 0;
	private int index = 0;
	public IOHRManagementImpl(){
		this(10);
	}
	public IOHRManagementImpl(int size){
		this.humans = new Human[size];
		this.readHumans = new Human[100];
	}

	public void save(Human h)throws HRManagementException,IOException,ClassNotFoundException{		
		//数组 = h;		
		if(h==null){
			throw new IllegalArgumentException("您添加的人员这个参数有问题（不能为null)");
		}
		if(exists(h.getId())){
			throw new HRManagementException("您添加的人员已经存在不能添加！"+h.getId());
		}
		//扩容
		//1.判断当前humans数组是否还有容量了（标准，如果humans里面已经满了，填不下了，立即扩容）
		if(idx>=this.humans.length){
			System.out.println("扩容了。。。");
			//2.扩容（所谓的扩容，就是新建一个与humans对象一样的数组，只不过长度要大于huamans的长度，至于大多少可以随意）
			Human[] temp = new Human[this.humans.length*2];
			System.arraycopy(this.humans,0,temp,0,idx);
			//3.让humans这个对象不要指向原来的地址（new Human[???]),然后指向上一步中扩容的那个临时数组
			this.humans = temp;
		}
        
		humans[idx++] = h;
	}

	//查询所有人员
	public Human[] queryAll() throws HRManagementException,IOException,ClassNotFoundException{
		Human[] result = new Human[getSize()];
		//Object obj = Serialization.deserializable();
		Student stu = null;
		return null;
	}
	/*
	public Human[] queryAll(){		
		Human[] result = new Human[getSize()];
		System.arraycopy(this.humans,0,result,0,result.length);
		return result;
		
		//return humans;
	}
	*/

	//根据id查询某个人员
	public Human query(String id){
		
        
		return null;
	}
	public void saveAll()throws HRManagementException,IOException,ClassNotFoundException{
		File file =new File("test.dat");
        FileOutputStream out = new FileOutputStream(file,true);
        ObjectOutputStream oos=new ObjectOutputStream(out);
        oos.writeObject(this.humans);
		out.close();
        oos.close();
		
	}
	public void readAll() throws HRManagementException,IOException,ClassNotFoundException{
		
        File file =new File("test.dat");
        FileInputStream is = new FileInputStream(file);
		
		ObjectInputStream ois = new ObjectInputStream(is);
		Object obj = ois.readObject();	
		Human[] human = (Human[]) obj;
		ois.close();
		for(Human h : human){
			if(h instanceof Student){
				Student s = (Student) h;
				if(index<=human.length)
				this.readHumans[index++]=h;			
			}else if(h instanceof Driver){
				Driver d = (Driver) h;
				this.readHumans[index++]=h;
			}else if(h instanceof Cooker){
				Cooker k = (Cooker) h;
				this.readHumans[index++]=h;
			}else if(h instanceof Teacher){
				Teacher t = (Teacher) h;
				this.readHumans[index++]=h;
			}
			
		}
		System.out.println(this.idx);
		System.out.println(this.index);

	}


	//获取所有人员个数，0表示没有人员
	public int getSize(){
		return idx;
	}

	//根据id删除某个人员
	public void remove(String id)throws HRManagementException{
		if(!exists(id)){
			//不存在的情况下报错（原理：不存在怎么删）
			throw new HRManagementException(id+"对应的人员不存在，不能删除！");
		}
		//1.第一步查找要删除的那个对象（对应的下标）
		boolean isRunning = false;//假设下面这个循环中的if不会执行
		int i=0;
		for(;i<this.getSize();i++){
			Human h = this.humans[i];
			if(h.getId().equals(id)){				
				isRunning = true;
				break;
			}
		}
		if(isRunning){
			//2.从这个下标开始标记到结尾之前一位
			for(int j=i;j<this.getSize()-1;j++){
				this.humans[j] = this.humans[j+1];
			}
			//遍历的时候当前下标的元素会被它后一个元素所覆盖，一直遍历到结尾。
			//3.添加的下标缩减一位
			idx--;
		}
	}

	public void update(Human h){
		
	}

	//控制台输出人员信息
	public void printHumans(Human... humans){
		
	}
	//通过id判断是否已经存在
	private boolean exists(String id){
		if(id==null ||"".equals(id)){
			return false;
		}
		for(int i=0;i<idx;i++){
			Human h = this.humans[i];
			if(h.getId().equals(id)){
				return true;
			}
		}
		return false;
	}
	public void arrayToLarge(){
		//获取当前数组大小
		int size = this.humans.length;
		Human[] newHumans = new Human[(int)(size*1.5)];//给原有数组扩容1.5倍
		/*
			* @param      src      源数组
			* @param      srcPos   源数组中的起始位置
			* @param      dest     目标数组
			* @param      destPos  目标数组中的起始位置
			* @param      length   需要被复制的元素个数
		*/
		//原来的数组拷贝到新数组上并把原数组的引用指向新数组
		System.arraycopy(this.humans,0,newHumans,0,this.getSize());		
		this.humans=newHumans;
	}	
}