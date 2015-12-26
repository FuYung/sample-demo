package cn.dreamfy.collections.collection.set;

import java.util.HashMap;

/**
 * 自己实现的set集合
 * Created by Vic on 2015/11/13.
 */
public class MyHashSet {

    HashMap<Object, Object> map;
    private static final Object PRESENT = new Object();

    public MyHashSet() {
        map = new HashMap<>();
    }

    public int size() {
        return map.size();
    }

    public void add(Object o) {
        map.put(o, PRESENT);// set集合的不可重复就是利用的map集合的key不可重复
    }

    public static void main(String[] args) {
        MyHashSet set = new MyHashSet();
        set.add("aaa");
        set.add(new String("aaa"));
        System.out.println(set.size());

    }
}
