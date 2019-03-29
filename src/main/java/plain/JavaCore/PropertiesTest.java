package plain.JavaCore;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * @author 13314409603@163.com
 * @date 2019/2/1
 * @time 12:46
 * @Description
 */
public class PropertiesTest {
    public static void main(String[] args) {
        Properties properties = new Properties() ;
        properties.setProperty("width","200") ;
        properties.setProperty("title","properties title") ;
        String property = System.getProperty("user.home");
        try {
            //存储 在项目根目录下
            FileOutputStream outputStream = new FileOutputStream("plain/data/program.properties");
            properties.store(outputStream,"Program Properties");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            //读取
            FileInputStream inputStream = new FileInputStream("plain/data/program.properties");
            properties.load(inputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
