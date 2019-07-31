package plain.JavaCore;

import java.time.LocalDate;
import java.util.*;
import java.util.function.ToIntFunction;

/**
 * @author 13314409603@163.com
 * @date 2019/1/18
 * @time 9:08
 * @Description
 */
public class CollectionTest {

    public static void main(String[] args) {
//        viewTest();
        int i = 3 ;
        System.out.println(i<<2);
        System.out.println(i&2);
    }
    public static void queueTest(){
        List<Integer> list = new ArrayList() ;
        Iterator iterator = ((ArrayList) list).iterator();

        ArrayList<Integer> l = new ArrayList<>() ;
        list.sort(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return 0;

            }
        });
        String  s1 = "das" ;
//        Iterator iterator2 = list.iterator();
        list.add(1) ;
        list.add(2) ;
        list.add(3) ;
        ArrayList<ArrayList<Integer>> result = new ArrayList<>() ;
        result.sort(Comparator.comparingInt((ToIntFunction<ArrayList>) ArrayList::size));
        while (iterator.hasNext()){
            System.out.println(iterator.next());
//            iterator2.remove();
        }
    }
    public static void priorityQueueTest(){
        PriorityQueue<LocalDate> pq = new PriorityQueue<>();
        pq.add(LocalDate.of(1906,12,9)) ;
        pq.add(LocalDate.of(1815,12,10)) ;
        pq.add(LocalDate.of(1903,12,9)) ;
        pq.add(LocalDate.of(1910,6,22)) ;
        for (LocalDate localDate : pq) {
            System.out.println(localDate);
        }
        while (!pq.isEmpty()) {
            System.out.println(pq.remove());
        }
    }
    public static void mapTest(){
        LinkedHashMap<String, Integer> linkMap = new LinkedHashMap<>();
        HashMap<String, Integer> map = new HashMap<>();
        map.put("c",3) ;
        map.put("b",2) ;
        map.put("a",1) ;
        map.forEach((k,v)-> System.out.println(k+"  "+v));


        System.out.println("**************");
        linkMap.put("b",2) ;
        linkMap.put("c",3) ;
        linkMap.put("a",1) ;
        linkMap.forEach((k,v)-> System.out.println(k+"  "+v));
    }

    public static void viewTest(){
        HashMap<String, Integer> map = new HashMap<>();
        map.put("c",3) ;
        map.put("b",2) ;
        map.put("a",1) ;
        Set<String> strings = map.keySet();

        map.put("d",4) ;
        System.out.println(strings.size());
        SortedSet<Object> objects = new TreeSet<>();
        TreeMap<Object, Object> objectObjectTreeMap = new TreeMap<>();

        String[] array = new String[]{"a","b","e","d","c","g"} ;
        List<String> strings1 = Arrays.asList(array);
        Iterator<String> iterator = strings1.iterator();
        iterator.next() ;
        List<String> a = Collections.nCopies(100, "a");
        Set<String> a1 = Collections.singleton("a");

        List<String> strings2 = Collections.unmodifiableList(strings1);

//        strings1.sort(Comparator.reverseOrder()) ;
//        System.out.println(Arrays.toString(strings1.toArray()));
//        strings1.sort(Comparator.comparingInt(e->{
//            return e.charAt(0) - 'a' ;
//        }));
//        System.out.println(Arrays.toString(strings1.toArray()));
//        strings1.sort(Comparator.naturalOrder());
//        System.out.println(Arrays.toString(strings1.toArray()));
        strings1.sort(Comparator.reverseOrder());
        System.out.println(Arrays.toString(strings1.toArray()));
        int c = Collections.binarySearch(strings1, "c",Comparator.naturalOrder());//必须先升序排列，比较器只是用来比较，并不会先执行一遍list.sort(comparator)
        System.out.println(Arrays.toString(strings1.toArray()));
        int f = Collections.binarySearch(strings1, "f");
        System.out.println(c+"    "+f);
        ((Collection)strings1).toArray(new String[0]) ;

        BitSet b =new BitSet(10) ;
        b.set(2);
        for(int i=0;i<10;i++){
            System.out.println(b.get(i));
        }
    }
}
