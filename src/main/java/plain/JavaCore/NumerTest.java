package plain.JavaCore;

import java.math.BigDecimal;
import java.lang.Math ;

/**
 * @author 13314
 * @date 2019/7/4
 * @time 9:29
 * @Description
 */
public class NumerTest {
    public static void main(String[] args) {
//        Integer i1 = 1 ;
//        Integer i2 = new Integer(1) ;
//        int i = 1 ;
//        System.out.println(i1==i);
//        System.out.println(i1==i2);
//        System.out.println(i==i2);
//        System.out.println(Integer.SIZE);
//        AtomicInteger integer = new AtomicInteger() ;
//        double d = 100/3.0 ;
//        System.out.printf("%.3f",d);
        BigDecimal bigDecimal = new BigDecimal(3.456) ;
        System.out.println(bigDecimal.setScale(1,BigDecimal.ROUND_HALF_EVEN));
        System.out.println(bigDecimal.setScale(1,BigDecimal.ROUND_HALF_DOWN));
        System.out.println(bigDecimal.setScale(1,BigDecimal.ROUND_HALF_UP));
        double d = 3.456 ;
        //只保留整数
        //四舍五入
        System.out.println(Math.round(d));
        //向上取
        System.out.println(Math.ceil(d));
        //向下取
        System.out.println(Math.floor(d));
    }
}
