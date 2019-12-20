package zbifeng1219;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 1个线程查找给定文件夹中的所有文件（子文件夹以及子子文件夹，递归查找），
 * @author Bifeng
 *
 */
public class FindFile extends Thread{
	
	private void findfile() throws Exception{
		String path = "E:\\program\\java\\Learning-for-Java";
		File file = new File(path);
		ArrayList<File> files = findAllFile(file);
		
		
	}
	
	@Override
	public void run(){
		try {
			this.findfile();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static ArrayList<File> findAllFile(File file) {
		File[] arr = file.listFiles();
		ArrayList<File> result = new ArrayList();
		for(File f : arr) {
			if(f.isFile()) {
				result.add(f);
			}else {
				findAllFile(f);
			}
		}
		Iterator it = result.iterator();
		while(it.hasNext()) {
			System.out.println(it.next());
		}
		return result;
	}
}
