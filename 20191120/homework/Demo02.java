/*
	����3��int����ֵ���˴˻�����ͬ�������� int a=3 b=4 c=5,ͨ����֧�жϣ��ҳ����������ڶ���������Լ���С����
*/
public class Demo02{
	public static void main(String[] args){
		int a = 8;
		int b = 6;
		int c = 10;
		int max = a>b?(a>c?a:c):(b>c?b:c);
		int min = a<b?(a<c?a:c):(b<c?b:c);
		int mid = a==max?(b==min?c:b):(b==min?a:b);
		System.out.println("�������ǣ�"+max);	
		System.out.println("�ڶ�������ǣ�"+mid);	
		System.out.println("��С�����ǣ�"+min);	
	}
}