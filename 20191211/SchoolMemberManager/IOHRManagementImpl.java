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
		//���� = h;		
		if(h==null){
			throw new IllegalArgumentException("����ӵ���Ա������������⣨����Ϊnull)");
		}
		if(exists(h.getId())){
			throw new HRManagementException("����ӵ���Ա�Ѿ����ڲ�����ӣ�"+h.getId());
		}
		//����
		//1.�жϵ�ǰhumans�����Ƿ��������ˣ���׼�����humans�����Ѿ����ˣ�����ˣ��������ݣ�
		if(idx>=this.humans.length){
			System.out.println("�����ˡ�����");
			//2.���ݣ���ν�����ݣ������½�һ����humans����һ�������飬ֻ��������Ҫ����huamans�ĳ��ȣ����ڴ���ٿ������⣩
			Human[] temp = new Human[this.humans.length*2];
			System.arraycopy(this.humans,0,temp,0,idx);
			//3.��humans�������Ҫָ��ԭ���ĵ�ַ��new Human[???]),Ȼ��ָ����һ�������ݵ��Ǹ���ʱ����
			this.humans = temp;
		}
        
		humans[idx++] = h;
	}

	//��ѯ������Ա
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

	//����id��ѯĳ����Ա
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


	//��ȡ������Ա������0��ʾû����Ա
	public int getSize(){
		return idx;
	}

	//����idɾ��ĳ����Ա
	public void remove(String id)throws HRManagementException{
		if(!exists(id)){
			//�����ڵ�����±���ԭ����������ôɾ��
			throw new HRManagementException(id+"��Ӧ����Ա�����ڣ�����ɾ����");
		}
		//1.��һ������Ҫɾ�����Ǹ����󣨶�Ӧ���±꣩
		boolean isRunning = false;//�����������ѭ���е�if����ִ��
		int i=0;
		for(;i<this.getSize();i++){
			Human h = this.humans[i];
			if(h.getId().equals(id)){				
				isRunning = true;
				break;
			}
		}
		if(isRunning){
			//2.������±꿪ʼ��ǵ���β֮ǰһλ
			for(int j=i;j<this.getSize()-1;j++){
				this.humans[j] = this.humans[j+1];
			}
			//������ʱ��ǰ�±��Ԫ�ػᱻ����һ��Ԫ�������ǣ�һֱ��������β��
			//3.��ӵ��±�����һλ
			idx--;
		}
	}

	public void update(Human h){
		
	}

	//����̨�����Ա��Ϣ
	public void printHumans(Human... humans){
		
	}
	//ͨ��id�ж��Ƿ��Ѿ�����
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
		//��ȡ��ǰ�����С
		int size = this.humans.length;
		Human[] newHumans = new Human[(int)(size*1.5)];//��ԭ����������1.5��
		/*
			* @param      src      Դ����
			* @param      srcPos   Դ�����е���ʼλ��
			* @param      dest     Ŀ������
			* @param      destPos  Ŀ�������е���ʼλ��
			* @param      length   ��Ҫ�����Ƶ�Ԫ�ظ���
		*/
		//ԭ�������鿽�����������ϲ���ԭ���������ָ��������
		System.arraycopy(this.humans,0,newHumans,0,this.getSize());		
		this.humans=newHumans;
	}	
}