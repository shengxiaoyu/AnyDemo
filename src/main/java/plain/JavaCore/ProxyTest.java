package plain.JavaCore;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @author 13314409603@163.com
 * @date 2019/1/14
 * @time 20:54
 * @Description
 */
public class ProxyTest {
    public static void main(String[] args) {
        Object o = Proxy.newProxyInstance(null, new Class[]{Comparable.class}, new MyInvocationHandler(2));
        System.out.println(((Comparable) o).compareTo(2));
    }
}
class MyInvocationHandler implements InvocationHandler{
    private Object target ;
    public MyInvocationHandler(Object object){
        this.target = object ;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(method.getName());
        return method.invoke(target,args) ;
    }
}
