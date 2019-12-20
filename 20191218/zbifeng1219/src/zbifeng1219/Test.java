package zbifeng1219;
/**
 * 12.19
 *	安排5个线程，1个线程查找给定文件夹中的所有文件（子文件夹以及子子文件夹，递归查找），
 *	找到文件以后，就安排给另外4个线程进行压缩处理，压缩之后的文件，请放在一个固定的目录，请使用
 *	properties文件对这个目录进行配置。
 *	注意：
 *		1.例如文件c:/testdir/a.txt 压缩之后变成a.txt.zip,然后放入配置的目录：d:/aaa/a.txt.zip
 *		但是随着查找文件:c:/testdir/abc/a.txt 压缩之后也变成a.txt.zip 放入配置的目录就冲突了，自己考虑解决它。
 *
 *		2.查找给定的文件夹，也在配置文件配置。
 * @author Bifeng
 *
 */
public class Test {
	public static void main(String[] args) {
		//1个线程查找给定文件夹中的所有文件
		FindFile ff = new FindFile();
		
		//4个线程进行压缩处理
		//Compress comp1 = new Compress();
		//Compress comp2 = new Compress();
		//ompress comp3 = new Compress();
		//Compress comp4 = new Compress();
		
		ff.start();
		//comp1.start();
		//comp2.start();
		//comp3.start();
		//comp4.start();
		
	}
}
