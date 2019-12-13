package com.yunsi.app1.service.impl;

import com.yunsi.app1.service.HRManagementIF;
import com.yunsi.app1.pojo.Human;
import com.yunsi.app1.pojo.sub.*;
import com.yunsi.app1.exception.HRManagementException;

/*
	作用：就是通过了对以上人员（Teacher，Driver，Cooker，Student等）进行人事的一个服务
		例如：保存人员信息
				查询人员
				修改人员
				删除人员
*/
public class HRManagementImpl implements HRManagementIF
{
	//数组定义（ 作为这个类的属性）
	private Human[] humans;
	private int idx = 0;
	
	public HRManagementImpl(){
		this(10);
	}
	public HRManagementImpl(int size){
		this.humans = new Human[size];
	}
	//比较好的做法，可以采用多态机制来完成，以不变应万变。
	public void save(Human h)throws HRManagementException{		
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
	public Human[] queryAll(){
		
		Human[] result = new Human[getSize()];
		System.arraycopy(this.humans,0,result,0,result.length);
		return result;
		
		//return humans;
	}
	//获取所有人员个数，0表示没有人员
	public int getSize(){
		return idx;
	}

	//删除人员
	public void remove(Human h)throws HRManagementException{

	}
	/*
	void remove(表明人员（Human）对象是唯一信息的）{
		
	}
	*/
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
		//1.查询参数这个对象的id，是否存在，存在就直接覆盖humans属性当前这个元素。
		if(h!=null){
			for(int i=0;i<this.idx;i++){
				Human hh = this.humans[i];
				if(h.getId().equals(hh.getId())){
					this.humans[i] = h;
					break;
				}
			}
		}else{
			System.out.println("## 您要修改的人员，并不存在## ");
		}
	}
	
	/*
	Human query(唯一信息能表明某个具体的Human){

	}
	*/
	//根据id查询某个人员
	public Human query(String id){
		for(int i=0;i<getSize();i++){
			Human h = this.humans[i];
			if(h.getId().equals(id)){
				return h;
			}
		}
		return null;
	}


	//控制台输出人员信息
	
	public void printHumans(Human... humans){

		if(humans!=null){
			//下面这段逻辑是“主动”循环具体对象（Human子类对象）相关信息。
			//才会导致很多类型强制转换。
			//如果化主动为被动，那么局面又不一样了。
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

	

	//参数编号是否存在，true存在，false不存在
	private boolean exists(String id){
		/*
		boolean exists = false;//假设不存在
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
	//下面这种针对每一个操作的类型（例如：Teacher，Student等）都提供一套维护方法
	//这样不好，原因，未来再出现一些类似Teacher，Student的类，那么还需要不停的定义新的方法。
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