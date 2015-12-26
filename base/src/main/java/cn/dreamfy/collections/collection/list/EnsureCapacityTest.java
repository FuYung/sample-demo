package cn.dreamfy.collections.collection.list;

import java.util.ArrayList;

/**
 * 调用ensureCapacity()方法和不调用的区别
 *  eg：
 *  当N=1000000时，
 *      没用调用ensureCapacity()方法耗时22ms
 *      调用ensureCapacity()方法耗时16ms
 *  当N=100000000时，
 *      没用调用ensureCapacity()方法耗时980ms
 *      调用ensureCapacity()方法耗时3676ms
 *
 */
public class EnsureCapacityTest {

    public static void main(String[] args) {

        final int N = 100000000;
        Object obj = new Object();

        /** 没用调用ensureCapacity()方法初始化ArrayList对象 */
        ArrayList<Object> list = new ArrayList<>();
        long startTime = System.currentTimeMillis();
        for (int i = 0; i <= N; i++) {
            list.add(obj);
        }

        System.out.println("list.size()=" + list.size());
        long endTime = System.currentTimeMillis();
        System.out.println("没有调用ensureCapacity()方法所用时间："
                + (endTime - startTime) + "ms");

        /** 调用ensureCapacity()方法初始化ArrayList对象 */
        list = new ArrayList<>();
        startTime = System.currentTimeMillis();
        // 预先设置list的大小
        list.ensureCapacity(N);
        for (int i = 0; i <= N; i++) {
            list.add(obj);
        }
        endTime = System.currentTimeMillis();
        System.out.println("list.size()=" + list.size());
        System.out.println("调用ensureCapacity()方法所用时间：" + (endTime - startTime)
                + "ms");
    }
}
