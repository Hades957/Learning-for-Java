import java.util.*;

public class Test4{
	public static void main(String[] args){
		Scanner cin = new Scanner(System.in);
		int num = cin.nextInt();
		switch(num/10){
			case 8:
			case 9:
			case 10:System.out.println("优秀");break;
			case 7:System.out.println("良好");break;
			case 6:System.out.println("还行");break;
			default:System.out.println("不及格");break;
		}
	}
}