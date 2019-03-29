package plain.Proxy;

import java.lang.reflect.Proxy;

/**
 * @author 13314409603@163.com
 * @date 2019/3/28
 * @time 13:18
 * @Description
 */
public class ProxyTest {
    public static void main(String[] args) {
        Hello hello = new HelloWorld() ;
        LogHandler handler = new LogHandler(hello) ;
        Hello proxyInstance = (Hello) Proxy.newProxyInstance(null, new Class[]{Hello.class}, handler);
        proxyInstance.sayHello();
    }

}
