package cn.dreamfy.collections.map;

/**
 * 自定义的HashMap
 * Created by Vic on 2015/11/12.
 */
public class MyHashMap {

    public MyEntry[] arr = new MyEntry[999];
    public int size;

    public void put(Object key, Object value) {
        MyEntry entry = new MyEntry(key, value);

        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                entry.value = value;
                return;
            }
        }
        arr[size++] = entry;
    }

    public Object get(Object key) {
        for (int i = 0; i < size; i++) {
            if (arr[i].key.equals(key)) {
                return arr[i].value;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        MyHashMap map = new MyHashMap();
        map.put("111", "bbb");
        map.put("222", "bbb");
        map.put("333", "bbb");
        map.put("444", "bbb");

        System.out.println(map.size);
        System.out.println(map.get("222"));
    }


}

class MyEntry {
    Object key;
    Object value;

    public MyEntry() {
    }

    public MyEntry(Object key, Object value) {
        this.key = key;
        this.value = value;
    }
}
