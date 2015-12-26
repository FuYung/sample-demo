package cn.dreamfy.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

public class MapTest {

    public static void main(String[] args) {

        /** 初始化map */
        Map<String, Integer> map = new HashMap<>();
        System.out.println("HashMap的初始值:" + map.size());
        System.out.println("HashMap是否为空:" + (map.isEmpty() ? "是" : "否"));

        /** 向map中添加元素 */
        map.put("apple", 1);
        map.put("orange", 2);
        map.put("egg", 3);
        System.out.println(map.size());
        System.out.println("HashMap是否为空:" + (map.isEmpty() ? "是" : "否"));

        Set<String> set = map.keySet();
        for (String s : set) {
            System.out.println(s + " " + map.get(s) + " " + "hashCode:"
                    + s.hashCode());
        }
            
        /** 检测是否含有某个Key */
        System.out.println(map.containsKey("egg"));

        /** 检测是否含有某个Value */
        System.out.println(map.containsValue(2));

        /** 打印hashCode */
        System.out.println(map.hashCode());
    }
}
