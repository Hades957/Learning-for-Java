import java.io.File;

public class Demo01{
	public static void main(String[] args){
		String path = "f:\\a\\b\\c\\d";
		boolean b = myMkdirs(path);
		System.out.println(b);
	}
	/*
		使用递归实现不使用mkdirs而实现mkdirs的功能
	*/
	public static boolean myMkdirs(String path){
		if(path!=null){
			File d = new File(path);
			myMkdirs(d.getParent());
			d.mkdir();
			if(new File(path).exists()){
				return true;
		}
		}
		
		return false;	

		
	}
}