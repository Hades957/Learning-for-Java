package com.yunsi.test01;

/**
 * ��ʾ����
 * @author Administrator
 *
 */
public class TestDeadLock {

	public static void main(String[] args) {
		//һ���Ƚ����������ӣ��������⣨�ܺ���ʾ��������
		Object fork = new Object();//����
		Object knife = new Object();//��
		
		new Thread() {
			public void run() {
				//�ȳ��е�����Ҫ�ٴγ��в���
				synchronized(knife) {
					try {
						Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("�ȳ����˵�����Ҫ�ٳ��в��ӡ�������");
					synchronized(fork) {
						System.out.println("���е���ͬʱ�����˲��ӣ�����");
					}
				}
			};
		}.start();
		
		

		new Thread() {
			public void run() {
				//�ȳ��в��ӣ���Ҫ�ٴγ��е�
				synchronized(fork) {
					System.out.println("�ȳ����˲��ӣ���Ҫ�ٳ��е���������");
					synchronized(knife) {
						System.out.println("���в��ӣ�ͬʱ�����˵�������");
					}
				}
			};
		}.start();
	}
}
