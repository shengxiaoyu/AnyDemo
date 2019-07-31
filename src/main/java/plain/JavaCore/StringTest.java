package plain.JavaCore;

import java.util.Arrays;
import java.util.Collections;

/**
 * @author 13314
 * @date 2019/7/3
 * @time 11:50
 * @Description
 */
public class StringTest {
    public static void main(String[] args) {
//        String s = "123" ;
//        String s1 = "12"+"3" ;
//        String s2 = new String("123") ;
//        String s3 = "1234".substring(0,3) ;
//        String s4 = new Integer(123).toString() ;
//        String s5 = s2.toString() ;
//        String s6 = s+"" ;
//        String s7 = s.toString() ;
//        System.out.println(s==s1);
//        System.out.println(s1==s2);
//        System.out.println(s==s3);
//        System.out.println(s==s4);
//        System.out.println(s==s5);
//        System.out.println(s==s6);
//        System.out.println(s==s7);
//        StringBuilder sb1 = new StringBuilder() ;
//        StringBuffer sb2 = new StringBuffer() ;
//
    String s1 = new String("abc") ;
    String s = " " ;
        System.out.println(s.split(" ").length);
//        String s ="1"+"23"; //pool池里有1，23，没有123，堆上有123
//        s.intern() ;//jdk8，会在池里创建一个指向堆的引用，后续创建直接使用这个引用。
//                    //jdk7，会在池里创建一个123常量，后续使用这个常量
//        String s2 = "123" ;
//        System.out.println(s==s2);
    }
}
