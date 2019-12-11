public class Practise{
	public static void main(String[] args){
		convert();
	}

	//1.实现字符串和字符数组之间的相互转换。
	public static void convert(){
		//1.字符串转换成字节数组
		String str = "abcd1234";
		char[] chars = str.toCharArray();
		int len = chars.length;
		//2.字符数组转换成字符串
		//1)String(char[] value)  
		//2)String(char[] value, int offset, int count) 
		//3)static String valueOf(char[] data)  
		//4)static String valueOf(char[] data, int offset, int count) 
		//5)static String copyValueOf(char[] data)
		//6)static String copyValueOf(char[] data, int offset, int count) 相当于 valueOf(char[], int, int) 。
		String str1 = new String(chars);
		String str2 = new String(chars,0,len);
		String str3 = String.valueOf(chars);
		String str4 = String.valueOf(chars,0,len);
		String str5 = String.copyValueOf(chars);	
		String str6 = String.copyValueOf(chars,0,len);
		
	}
}