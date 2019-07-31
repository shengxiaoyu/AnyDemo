package plain.JavaCore;

/**
 * @author 13314
 * @date 2019/7/11
 * @time 14:04
 * @Description
 */
public class StaticTest {
    public static int i = getI() ;
    int ii = 3 ;
    static {
        i =2 ;
        System.out.println("In superClass1:"+SubTest.j);
    }
    static int getI(){
        System.out.println("In superClass2:"+SubTest.j);
        return 1 ;
    }

    public static void main(String[] args) {
//        new SubTest() ;
        System.out.println("第一次实例化子类:");
        new sub();
        System.out.println("第二次实例化子类：");
        new sub();

    }
}
class SubTest extends StaticTest{
    public final static int j = getJ() ;
    static int getJ(){
        System.out.println("In subclass1:"+StaticTest.i);
        return 1 ;
    }

    static {
//        j = 2 ;
        System.out.println("In subclass2:"+StaticTest.i);
    }

}

class Super{
    static {
        System.out.println("父类中的静态块");
    }
    {
        System.out.println("父类中的非静态块");
    }
    Super(){
        System.out.println("父类中的构造方法");
    }
    public static void main(String[] args) {
//        new SubTest() ;
        System.out.println("第一次实例化子类:");
        new sub();
        System.out.println("第二次实例化子类：");
        new sub();

    }
}

class sub extends Super{
    static {
        System.out.println("子类中的静态块");
    }
    {
        System.out.println("子类中的非静态块");
    }
    sub(){
        System.out.println("子类中的构造方法");
    }
    sub(int i){
        System.out.println(i);
    }
}