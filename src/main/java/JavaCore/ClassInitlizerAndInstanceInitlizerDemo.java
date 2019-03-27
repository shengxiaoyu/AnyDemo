package JavaCore;

/**
 * @author 13314409603@163.com
 * @date 2018/12/15
 * @time 10:20
 * @Description
 */
public class ClassInitlizerAndInstanceInitlizerDemo {
    public static void main(String[] args) {
        A aA = new A() ;
    }
}

class B implements C{
    int super_b = 900 ;
    public B(){
        System.out.println(super_b);
        System.out.println(((A)this).a);
    }
}
interface C {
    int c = 500 ;
    int d =100 ,f = C.test() ;
    static int test(){
        System.out.println("interface static method");
        return 600 ;
    } ;
    default void test2(){
        System.out.println("dasd");
    }
}
class A extends B {
    public int a =100 ;
    public A(){
        super();
        System.out.println(a);
        System.out.println(a);
        a = 200 ;
    }
}