package plain.concurrency;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @author 13314
 * @date 2019/7/4
 * @time 12:09
 * @Description
 */
public class ReetrantLockTest {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock(true) ;
        reentrantLock.lock();
    }
}
