/*
	给定一个目录，把里面的所有子给输出
*/
import java.io.File;

public class Test3{
	public static void main(String[] args){
		File dir = new File("D:\\abc\\aaa");
		if(dir.isDirectory()){
			showAll(dir, 0);
		}else{
			System.out.println("路径有误！！");
		}
	}
 
	public static void showAll(File dir, int level){
		System.out.println(getSpace(level) + dir.getName());
		level++; //每调用一次，level加1
		File[] files = dir.listFiles(); //获取指定目录下当前的所有文件夹或者文件对象
		for (int i = 0; i < files.length; i++) { //循环遍历
			if (files[i].isDirectory()) { //如果是目录，继续调用listAll函数
				showAll(files[i], level);
			} else { //否则，直接输出文件名
				System.out.println(getSpace(level) + files[i].getName());
			}
		}
	}

	//输出前面的格式
	private static String getSpace(int level) { 
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for (int i = 0; i < level; i++) {
			sb.insert(0, "| ");
		}
		return sb.toString();
	}
}