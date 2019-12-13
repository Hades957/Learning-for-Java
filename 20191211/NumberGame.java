
import java.io.*;
public class NumberGame{
	public static void main(String[] args) throws IOException{
		int num = (int)(Math.random()*100);
		System.out.println(num);
		int count = 0;
		while(true){
			System.out.println("请输入[0,100]之间的数：");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			int n = Integer.parseInt(line);
			count++;
			if(n==num){
				System.out.println("恭喜你，猜对啦！这个数就是："+num);
				System.out.println("你一共猜了"+count+"次");
				break;
			}
			else if(n>num){
				System.out.println("猜大了");
			}
			else{
				System.out.println("猜小了");
			}
		}
	}
}