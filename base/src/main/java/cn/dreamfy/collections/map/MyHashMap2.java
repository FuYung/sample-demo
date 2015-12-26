package cn.dreamfy.collections.map;

import java.util.LinkedList;

/**
 * 自己实现的HashMap，（数组+链表）
 * Created by Vic on 2015/11/13.
 */
public class MyHashMap2 {

    LinkedList[] arr = new LinkedList[9];

    int size;

    public void put(Object key, Object value) {
        MyEntry entry = new MyEntry(key, value);

        int hash = key.hashCode();
        hash = hash < 0 ? -hash : hash;

        int a = hash % arr.length;

        if (arr[a] == null) { // 如何list中没有找到索引为a的值
            LinkedList<MyEntry> list = new LinkedList<>();
            list.add(entry);
            arr[a] = list;

            size++;
        } else {
            LinkedList list = arr[a];
            for (Object aList : list) {
                MyEntry e = (MyEntry) aList;
                if (e.key == key) {
                    e.value = value; //键值重复直接覆盖
                    return;
                }
            }
            arr[a].add(entry);
        }
    }

    public Object get(Object key) {
        int a = key.hashCode() % arr.length;
        if (arr[a] != null) {
            LinkedList list = arr[a];
            for (Object aList : list) {
                MyEntry e = (MyEntry) aList;
                if (e.key.equals(key)) {
                    return e.value;
                }
            }
        }

        return null;
    }

    public static void main(String[] args) {
        MyHashMap2 map = new MyHashMap2();

        map.put("111", "aaa");
        map.put("222", "bbb");
        map.put("22231", "ccc");
        map.put("555", "ddd");

//        System.out.println(map.size);

        System.out.println(map.get("222"));

    }
}
