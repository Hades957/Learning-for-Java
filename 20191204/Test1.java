import java.io.FileReader;
import java.io.IOException;
public class Test1{
	public static void main(String[] args){
		//test1();
		test2();
	}
	public static void test1(){
		boolean b = false;
		System.out.println(String.valueOf(b));
	}
	
	public static void test2(){
		try(FileReader fr = new FileReader("Test1.java")){
			int count = 0;
			int data = -1;
			while((data = fr.read()) != -1){
				System.out.print((char)data);
				count++;
			}
			System.out.println();
			System.out.println(count);
		}catch(IOException e){
			System.out.println("¥¶¿ÌIO“Ï≥£");
		}
	}
}