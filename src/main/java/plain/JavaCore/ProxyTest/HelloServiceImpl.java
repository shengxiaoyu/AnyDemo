package plain.JavaCore.ProxyTest;

/**
 * @author 13314
 * @date 2019/7/30
 * @time 15:57
 * @Description
 */
public class HelloServiceImpl implements HelloService {
    @Override
    public void hello() {
        System.out.println("Hello Wrold!");

    }

}
