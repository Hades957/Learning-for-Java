package  com.yunsi.app1.service.impl;

import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.exception.HRManagementException;

public class MemHRManagementImpl implements HRManagementIF
{

	private Human[] humans;//������Ա��ӵ����������
	private int addIdx;//��ӵ��±꣬��0��ʼ

	public MemHRManagementImpl(){
		this(10);
	}

	public MemHRManagementImpl(int size){
		this.humans = new Human[size];
		System.out.println("MemHRManagementImpl(...)....");
	}

	//��ѯ����ȡ����Ա
	public Human[] query(){
		if(addIdx>0){
			Human[] result = new Human[addIdx];
			System.arraycopy(this.humans,0,result,0,addIdx);
			return result;
		}
		return null;
	}

	//��ѯ����ȡ��ĳ����Ա
	public Human query(String id){
		/*
		Human[] allHumans = query();
		if(allHumans!=null){
			for(Human h : allHumans){
				if(h.getId().equals(id)){
					return h;
				}
			}
		}
		return null;
		*/
		return humanExists(id);
	}

	//�����Ա
	public void saveHuman(Human h)throws HRManagementException{
		if(h!=null){
			//1.�鿴���h�Ƿ��Ѿ�����
			if(humanExists(h.getId())!=null){
				throw new HRManagementException("��׼����ӵ���Ա�Ѿ������ˡ���Ŵ����ˡ�");
			}
			//2.��������ڼ������
			//2.1 �鿴�����Ƿ��������ã�����������
			if(addIdx>=this.humans.length){
				Human[] temp = new Human[this.humans.length*2];
				System.arraycopy(this.humans,0,temp,0,this.humans.length);
				this.humans = temp;
			}
			//2.2 ������
			this.humans[addIdx++] = h;
		}
	}

	//�ж���Ա�ڲ���
	/*
	private boolean humanExists(Human h){
		if(h!=null){
			for(int i=0;i<addIdx;i++){
				if(this.humans[i].getId().equals(h.getId())){
					return true;
				}
			}
		}
		return false;
	}
	*/
	private Human humanExists(String id){		
		for(int i=0;i<addIdx;i++){
			if(this.humans[i].getId().equals(id)){
				return this.humans[i];
			}
		}		
		return null;
	}



	//�޸���Ա
	public void updateHuman(Human h){
		if(h!=null){
			for(int i=0;i<addIdx;i++){
				if(this.humans[i].getId().equals(h.getId())){
					this.humans[i] = h;
					break;
				}
			}
		}
	}

	//ɾ����Ա
	public void removeHuman(String id){
		System.out.println("ɾ��id=["+id+"]");
		boolean exists = false;
		int i=0;
		for(;i<addIdx;i++){
			if(this.humans[i].getId().equals(id)){
				exists = true;
				break;
			}
		}
		if(exists){
			for(int j=i;j<addIdx-1;j++){
				this.humans[j] = this.humans[j+1];
			}
			this.addIdx--;
			System.out.println("����ɾ��������");
		}
	}
}