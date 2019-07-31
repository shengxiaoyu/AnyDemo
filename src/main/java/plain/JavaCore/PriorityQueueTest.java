package plain.JavaCore;

import java.util.PriorityQueue;

/**
 * @author 13314
 * @date 2019/7/4
 * @time 14:19
 * @Description
 */
public class PriorityQueueTest {
    public static void main(String[] args) {
        PriorityQueue<Integer> queue = new PriorityQueue<>() ;
        queue.peek() ;
//        queue.offer() ;
        queue.poll() ;
    }
}
