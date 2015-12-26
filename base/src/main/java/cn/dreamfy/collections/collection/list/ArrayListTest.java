package cn.dreamfy.collections.collection.list;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ArrayListTest {
    public static void main(String[] args) {

        /** 新建一个ArrayList */
        ArrayList<String> list = new ArrayList<>();
        System.out.println("初始化大小:" + list.size());

        /** 添加元素 */
        list.add("zzz");
        list.add("egg");
        list.add("hell");
        list.add("child");
        System.out.println("当前容量:" + list.size());

        /** 将ArrayList的大小和实际所含元素的大小设置一致 */
        list.trimToSize();

        /** 遍历 */
        for (String string : list) {
            System.out.println(string);
        }

        /** 在指定位置插入元素 */
        list.add(2, "zhu");

        for (String string : list) {
            System.out.println(string);
        }

        System.out.println("--------------");

        /** 清空list */
        list.clear();

        /** 遍历 */
        for (String string : list) {
            System.out.println(string);
        }
        System.out.println("--------------");


        System.out.println("===================");
        List list3 = new ArrayList();
        list3.add(new Date());

        
        System.out.println("===="+list3);

        System.out.println(new Date());
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        list3.remove(new Date());
        System.out.println(new Date());

        Date d = new Date();
        Date d2 = new Date();
        System.out.println(d == d2);
    }

}
