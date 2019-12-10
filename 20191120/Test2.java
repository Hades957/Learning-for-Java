public class Test2{
	public static void main(String[] args){
		int a = 10;
		int b = 20;
		char ch = 'a';
		System.out.println(a);
		System.out.println(ch);
		System.out.println(b);


		System.out.println("11111");
		boolean flag = true;
		if(flag){
			System.out.println("22222");
		}else{
			System.out.println("33333");
		}
		System.out.println("44444");

		int age = 14;
		if(age>=1 && age<=5){
			System.out.println("学龄前儿童(1-5)");
		}
		else if(age>=6 && age<=11){
			System.out.println("小学生(6-11)");
		}
		else if(age>=12 && age<=14){
			System.out.println("青少年");
		}else{
			System.out.println("未知年龄");
		}

	}
}