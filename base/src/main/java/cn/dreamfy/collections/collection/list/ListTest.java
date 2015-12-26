package cn.dreamfy.collections.collection.list;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class ListTest {

    public static void main(String[] args) {

//        test1();

        test2();
    }

    private static void test2() {
        List<Integer> list = new ArrayList<>();
        list.add(5);
        list.add(2);
        list.add(1);
        list.add(9);
        list.add(0);

        System.out.println("原序列:");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
        System.out.println();

        /*根据步长进行循环*/
        Collections.rotate(list, -1);
        System.out.println("循环后:");
        for (Integer integer : list) {
            System.out.print(integer + " ");
        }
    }

    private static void test1() {
        Collection<String> collection1 = new ArrayList<>();//创建一个集合对象
        collection1.add("000");//添加对象到Collection集合中
        collection1.add("111");
        collection1.add("222");
        System.out.println("集合collection1的大小：" + collection1.size());// 3
        System.out.println("集合collection1的内容：" + collection1); // [000,111,222]
        collection1.remove("000");//从集合collection1中移除掉 "000" 这个对象
        System.out.println("集合collection1移除 000 后的内容：" + collection1);// [111, 222]
        System.out.println("集合collection1中是否包含000 ：" + collection1.contains("000"));// false
        System.out.println("集合collection1中是否包含111 ：" + collection1.contains("111"));//true


        Collection<String> collection2 = new ArrayList<>();
        collection2.addAll(collection1);//将collection1 集合中的元素全部都加到collection2中
        System.out.println("集合collection2的内容：" + collection2);// [111, 222]
        collection2.clear();//清空集合 collection1 中的元素
        System.out.println("集合collection2是否为空 ：" + collection2.isEmpty()); // true
        //将集合collection1转化为数组
        Object s[] = collection1.toArray();
        for (Object value : s) {
            System.out.println(value);// 111, 222
        }
    }
}
