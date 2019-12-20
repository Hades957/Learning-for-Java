package com.yunsi.thread2;

public class Test {

	public static void sleep(int seconds) {
		long start = System.currentTimeMillis();
		while((System.currentTimeMillis())-start<1000*seconds);
	}
	
	public static void main(String[] args) {
		//2���̣߳�һ��main�̣߳�һ����main���������߳�
		//���߳�ִ����ϴ�Լ��Ҫ20�룬main�߳���10�������ң�֪ͨ���߳�ֹͣ��ʹ�õļ��ɾ����ж����������
		//Thread������start������ʵҲ��stop������stop����ԭ��Ӧ��ʹֹͣ����˼��ֻ����������������ˣ��в���ȫ������
		//��ô���Ǿ�Ҫ�뷨������;ֹͣһ���̣߳����ʹ��interrupt�����������������
		
		//�������߳�
		Thread tt = new Thread() {
			public void run() {
				for(char c = 'A';c<='Z';c++) {
					System.out.println(c+" �ж�״̬��"+this.isInterrupted());
					if(this.isInterrupted()) {
						break;
					}
					Test.sleep(1);
				}
			}
		};
		tt.start();
		
		System.out.println("main�߳���Ϣ10�롣��������");
		sleep(10);
		
		System.out.println("main�߳���Ϣ���ˣ�������֮ǰ�Ǹ����߳��ж�״̬���жϡ�");
		tt.interrupt();
	}
}
