package plain.JavaCore.ProxyTest;

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
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");//保存生成的代理类class
        HelloService helloService = new HelloServiceImpl() ;
        InvocationHandler ih = new MyInvocationHandler(helloService) ;
        HelloService o = (HelloService) Proxy.newProxyInstance(ProxyTest.class.getClassLoader(), new Class[]{HelloService.class}, ih);
        o.hello();
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
        Object val = method.invoke(target,args) ;
        System.out.println("method invoke end");
        return val ;
    }
}
