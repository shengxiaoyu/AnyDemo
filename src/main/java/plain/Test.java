package plain;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author 13314409603@163.com
 * @date 2018/11/26
 * @time 20:41
 * @Description
 */
public class Test {

    public StaticNestTest staticNestTest(){
        return new StaticNestTest() ;
    }
    public NestTest nestTest(){
        return new NestTest() ;
    }
    private static class StaticNestTest{
        int vlaue = 0 ;
        void creament(){
            this.vlaue++ ;
        }
    }
    private class NestTest{
        int value = 0 ;
        void creament(){
            this.value++ ;
        }
    }

    public static void main(String[] args) {
        int i1 = 128 ;
        Integer i2 = Integer.valueOf(i1) ;
        Integer i3 = 128 ;
        Integer i4 = new Integer(128) ;
        System.out.println(i2==i3);
        System.out.println(i2==i4);
//        System.out.println(romanToInt("III"));
    }
    public static int romanToInt(String s) {
        Map<Character,Integer> map= new HashMap<>() ;
//        new ConcurrentHashMap<>()
        map.put('M',1000) ;
        map.put('D',500) ;
        map.put('C',100) ;
        map.put('L',50) ;
        map.put('X',10) ;
        map.put('V',5) ;
        map.put('I',1) ;
        char[] array = s.toCharArray() ;
        int result = 0 ;
        for(int i=0;i<array.length;i++){
            if(i+1<array.length&&map.get(array[i])<map.get(array[i+1])){
                result = result - map.get(array[i])+map.get(array[i+1]) ;
                i++ ;
            }else{
                result = result + map.get(array[i]) ;
            }
        }
        return result ;
    }
}
