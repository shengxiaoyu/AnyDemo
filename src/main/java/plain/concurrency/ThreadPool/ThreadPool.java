package plain.concurrency.ThreadPool;

import plain.concurrency.Callable_Future.MatchCounter;

import java.io.File;
import java.util.Vector;
import java.util.concurrent.*;

/**
 * @author 13314409603@163.com
 * @date 2019/3/23
 * @time 12:08
 * @Description
 */
public class ThreadPool {
    public static void main(String[] args) {
        //无限线程池
        ThreadPoolExecutor executorService = (ThreadPoolExecutor) Executors.newCachedThreadPool();
        //指定数目的线程池
        ExecutorService executorService1 = Executors.newFixedThreadPool(5);
//        //单一线程池
//        ExecutorService executorService2 = Executors.newSingleThreadExecutor();
        Future<Integer> task = executorService.submit(new MatchCounter(
                new File("C:\\Users\\13314\\Desktop\\Bi-LSTM+CRF\\labeled"), "结婚"));
        try {
            Integer integer = task.get();
//            Integer.SIZE
            System.out.println("共："+integer+"个");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        System.out.println("线程个数："+executorService.getPoolSize());
        executorService.shutdown();
//        ThreadPoolExecutor tpe = new ThreadPoolExecutor(2,5,0, TimeUnit.SECONDS,
//                new SynchronousQueue<>()) ;
    }
}
