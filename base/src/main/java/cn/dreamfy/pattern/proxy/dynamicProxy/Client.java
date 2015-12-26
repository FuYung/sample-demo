package cn.dreamfy.pattern.proxy.dynamicProxy;

import java.lang.reflect.Proxy;

/**
 * JDK动态代理
 */
public class Client {

    public static void main(String[] args) {
        WeddingMarry realMarry = new RealMarry();

        MarryHandler handler = new MarryHandler(realMarry);

        WeddingMarry proxy = (WeddingMarry) Proxy.newProxyInstance(ClassLoader
                .getSystemClassLoader(), new
                Class[]{WeddingMarry.class}, handler);

        proxy.marry();
    }
}
