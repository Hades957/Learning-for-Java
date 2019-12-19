import java.io.*;
import java.util.Properties;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

/**
 * 找到文件后，就安排另外4个线程进行压缩处理，压缩之后的文件，请放在一个固定的目录
 */

public class Compress extends Thread {
    private static Properties prop = new Properties();

    /**
     * @param fileSrc    源文件地址
     * @param destFolder 目的地地址(含文件名)eg: "e:/abc/a.txt.zip"
     */
    private void zip(String fileSrc, String destFolder) throws IOException {
        //定义要压缩的文件
        File file = new File(fileSrc);
        //定义压缩文件名称
        File zipFile = new File(destFolder);
        //定义文件的输入流
        InputStream input = new FileInputStream(file);
        //声明压缩流对象
        ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(zipFile));

        //设置ZipEntry对象
        zipOut.putNextEntry(new ZipEntry(file.getName()));
        //设置注释
        //zipOut.setComment("zbifeng");
        int temp = 0;
        while ((temp = input.read()) != -1) {
            zipOut.write(temp);
        }
        input.close();
        zipOut.close();

    }

    /**
     * 读取配置文件
     *
     * @param key
     * @return
     */
    private static String loadProperties(String key) {
        InputStream in = null;
        try {
            in = new FileInputStream("config1.properties");
            prop.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
        String value = prop.getProperty(key);
        return value;
    }

    @Override
    public void run() {
        String destdir = loadProperties("destdir");

        System.out.println(destdir);
        System.out.println("压缩完成"); // 输出信息
    }
}
