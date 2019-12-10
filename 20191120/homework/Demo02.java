/*
	给定3个int类型值（彼此互不相同），例如 int a=3 b=4 c=5,通过分支判断，找出最大的数，第二大的数，以及最小的数
*/
public class Demo02{
	public static void main(String[] args){
		int a = 8;
		int b = 6;
		int c = 10;
		int max = a>b?(a>c?a:c):(b>c?b:c);
		int min = a<b?(a<c?a:c):(b<c?b:c);
		int mid = a==max?(b==min?c:b):(b==min?a:b);
		System.out.println("最大的数是："+max);	
		System.out.println("第二大的数是："+mid);	
		System.out.println("最小的数是："+min);	
	}
}