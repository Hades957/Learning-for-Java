public class Test5{
	public static void main(String[] args){
		boolean tea = false;
		boolean water = false;

		String strResult = tea?(water?"有茶有水":"有茶没水"):(water?"没茶有水":"没茶没水");
		System.out.println(strResult);
	}
}