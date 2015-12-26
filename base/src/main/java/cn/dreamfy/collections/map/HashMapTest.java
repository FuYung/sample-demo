package cn.dreamfy.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * 打印在数组中出现n/2以上的元素（n为数组的长度）
 * 利用一个HashMap来存放数组元素及出现的次数
 */
public class HashMapTest {

    public static void main(String[] args) {

        int[] a = {2, 3, 2, 2, 1, 4, 2, 2, 2, 7, 9, 6, 2, 2, 3, 1, 0};

        Map<Integer, Integer> map = new HashMap<>();
        for (int anA : a) {
            // 循环去判断数组中每个元素出现的次数，保存到map集合中，key为元素，value为元素出现次数
            if (map.containsKey(anA)) {
                int tmp = map.get(anA);
                tmp += 1;
                map.put(anA, tmp);
            } else {
                map.put(anA, 1);
            }
        }
        Set<Integer> set = map.keySet();
        for (Integer s : set) {
            if (map.get(s) >= a.length / 2) {
                System.out.println(s);
            }
        }
    }
}
