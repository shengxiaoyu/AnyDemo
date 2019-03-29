package plain.JavaCore;

/**
 * @author 13314409603@163.com
 * @date 2019/1/14
 * @time 19:55
 * @Description
 */
public class OuterClass {
    private OuterClass(){
    }
    private int a ;
    private static int c ;
    public void print(){
        InnerClass innerClass = new InnerClass();
        innerClass.print() ;
        Employee employee = new Employee("test"){

        } ;
    }

    private static class InnerClass{
        public final static int b = 1 ;
        public void print(){
            System.out.println(c);
        }
    }
}
