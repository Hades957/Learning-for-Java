import java.io.File;
import java.io.FilenameFilter;

public class Test2{
	public static void main(String[] args){
		//�����ļ�
	File f = new File("E:\\Software");
		//�����ļ�
	String[] fileNames = f.list(new FilenameFilter(){
		public boolean accept(File dir,String filename){
			return filename.endsWith(".msi");
		}
	});
		//��ʾ�ļ� 
	for(String fileName:fileNames){
		System.out.println(fileName);
	}
	


		
		
	}
}