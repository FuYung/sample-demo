package cn.dreamfy.pattern.singleton;

/**
 * 懒汉模式
 * 1、构造器私有化
 * 2、声明私有的静态属性
 * 3、对外提供访问该对象的静态方法
 */
public class Singleton {

    private static Singleton singleton = null;

    private Singleton() {
    }

    public static Singleton getInstance() {
        // double checking(双层检查)
        if (singleton == null) { // 提高效率
            synchronized (Singleton.class) {
                if (singleton == null) {
                    singleton = new Singleton();
                }
            }
        }
        return singleton;
    }
}

/**
 * 饿汉模式
 * 1、构造器私有化
 * 2、声明私有的静态属性并创建该类的实例
 * 3、对外提供访问该对象的静态方法
 */
class Singleton2 {

    private static Singleton2 singleton = new Singleton2();

    private Singleton2() {
    }

    public static Singleton2 getInstance() {
        return singleton;
    }

}

/**
 * 饿汉模式
 * 类在使用的时候才进行加载，通过内部类来解决性能问题
 * 只有使用到SingletonHolder之后才创建该实例
 */
class Singleton3 {

    private static class SingletonHolder {
        private static Singleton3 singleton = new Singleton3();
    }

    private Singleton3() {
    }

    public static Singleton3 getInstance() {
        return SingletonHolder.singleton;
    }
}
