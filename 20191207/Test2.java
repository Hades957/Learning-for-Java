

import java.io.File;
import java.io.FileFilter;
public class Test2{
	public static void main(String[] args){
		File dir = new File("D:\\abc");
		File[] files = dir.listFiles(new FileFilter(){
			public boolean accept(File dir){
				return dir.getName().startsWith("abc");
			};
		});

	
		for(File f: files){
			f.delete();
		}
	}
} 