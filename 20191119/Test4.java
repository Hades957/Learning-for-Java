public class Test4{
	public static void main(String[] args){
		int myAge = 38;
		int yourAge = 22;
		boolean result = myAge > yourAge;
		System.out.println(myAge+"����"+yourAge+"?"+result);

		result = myAge < yourAge;
		System.out.println(myAge+"С��"+yourAge+"?"+result);
		
		result = myAge >= yourAge;
		System.out.println(myAge+"���ڵ���"+yourAge+"?"+result);

		result = myAge <= yourAge;
		System.out.println(myAge+"С�ڵ���"+yourAge+"?"+result);

		result = myAge == yourAge;
		System.out.println(myAge+"����"+yourAge+"?"+result);		

		result = myAge != yourAge;
		System.out.println(myAge+"������"+yourAge+"?"+result);
	
	}
}