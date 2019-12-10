import java.io.File;
import java.util.Date;

public class Test1{
	public static void main(String[] args){
		File f = new File("E:\\program\\java\\20191206\\Test1.java");
		String pf = f.getParent();
		File ppf = f.getParentFile();
		while(f!=null){
			System.out.println(f);
			f = f.getParentFile();
			
		}
		f = new File("E:\\Software");
		long d = f.lastModified();
		Date
		System.out.println(d);
		//System.out.println("\nlist(Filename)
	}
}