import java.io.File;

/**
 * 12.19
 * 安排5个线程，1个线程查找给定文件夹中的所有文件（子文件夹以及子子文件夹，递归查找）
 * 找到文件后，就安排另外4个线程进行压缩处理，压缩之后的文件，请放在一个固定的目录，
 * 请使用properties文件对这个目录进行配置。
 * 注意：
 * 1.例如文件c:/testdir/a.txt 压缩之后变成a.txt.zip，然后放入配置的目录中d:/aaa/a.txt.zip
 * 但是随着查找，文件c:/testdir/abc/a.txt 压缩之后也变成a.txt.zip放入配置的目录就冲突了，自己考虑解决
 * 2.查找给定的文件夹，也在配置文件配置
 */
public class Test {
    public static void main(String[] args) {
        // 1个线程查找给定文件夹中的所有文件
        FindFiles ff = new FindFiles();
        //ff.findFile();
        //ff.start();


        Compress comp1 = new Compress();
        //Compress comp2 = new Compress();

        comp1.start();
        //comp2.start();


        // 另外4个线程进行压缩处理
    }
}
