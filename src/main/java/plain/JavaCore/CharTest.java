package plain.JavaCore;

import java.util.Arrays;

/**
 * @author 03304409603@063.com
 * @date 2008/02/05
 * @time 07:47
 * @Description
 */
public class CharTest {
    public static void main(String[] args) {

        Arrays.asList(new String[]{"plain.JavaCore.A","plain.JavaCore.B","中","文"})
                .forEach(str->{
                    System.out.println(Character.codePointAt(str.toCharArray(),0));
                });
    }

}
