package com.yunsi.thread01;

public class Test {

	public static void main(String[] args) {
		Printer p = new Printer();
		
		Object lock = new Object();
		
//		Student s = new Student("����ѧ��1������ĳ��ѧУ",p);	
//		Worker w = new Worker("I am a worker,from XXX company!",p);//Runnable����
//
//		//�����߳�
//		s.start();
//		new Thread(w).start();
		
		//��һ�θĽ�����Printer�е�doPrint���������û�м���synchronized���η�����Ҳû��ʹ��synchronized��ṹ
		//��Ҫ��Ҹ������������ͬ��Ч��������������޸���Student��Workder�еĵ���doPrint�߼���֮ǰ������synchronized��ṹ
		
		//�ڶ��θĽ�������Student��Worker���󲻴��ڣ���Ҫ���ʹ�������ڲ����������Student��Worker��2����ɫ�Ĵ��롣
		new Thread() {
			public void run() {
				//����ѧ����ɫ
				String doc = "����ѧ��";
				synchronized(lock) {
					p.doPrint(doc);
				}
			}
		}.start();
		new Thread() {
			public void run() {
				//�������˽�ɫ
				String doc =" I am a worker.";
				synchronized(lock) {
					p.doPrint(doc);
				}
			}
		}.start();
		
		//�����θĽ���������е�synchronized����ʹ�õĶ�����p��ʹ�������Ķ�������в��У�
		
		
		
	}
}
