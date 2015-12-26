package cn.dreamfy.collections.collection.list;

import java.util.Collections;
import java.util.LinkedList;

public class LinkedListTest {

    public static void main(String[] args) {
        LinkedList<String> linkedList = new LinkedList<>();
        linkedList.add("a");
        linkedList.add("b");
        linkedList.add("c");
        linkedList.add("d");
        linkedList.add("e");
        linkedList.add("f");

        for (String s : linkedList) {
            System.out.println(s);
        }

        System.out.println("第一个元素：" + linkedList.getFirst());
        System.out.println("最后一个元素：" + linkedList.getLast());

        String a = Collections.max(linkedList);
        System.out.println(a);
    }

}
