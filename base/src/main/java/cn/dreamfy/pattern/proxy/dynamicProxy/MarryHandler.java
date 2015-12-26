package cn.dreamfy.pattern.proxy.dynamicProxy;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * jdk动态代理
 */
public class MarryHandler implements InvocationHandler {

    WeddingMarry realMarry;

    public MarryHandler(WeddingMarry realMarry) {
        this.realMarry = realMarry;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        Object object = null;

        System.out.println("调用真正的方法之前--->布置婚房");
        if ("marry".equals(method.getName())) {
            object = method.invoke(realMarry, args);
        }
        System.out.println("调用真正的方法之前--->闹洞房");
        return object;
    }

}
