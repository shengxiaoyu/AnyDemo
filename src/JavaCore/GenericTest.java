package JavaCore;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

/**
 * @author 13314409603@163.com
 * @date 2019/1/16
 * @time 9:37
 * @Description
 * 泛型
 */
public class GenericTest <T extends Comparable&Serializable> {
    private T b ;
    public GenericTest(T ab) {
        b = ab ;
    }
    public T getB(){
        return b ;
    }
    public <T> T getMiddel(T...a){
        return a[a.length/2] ;
    }
    public static <T extends Comparable> T test(){
        return null ;
    }

    public static void act(List<? extends Employee> employees){
    }
    public static void act2(List<? super Manager> managers){}

    public static void main(String[] args) {
        GenericTest<Integer> genericTest = new GenericTest(2);
//        if(genericTest instanceof GenericTest<Integer>) //将会报编译错误
        if(genericTest instanceof GenericTest){

        }
        Double[] ints = new Double[3];
        ints[0]=1.1;
        ints[1]=1.2;
        ints[2]=1.3;
        Double middel =  genericTest.getMiddel(ints);
        Integer b = genericTest.getB();
        Pair<String>[] p = (Pair<String>[]) new Pair<?>[12];
        Class<GenericTest> genericTestClass = GenericTest.class;
        Class<GenericTest> genericTestClass1 = GenericTest.class;
        System.out.println(genericTestClass==genericTestClass1);
        Class<String> stringClass = String.class;
        System.out.println(genericTestClass.getClass()==stringClass.getClass());
        Pair<Employee> stringPair = Pair.makePair(Employee::new);
        List<? extends Employee> list = new ArrayList<>() ;
        list.add(null) ;
//        list.add(new Employee()) ;error
        Employee employee = list.get(0);
        List<? super Employee> list1 = new ArrayList<>() ;
        list1.add(new Employee()) ;
        list1.add(new Manager()) ;
//        list1.add(new Object()) ;error
        Object object = list1.get(0);
        GenericTest.act(new ArrayList<Employee>());
        GenericTest.act(new ArrayList<Manager>());
        GenericTest.act2(new ArrayList<Object>());
        GenericTest.act2(new ArrayList<Employee>());
        GenericTest.act2(new ArrayList<Manager>());
    }
}
    class Pair<T extends Comparable>{
        public Pair(T aFirst,T aSecond){
            first = aFirst ;
            second = aSecond ;
        }
        T first ;
        T second ;
        public static <T extends Comparable> Pair<T> makePair(Supplier<T> constr){
            return new Pair<>(constr.get(),constr.get()) ;
        }
        public static<T extends Comparable> Pair<T> makePair(Class<T> cl){
            try {
                return new Pair<>(cl.newInstance(),cl.newInstance()) ;
            } catch (Exception e) {
                return null ;
            }
        }
        public T getFirst() {
            return first;
        }

        public void setSecond(T second) {
            this.second = second;
        }
    }
    class DateInterval extends Pair<LocalDate>{
        public DateInterval(LocalDate aFirst,LocalDate aSecond){
            super(aFirst,aSecond);
        }
        @Override
        public void setSecond(LocalDate second){
            if(second.compareTo(getFirst())>=0){
                super.setSecond(second);
            }
        }
    }



