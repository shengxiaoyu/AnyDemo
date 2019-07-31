package plain.concurrency.Callable_Future;

import java.util.concurrent.locks.LockSupport;

/**
 * @author 13314
 * @date 2019/7/17
 * @time 22:53
 * @Description
 */
public class ThreadTest {
    public static void main(String[] args) {
        ThreadLocal<String> threadLocal = new ThreadLocal<>() ;
        LockSupport.park();
    }
}
