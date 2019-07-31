package plain.JavaCore;

/**
 * @author 13314
 * @date 2019/7/30
 * @time 14:55
 * @Description
 */
public class AutoBox {
    public static void main(String[] args) {
        Integer i1 = 120 ;
        Integer i2 = 200 ;

        Boolean b1 = true ;
        Boolean b2 = true ;
        Boolean b3 = new Boolean(true) ;

        int i3 = 200 ;
        Integer i4 = 320 ;
        System.out.println(i4==i1+i2);
        System.out.println(i2==i3);
        System.out.println(i3==i2);
    }
}
