package plain.JavaCore;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.locks.ReentrantLock;


/**
 * @author 13314409603@163.com
 * @date 2019/3/15
 * @time 12:58
 * @Description
 */
public class someTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList() ;
        ArrayList<Integer> arrayList2 = new ArrayList(3) ;
        arrayList.add(1) ;
        arrayList.subList(1,2) ;
        Iterator<Integer> iterator = arrayList.iterator();
        iterator.remove();
//        LinkedList linkedList = new LinkedList() ;
        HashMap<String,String> map = new HashMap<>(6) ;
//        HashSet<String> set = new HashSet<>() ;
//        LinkedHashMap<String,Integer> lhm = new LinkedHashMap();
//        lhm.put("1",1) ;
//        AtomicInteger integer = new AtomicInteger(1) ;
        map.put("asd","asd") ;
        String s = "asd" ;
        ConcurrentHashMap cjm = new ConcurrentHashMap() ;
        ReentrantLock lock = new ReentrantLock() ;
        lock.lock();
        try{
            System.out.println("synchronized");
        }finally {
            lock.unlock();
        }
//        integer.incrementAndGet()

//            lhm.get()
        CopyOnWriteArrayList<Integer> list = new CopyOnWriteArrayList<>() ;
        list.add(1);
        }
}
