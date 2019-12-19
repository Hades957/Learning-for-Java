import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Properties;

/**
 * 1个线程查找给定文件夹中的所有文件（子文件夹以及子子文件夹，递归查找）
 */

public class FindFiles extends Thread {
    private Properties prop = new Properties();

    public ArrayList<File> filelists = new ArrayList<>();

    public void findFile() {
        //读取配置文件，确定目标文件夹
        InputStream in = null;
        try {
            in = new FileInputStream("config1.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String path = prop.getProperty("finddir");
        //System.out.println(path);
        File file = new File(path);
        findAllFiles(file);

    }

    public void findAllFiles(File f) {
        File[] files = f.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                filelists.add(file);
            } else {
                findAllFiles(file);
            }
        }
    }

    public void showList() {
        for (File filelist : filelists) {
            System.out.println(filelist);
        }
    }

    @Override
    public void run() {
        findFile();
        showList();
    }
}
