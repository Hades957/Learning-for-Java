
/**
	Object�е�finalize����������������֮ǰ�������finalize�ᱻ���ã����ǿ���ͨ��finalize
����������������һЩ����
	
*/

public class Test{
	public static void main(String[] args){
		Object obj = new Object(){
			public void finalize(){
				System.out.println("finalize,finalize...");
			}
		};
		obj.toString();
		obj=null;
		
		System.gc();
			
	}
}