package concurrency.Wait_Notify;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * @author 13314409603@163.com
 * @date 2019/3/27
 * @time 21:38
 * @Description
 */
public class Test {
    public static void main(String[] args) {
        int size = 10 ;
        Queue<Integer> queue = new ArrayDeque<>(size) ;
        Thread customer = new Thread(new Customer(queue,size)) ;
        Thread producer = new Thread(new Producer(queue,size)) ;
        producer.start();
        customer.start();
    }
}
