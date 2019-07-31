package plain.JavaCore;

/**
 * @author 13314409603@163.com
 * @date 2019/1/4
 * @time 15:20
 * @Description
 */
public interface InterfaceTest {
    default String getName2()
    {
        return "interface" ;
    }
    static int getName(){
        int x = 1 ;
        try {
            x = 2 ;
            return x ;
        }finally {
            x = 3 ;
        }
    }

    public static void main(String[] args) {
        System.out.println(InterfaceTest.getName());
    }
}