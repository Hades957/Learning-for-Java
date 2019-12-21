package com.yunsi.test01;
/**
 * ���߳�����3������������InterruptedException	
 * 	1.sleep()
 * 	2.wait()
 * 	3.join()
 * @author Administrator
 *
 */
public class TestJoin {

	public static void main(String[] args) {
		//���ӣ�3���̣߳�main������һ��main������2�����̣߳�һ����Ϊa��һ����Ϊb����
		//a�̼߳���1-50���ۼӺͣ���b�̼߳���51-100���ۼӺͣ���󽻸�main�̺߳ϲ�a����b2����ɵ��ۼӽ����������1-100���ۼӺͣ�������ʾ��
		final int[] sums = new int[2];
		Thread a = new Thread() {
			public void run() {
				int sum = 0;
				for(int i=1;i<=50;i++) {
					sum+=i;
				}
				sums[0]=sum;
				System.out.println("a�̼߳���1-50���ۼӺͽ��ʱ��"+sum);
			};
		};
		a.start();
		
		Thread b = new Thread() {
			public void run() {
				int sum = 0;
				for(int i=51;i<=100;i++) {
					sum+=i;
				}
				sums[1] = sum;
				System.out.println("b�̼߳���51-100���ۼӺͽ��ʱ��"+sum);
			};
		};
		b.start();


		//Ҫע��main�߳�һ��Ҫ��a��b�߳�ִ��֮����ִ��������߼����ܼ������ȷ�Ľ����������
		//��ôҪ��a��bִ������ִ�У��ͱ���main�ȴ�a��bִ����ϡ�
		
		try {
			a.join();//ִ����仰���̵߳ȴ�����join�������߳�ִ�����֮��ִ����仰���߳��ٴ�ִ�С�
			b.join();
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//main�߳��ܽᷢ��
		//???+XXXX
		int result = sums[0]+sums[1];
		System.out.println("main��a,b�̼߳���Ľ���ϲ�֮���ǣ�"+result);
	}
}
