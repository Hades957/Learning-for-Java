public class Test4{
	public static void main(String[] args){
		int myAge = 38;
		int yourAge = 22;
		boolean result = myAge > yourAge;
		System.out.println(myAge+"大于"+yourAge+"?"+result);

		result = myAge < yourAge;
		System.out.println(myAge+"小于"+yourAge+"?"+result);
		
		result = myAge >= yourAge;
		System.out.println(myAge+"大于等于"+yourAge+"?"+result);

		result = myAge <= yourAge;
		System.out.println(myAge+"小于等于"+yourAge+"?"+result);

		result = myAge == yourAge;
		System.out.println(myAge+"等于"+yourAge+"?"+result);		

		result = myAge != yourAge;
		System.out.println(myAge+"不等于"+yourAge+"?"+result);
	
	}
}