package concurrency.Wait_Notify;

import java.util.Queue;

/**
 * @author 13314409603@163.com
 * @date 2019/3/27
 * @time 21:33
 * @Description
 */
public class Customer implements Runnable {
    private Queue events ;
    private int size ;
    public Customer(Queue events,int size){
        this.events = events ;
        this.size = size ;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                customer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    private void customer() throws InterruptedException {
        synchronized (this.events){
            while (this.events.isEmpty()){
                System.out.println("队列为空，消费者进入等待");
                this.events.wait();
            }
            int i = (int) this.events.remove();
            System.out.println("处理事件："+i);
            this.events.notifyAll();
        }
    }
}
