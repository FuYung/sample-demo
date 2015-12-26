package cn.dreamfy.pattern.proxy.staticProxy;

/**
 * 静态代理
 * 1、真实角色
 * 2、代理角色
 * 3、真实角色和代理角色实现同一个接口
 */
interface WeddingMarry {
    void marry();
}

public class StaticProxy implements WeddingMarry {
    private You you;

    public StaticProxy() {

    }

    public StaticProxy(You you) {
        this.you = you;
    }

    public void before() {
        System.out.println("婚礼布置...");
    }

    public void after() {
        System.out.println("闹洞房...");
    }

    @Override
    public void marry() {
        this.before();
        you.marry();
        this.after();
    }

    public You getYou() {
        return you;
    }

    public void setYou(You you) {
        this.you = you;
    }
}


class You implements WeddingMarry {

    @Override
    public void marry() {
        System.out.println("you are 结婚了...");
    }
}

class Test {
    public static void main(String[] args) {
        You you = new You();
        StaticProxy staticProxy = new StaticProxy(you);
        staticProxy.marry();
    }
}
