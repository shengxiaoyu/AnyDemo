package concurrency;

import java.util.concurrent.*;

/**
 * @author 13314409603@163.com
 * @date 2019/3/23
 * @time 12:08
 * @Description
 */
public class ThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,5,0, TimeUnit.SECONDS,
                new SynchronousQueue<>()) ;
    }
}
