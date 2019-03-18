package concurrency;


import java.util.HashMap;
import java.util.Map;

/**
 * @author 13314409603@163.com
 * @date 2019/3/16
 * @time 11:09
 * @Description
 */
public class LazyInitialization {
    public static void main(String[] args) {
        new Resource() ;
    }
}
class Resource {
    private final Map<String,String> strMap ;
    final int i ;
    public Resource(){
        i = 1 ;
        strMap = new HashMap<>() ;

        System.out.println("init resource");
    }
}
//unsafe
class SafeLazyInitialization {
    private static Resource resource ;
    public synchronized static Resource getInstance(){
        if(resource==null){
            resource = new Resource() ;
        }
        return resource ;
    }
}
class SafeLazyInitialization2{
    private static Resource resource = new Resource() ;
    public static Resource getResource(){return resource ;}
}
//unsafe
class UnsafeLazyInitialization{
    private static Resource resource;
    public static Resource getInstance(){
        if(resource ==null){
            resource = new Resource() ; //unsafe published
        }
        return resource ;
    }
}
//unsafe
class DoubleCheckedLocking{
    private static Resource resource ; //����������volatile���ǰ�ȫ���ˣ�
    public static Resource getInstance(){
        if(resource == null){
            synchronized (DoubleCheckedLocking.class){
                if(resource==null){
                    resource = new Resource() ; //����ȫ����
                }
            }
        }
        return resource ;
    }
}