package plain.concurrency.Callable_Future;


import com.sun.xml.internal.ws.util.CompletedFuture;

import java.util.concurrent.Callable;
import java.util.concurrent.CompletableFuture;

/**
 * @author 13314409603@163.com
 * @date 2019/3/29
 * @time 15:24
 * @Description
 */
public class CompletableFutureTest{
    public static void main(String[] args) {
        CompletableFuture future = CompletableFuture.supplyAsync(CompletableFutureTest::call) ;
        future.whenComplete((v,e)->{
            System.out.println(v);
            System.out.println(e);
        }) ;
        System.out.println("后续任务。。");
        try {
            Thread.sleep(200);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public static Integer call() {
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("任务完成！");
        return 10000;
    }
}
