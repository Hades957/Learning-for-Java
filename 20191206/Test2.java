import java.io.File;
import java.io.FilenameFilter;

public class Test2{
	public static void main(String[] args){
		//遍历文件
	File f = new File("E:\\Software");
		//过滤文件
	String[] fileNames = f.list(new FilenameFilter(){
		public boolean accept(File dir,String filename){
			return filename.endsWith(".msi");
		}
	});
		//显示文件 
	for(String fileName:fileNames){
		System.out.println(fileName);
	}
	


		
		
	}
}