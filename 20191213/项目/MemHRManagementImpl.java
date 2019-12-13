package  com.yunsi.app1.service.impl;

import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.exception.HRManagementException;

public class MemHRManagementImpl implements HRManagementIF
{

	private Human[] humans;//最终人员添加到这个数组中
	private int addIdx;//添加的下标，从0开始

	public MemHRManagementImpl(){
		this(10);
	}

	public MemHRManagementImpl(int size){
		this.humans = new Human[size];
		System.out.println("MemHRManagementImpl(...)....");
	}

	//查询（获取）人员
	public Human[] query(){
		if(addIdx>0){
			Human[] result = new Human[addIdx];
			System.arraycopy(this.humans,0,result,0,addIdx);
			return result;
		}
		return null;
	}

	//查询（获取）某个人员
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

	//添加人员
	public void saveHuman(Human h)throws HRManagementException{
		if(h!=null){
			//1.查看这个h是否已经存在
			if(humanExists(h.getId())!=null){
				throw new HRManagementException("您准备添加的人员已经存在了【编号存在了】");
			}
			//2.如果不存在继续添加
			//2.1 查看数组是否容量够用，不够用增容
			if(addIdx>=this.humans.length){
				Human[] temp = new Human[this.humans.length*2];
				System.arraycopy(this.humans,0,temp,0,this.humans.length);
				this.humans = temp;
			}
			//2.2 添加完毕
			this.humans[addIdx++] = h;
		}
	}

	//判断人员在不在
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



	//修改人员
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

	//删除人员
	public void removeHuman(String id){
		System.out.println("删除id=["+id+"]");
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
			System.out.println("真正删除。。。");
		}
	}
}