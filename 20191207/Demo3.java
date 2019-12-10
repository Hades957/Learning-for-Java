
import java.io.File;

public class Demo3{
	public static void main(String[] args){
		File dir = new File("D:\\abc");
		showAllFiles(dir,0);
	}
	public static void showAllFiles(File dir, int level){
		System.out.println(getSpace(level++)+dir.getName());		
		File[] files = dir.listFiles();
		for(int i=0;i<files.length;i++){
			if(files[i].isDirectory()){
				showAllFiles(files[i],level);
			}else{
				System.out.println(getSpace(level)+files[i].getName());
			}
		}
	}
	public static String getSpace(int level){
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for(int i=0;i<level;i++){
			sb.insert(0,"| ");
		}
		return sb.toString();
	}
}