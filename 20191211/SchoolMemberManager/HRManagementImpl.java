package com.yunsi.app1.service.impl;

import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.pojo.sub.*;
import com.yunsi.app1.exception.HRManagementException;

/*
	���ã�����ͨ���˶�������Ա��Teacher��Driver��Cooker��Student�ȣ��������µ�һ������
		���磺������Ա��Ϣ
				��ѯ��Ա
				�޸���Ա
				ɾ����Ա
*/
public class HRManagementImpl implements HRManagementIF
{
	//���鶨�壨 ��Ϊ���������ԣ�
	private Human[] humans;
	private int idx = 0;
	
	public HRManagementImpl(){
		this(10);
	}
	public HRManagementImpl(int size){
		this.humans = new Human[size];
	}
	//�ȽϺõ����������Բ��ö�̬��������ɣ��Բ���Ӧ��䡣
	public void save(Human h)throws HRManagementException{		
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
	public Human[] queryAll(){
		
		Human[] result = new Human[getSize()];
		System.arraycopy(this.humans,0,result,0,result.length);
		return result;
		
		//return humans;
	}
	//��ȡ������Ա������0��ʾû����Ա
	public int getSize(){
		return idx;
	}

	//ɾ����Ա
	public void remove(Human h)throws HRManagementException{

	}
	/*
	void remove(������Ա��Human��������Ψһ��Ϣ�ģ�{
		
	}
	*/
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
		//1.��ѯ������������id���Ƿ���ڣ����ھ�ֱ�Ӹ���humans���Ե�ǰ���Ԫ�ء�
		if(h!=null){
			for(int i=0;i<this.idx;i++){
				Human hh = this.humans[i];
				if(h.getId().equals(hh.getId())){
					this.humans[i] = h;
					break;
				}
			}
		}else{
			System.out.println("## ��Ҫ�޸ĵ���Ա����������## ");
		}
	}
	
	/*
	Human query(Ψһ��Ϣ�ܱ���ĳ�������Human){

	}
	*/
	//����id��ѯĳ����Ա
	public Human query(String id){
		for(int i=0;i<getSize();i++){
			Human h = this.humans[i];
			if(h.getId().equals(id)){
				return h;
			}
		}
		return null;
	}


	//����̨�����Ա��Ϣ
	
	public void printHumans(Human... humans){

		if(humans!=null){
			//��������߼��ǡ�������ѭ���������Human������������Ϣ��
			//�Żᵼ�ºܶ�����ǿ��ת����
			//���������Ϊ��������ô�����ֲ�һ���ˡ�
			for(Human man : humans){
				String details = man.getDetails();
				System.out.println(details);
				/*
				if(man==null){
					break;
				}
				System.out.println(man.getId()+" "+man.getName()+" "+man.getAge());
				if(man instanceof Student){
					Student stu= (Student)man;
					//...
				}
				else if(man instanceof Teacher){
					Teacher te = (Teacher)man;
					//...
				}
				else if(man instanceof Driver){
					Driver dri = (Driver)man;
					//...
				}
				else if(man instanceof Cooker){
					Cooker co = (Cooker)man;
					//...
				}
				*/
			}
		}
	}

	

	//��������Ƿ���ڣ�true���ڣ�false������
	private boolean exists(String id){
		/*
		boolean exists = false;//���費����
		for(int i=0;i<idx;i++){
			Human h = this.humans[i];
			if(h.getId().equals(id)){
				exists = true;
				break;
			}
		}
		return exists;
		*/
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



	////////////////////////////////////////////////////////////////////
	//�����������ÿһ�����������ͣ����磺Teacher��Student�ȣ����ṩһ��ά������
	//�������ã�ԭ��δ���ٳ���һЩ����Teacher��Student���࣬��ô����Ҫ��ͣ�Ķ����µķ�����
	/*
	void saveTeacher(Teacher t){

	}
	void removeTeacher(Teacher t){

	}
	void updateTeacher(Teacher t){

	}
	Teacher[] queryTeachers(){

	}
	*/

}