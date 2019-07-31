package plain.JavaCore;

import java.util.*;
import java.util.concurrent.*;

/**
 * @author 13314
 * @date 2019/7/11
 * @time 15:03
 * @Description
 */
public class CollectionsTest {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<Integer>();
//        arrayList.add(1);
//        arrayList.add(2);
//        arrayList.add(3);
//        arrayList.add(4);
//        arrayList.add(5);
//        arrayList.add(6);
//        arrayList.add(7);
//        arrayList.add(8);
//        System.out.println("原始数组:"+arrayList);
//        Collections.rotate(arrayList,-2) ;
//        System.out.println(arrayList);z
        List<String> a = new ArrayList<>() ;
        a.add("1") ;
        a.add("2") ;
        for(String item:a){
            if("2".equals(item)){
                a.remove(item) ;
            }
        }
        ArrayList var1 = new ArrayList();
        var1.add("1");
        var1.add("2");
        Iterator var2 = var1.iterator();

        while(var2.hasNext()) {
            String var3 = (String)var2.next();
            if ("1".equals(var3)) {
                var1.remove(var3);
            }
        }
//        ArrayBlockingQueue
//        BlockingDeque
        //        System.out.println(a.size());
//        Arrays.copyOf()
    }
}
