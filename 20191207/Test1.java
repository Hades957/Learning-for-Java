//�ڲ�����ʹ��mkdirs���������ǰ���£��������mkdirs�Ĺ���


import java.io.File;
public class Test1{
	public static void main(String[] args){
		//��Ҫ������·��
		String dir = "D:\\a\\b\\c\\d\\e";
		//ʹ��split��·���ָ�
		String[] directories = dir.split("\\\\");
		//��Ŀ¼
		File root = new File(directories[0]);
		for(int i=1;i<directories.length;i++){
			//ʹ��File�Ĺ��췽��File(File file,String pathname)����File����
			File directory = new File(root,directories[i]);
			directory.mkdir();
			root = directory;
		}
		System.out.println(dir+"Ŀ¼�����ɹ�");
	}
}