/*
	����һ����ݣ�һ���·ݣ��������ж�����
*/
public class Demo03{
	public static void main(String[] args){
		int year = 2005;
		int month = 2;
		boolean isRun = year%400==0||year%4==0&&year%100!=0;
		if(isRun&&month==2)
			System.out.println(year+"��"+month+"����29��");
		else if(!isRun&&month==2)
			System.out.println(year+"��"+month+"����28��");
		else if(month==4||month==6||month==9||month==11)
			System.out.println(year+"��"+month+"����30��");
		else{
			System.out.println(year+"��"+month+"����31��");
		}
	}
}