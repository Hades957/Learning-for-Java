/*
	����һ���ļ�/�ļ���
	ɾ���ļ�/�ļ���
	��ȡ�ļ�/�ļ���
	�ж��ļ�/�ļ����Ƿ����
	���ļ��н��б���
	��ȡ�ļ��Ĵ�С	
	
	File����һ����ϵͳ�޹ص��࣬�κεĲ���ϵͳ������ʹ��
������еķ���


*/

import java.io.File;
public class FileDemo{
	public static void main(String[] args){
		//test1(); // File�еľ�̬����
		//test2("c:","a.txt"); // File�еĹ��췽��	
		test3();//File�еĳ��÷���
		
	}
	/*
	

	*/
	static void test3(){
		
	}



	static void test2(String parent,String child){
		/*	���췽����Ҫ�������
		1. public File(String pathname)
		ͨ����������·�����ַ���ת��Ϊ����·�����������µ�Fileʵ���� ����������ַ����ǿ��ַ����������ǿյĳ���·������ 
			���� pathname - ·�����ַ��� 
			�쳣 NullPointerException - ��� pathname������ null */
		//·���������ļ���β��Ҳ�������ļ��н�β�����������·����Ҳ�����Ǿ���·�������Դ��ڣ�Ҳ���Բ����ڣ�
		//����File����ֻ�ǽ��ַ���·����װ��File���󣬲�����·����������
		File f1 = new File("..\\20191207\\hello.txt");
		System.out.println(f1);//��ӡ�ľ������洫�ݸ�f1��·��������File����д��toString()����
		File f2 = new File("C:\\program files");//���ļ��н�β��ͬ������
		System.out.println(f2);

		/*2.public File(String parent,String child)
		�Ӹ�·�����ַ�������·�����ַ��������µ�Fileʵ���� 
		���parent��null�򴴽��µ�Fileʵ���������ڸ�����child·�����ַ����ϵ��õ�����File���캯��һ�������򣬽�ʹ��parent·�����ַ�������ʾĿ¼������child·�����ַ������ڱ�ʾĿ¼���ļ��� ���child·�����ַ����Ǿ��Եģ���ô������ϵͳ��صķ�ʽת��Ϊ���·������ ���parent�ǿ��ַ�������ͨ����childת��Ϊ����·����������ϵͳ��ص�Ĭ��Ŀ¼��������������µ�Fileʵ���� ����ÿ��·�����ַ�����ת��Ϊ����·�����������ӳ���·��������Ը�������н����� 
		���� parent - ��·�����ַ��� child - ��·�����ַ���
			��·���ֳ��������֣�������� 
		�쳣 NullPointerException - ��� child�� null */
		//String parent = null;
		File f4 = new File(parent,"hello.txt");
		System.out.println("f4:"+f4);
		System.out.println("parent�ǿ��ַ���:"+new File("","program\\hello.txt"));
		
		System.out.println(new File(parent,child));
		
		/*3. public File(File parent,String child)
		�Ӹ�����·��������·�����ַ��������µ�Fileʵ���� 
		���parent��null�򴴽��µ�Fileʵ���������ڸ�����child·�����ַ����ϵ��õ�����File���캯��һ�������򣬲���parent����·��������ʾĿ¼������child·�����ַ������ڱ�ʾĿ¼���ļ��� ���child·�����ַ����Ǿ��Եģ���ô������ϵͳ��صķ�ʽת��Ϊ���·������ ���parent�ǿյĳ���·��������ô�µ�Fileʵ����ͨ����childת��Ϊ����·����������ϵͳ��ص�Ĭ��Ŀ¼��������������ġ� ����ÿ��·�����ַ�����ת��Ϊ����·�����������ӳ���·��������Ը�������н����� 
		���� parent - ������·���� child - ��·�����ַ��� 
		�쳣 NullPointerException - ��� child�� null */
		// ��Ϊparent��File���ͣ����ǿ��Զ�������һЩ�������ٴ���һ��File����
		File p = new File("c:");
		File file = new File(p,"Hello.java");
		System.out.println("(File parent,String child)"+file);
		
	}
	static void test1(){
		String pathSeparator = File.pathSeparator;
		System.out.println(pathSeparator);	//·���ָ���	
		char pathSeparatorChar = File.pathSeparatorChar;
		System.out.println(pathSeparatorChar);
		System.out.println(File.separator); //��ϵͳ��ص�Ĭ�����Ʒָ���
		System.out.println(File.separatorChar);
	}
} 