//在不允许使用mkdirs这个方法的前提下，完成类似mkdirs的功能


import java.io.File;
public class Test1{
	public static void main(String[] args){
		//需要创建的路径
		String dir = "D:\\a\\b\\c\\d\\e";
		//使用split将路径分割
		String[] directories = dir.split("\\\\");
		//根目录
		File root = new File(directories[0]);
		for(int i=1;i<directories.length;i++){
			//使用File的构造方法File(File file,String pathname)创建File对象
			File directory = new File(root,directories[i]);
			directory.mkdir();
			root = directory;
		}
		System.out.println(dir+"目录创建成功");
	}
}