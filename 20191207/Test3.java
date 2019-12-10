/*
	����һ��Ŀ¼��������������Ӹ����
*/
import java.io.File;

public class Test3{
	public static void main(String[] args){
		File dir = new File("D:\\abc\\aaa");
		if(dir.isDirectory()){
			showAll(dir, 0);
		}else{
			System.out.println("·�����󣡣�");
		}
	}
 
	public static void showAll(File dir, int level){
		System.out.println(getSpace(level) + dir.getName());
		level++; //ÿ����һ�Σ�level��1
		File[] files = dir.listFiles(); //��ȡָ��Ŀ¼�µ�ǰ�������ļ��л����ļ�����
		for (int i = 0; i < files.length; i++) { //ѭ������
			if (files[i].isDirectory()) { //�����Ŀ¼����������listAll����
				showAll(files[i], level);
			} else { //����ֱ������ļ���
				System.out.println(getSpace(level) + files[i].getName());
			}
		}
	}

	//���ǰ��ĸ�ʽ
	private static String getSpace(int level) { 
		StringBuilder sb = new StringBuilder();
		sb.append("|--");
		for (int i = 0; i < level; i++) {
			sb.insert(0, "| ");
		}
		return sb.toString();
	}
}