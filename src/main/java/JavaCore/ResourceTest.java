package JavaCore;

import java.io.InputStream;
import java.util.Scanner;

/**
 * @author 13314409603@163.com
 * @date 2019/2/1
 * @time 12:15
 * @Description
 */
public class ResourceTest {
    public static void main(String[] args) {
        //以/开头的路径，以src目录为根目录
        InputStream resourceAsStream = ResourceTest.class.getResourceAsStream("/data/test.txt");
        //相对于ResourceTest类文件所在的目录
        InputStream resourceAsStream2 = ResourceTest.class.getResourceAsStream("data/test.txt");
        Scanner scanner = new Scanner(resourceAsStream);
        String s = scanner.nextLine();
        System.out.println(s);
    }
}
