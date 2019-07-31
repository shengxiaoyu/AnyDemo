package plain.JavaCore;

/**
 * @author 13314
 * @date 2019/7/19
 * @time 11:47
 * @Description
 */
public class BooleanTest {
    public static void main(String[] args) {
        Boolean b1 = true ;
        Boolean b2 = true ;
        Boolean b3 = new Boolean(true) ;
        System.out.println(b1==b2);
        System.out.println(b1==b3);
    }
}
