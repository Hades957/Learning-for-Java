public class Test5{
	public static void main(String[] args){
		boolean tea = false;
		boolean water = false;

		String strResult = tea?(water?"�в���ˮ":"�в�ûˮ"):(water?"û����ˮ":"û��ûˮ");
		System.out.println(strResult);
	}
}