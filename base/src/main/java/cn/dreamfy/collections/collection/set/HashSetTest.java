package cn.dreamfy.collections.collection.set;

import java.util.HashSet;
import java.util.Set;

public class HashSetTest {

    public static void main(String[] args) {
        Set<Object> set = new HashSet<>();

        set.add("aaa");
        set.add("bbb");
        set.add(new String("aaa"));

        System.out.println(set.size());

    }
}
