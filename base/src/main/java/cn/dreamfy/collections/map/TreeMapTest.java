package cn.dreamfy.collections.map;

import java.util.*;

/**
 * Created by Vic on 2015/12/21.
 */
public class TreeMapTest {

    public static void main(String[] args) {
        Map<String, String> treeMap = new TreeMap<>();

        treeMap.put("1", "2");
        treeMap.put("2", "2");
        treeMap.put("6", "2");
        treeMap.put("3", "2");
        treeMap.put("9", "2");
        treeMap.put("4", "2");
        treeMap.put("5", "2");

        // 自带升序功能
        for (Map.Entry<String, String> entry : treeMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }

        System.out.println("===============");

        Map<String, String> map = new LinkedHashMap<>();
        map.put("1", "2");
        map.put("2", "2");
        map.put("6", "2");
        map.put("3", "2");
        map.put("3", "3");
        map.put("9", "2");
        map.put("4", "2");
        map.put("5", "2");

        for (String key : map.keySet()) {
            System.out.println(key + "===" + map.get(key));
        }

    }
}
