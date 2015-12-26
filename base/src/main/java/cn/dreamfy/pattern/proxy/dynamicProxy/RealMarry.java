package cn.dreamfy.pattern.proxy.dynamicProxy;

public class RealMarry implements WeddingMarry {

    @Override
    public void marry() {
        System.out.println("you are 结婚了...");
    }
}
