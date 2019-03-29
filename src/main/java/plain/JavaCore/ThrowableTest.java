package plain.JavaCore;

/**
 * @author 13314409603@163.com
 * @date 2019/1/15
 * @time 10:08
 * @Description
 */
public class ThrowableTest {

    public static void test() {
        try {
        }catch (Exception e){
            RuntimeException se = new RuntimeException("some wrong") ;
            se.initCause(e) ;
            throw se ;
        }
    }
}

