
/**
	Object中的finalize方法，对现象被销毁之前，对象的finalize会被调用，我们可以通过finalize
这个方法，对其进行一些处理
	
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