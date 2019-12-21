package com.yunsi.thread03;

import java.util.ArrayList;
import java.util.List;

/**
 * ���ӣ�ר���������õ���
 * @author Administrator
 *
 */
public class Table {

	private List<String> cakeList = new ArrayList<String>();
	
	//�ŵ���
	public synchronized void putCake(String cake) {
		//1.�ȼ��������û�п�λ�����û�о͵ȴ�����ͣ��
		while(cakeList.size()>=10) {
			//�ȴ�������
			try {
				System.out.println(Thread.currentThread().getName()+" �����������ˣ���ʱ���ܷ��õ��⣡,������Ϣ����������");
				this.wait();				
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		//2.�ŵ���
		cakeList.add(cake);
		
		//***��ʦһ�����뵰�⣬�Ϳ��Ե���Ϣ���н�����Ϣȥ�е��ˣ������ǹ˿���
		this.notifyAll();
		System.out.println(Thread.currentThread().getName()+" ���� "+cake);
		
	}
	
	//ȡ����
	public synchronized String getCake() {
		//1.���������û�е��⣬û�о͵ȴ�����ͣ��
		while(cakeList.size()<=0) {
			//�ȴ�������
			try {
				System.out.println(Thread.currentThread().getName()+" �������ӿ��ˣ�û�е��⣩�����Եȴ�������������");
				this.wait();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		String cake = cakeList.remove(0);
		System.out.println(Thread.currentThread().getName()+" ��ȡ "+cake);
		//2.ȡ����
		
		//***һ��Ҫ֪ͨ��this��Ϣ����Ϣ���ˣ����Ӳ����������ٳ�ʦ���Է��õ�����
		//this.notify();//�Ƽ����ʹ��notifyAll()
		this.notifyAll();
		return cake;
	}
	
	
}
