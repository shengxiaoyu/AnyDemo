package plain.concurrency.Wait_Notify;

import java.util.Queue;

/**
 * @author 13314409603@163.com
 * @date 2019/3/27
 * @time 21:14
 * @Description
 */
public class Producer implements Runnable{
    private Queue events ;
    private int size ;
    public Producer(Queue events,int size){
        this.events = events ;
        this.size = size ;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            try {
                produce(i);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private void produce(int i) throws InterruptedException {
        synchronized (this.events){
            //判断消息队列是否已经满了，如果满了则阻塞
            while (this.events.size()==this.size){
                System.out.println("队列已满，生产者进入等待");
                this.events.wait();
            }
            this.events.add(i) ;
            this.events.notifyAll();
        }
    }
}
