/*
	给定一个年份，一个月份，求这月有多少天
*/
public class Demo03{
	public static void main(String[] args){
		int year = 2005;
		int month = 2;
		boolean isRun = year%400==0||year%4==0&&year%100!=0;
		if(isRun&&month==2)
			System.out.println(year+"年"+month+"月有29天");
		else if(!isRun&&month==2)
			System.out.println(year+"年"+month+"月有28天");
		else if(month==4||month==6||month==9||month==11)
			System.out.println(year+"年"+month+"月有30天");
		else{
			System.out.println(year+"年"+month+"月有31天");
		}
	}
}