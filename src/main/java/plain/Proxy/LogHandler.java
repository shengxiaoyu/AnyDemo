package plain.Proxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author 13314409603@163.com
 * @date 2019/3/28
 * @time 13:23
 * @Description
 */
public class LogHandler implements InvocationHandler {
    private Object target ;
    public LogHandler(Object target){
        this.target = target ;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("调用方法："+method.getName());
        return method.invoke(target,args);
    }
}
