/*
	给定一个浮点数例如：float f = 3.345f 需要对它进行小数点后两位四舍五入
*/
public class Demo01{
	public static void main(String[] args){
		float f = 3.395f;
		int num1 = (int)(f*1000);
		int num2 = (int)(f*100);
		int end = (num1%10);
		if(end>=5){
			num2+=1;
		}
		float num3 = (float)num2/100;
		if(num3*100%10==0)
			System.out.println((float)num2/100+"0");
		else
			System.out.println((float)num2/100);
	}
}