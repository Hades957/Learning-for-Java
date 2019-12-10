public class Test1{
	public static void main(String[] args){
		int a = 10;
		int b = 20;
		System.out.println(a);
		a=a+b;
		System.out.println(a);
		a-=b;
		System.out.println(a);
		a*=b;
		System.out.println(a);
		a/=b;
		System.out.println(a);
		
		byte c = 1;	
		byte d = 2;
		c+=d;
		System.out.println(c);

		d+=b;
		System.out.println(d);
		System.out.println((int)'A');

		int e = 1;
		e = e++ + ++e - --e + e--;
		System.out.println(e);
	}
}