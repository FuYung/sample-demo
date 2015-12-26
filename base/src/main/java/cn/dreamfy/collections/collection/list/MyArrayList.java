package cn.dreamfy.collections.collection.list;

import java.util.Arrays;

/**
 * 自己实现的ArrayList
 * Created by Vic on 2015/11/7.
 */
public class MyArrayList {

    private Object[] elementData;

    private int size;

    public MyArrayList() {
        this(10);
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity < 0) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        elementData = new Object[initialCapacity];
    }

    public int size() {
        return size;
    }

    public void add(Object obj) {
        ensureCapacity();

        elementData[size++] = obj;
    }

    private void ensureCapacity() {
        if (size == elementData.length) {
            Object[] newArray = new Object[size * 2 + 1];
            System.arraycopy(elementData, 0, newArray, 0, elementData.length);
            elementData = newArray;
        }
    }

    public Object remove(int index) {
        rangeCheck(index);

        Object oldValue = elementData[index];
        int numMoved = size - index - 1;
        if (numMoved > 0) {// 非最后一个元素，需要更新删除后的索引
            System.arraycopy(elementData, index + 1, elementData, index, numMoved);
        }
        elementData[--size] = null;
        return oldValue;
    }

    public void remove(Object obj) {
        for (int i = 0; i < size; i++) {
            Object o = elementData[i];
            if (o.equals(obj)) {
                remove(i);
            }
        }
    }

    public void set(int index, Object obj) {
        rangeCheck(index);

        Object oldValue = elementData[index];
        elementData[index] = obj;
    }

    public void add(int index, Object obj) {
        ensureCapacity();
        System.arraycopy(elementData, index, elementData, index + 1,
                size - index);
        elementData[index] = obj;
        size++;
    }

    public Object get(int index) {
        rangeCheck(index);
        return elementData[index];
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= size) {
            try {
                throw new Exception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public String toString() {
        return "MyArrayList{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {

        MyArrayList list = new MyArrayList(4);
        list.add("123");
        list.add("1233");
        list.add("12345");
        list.add("12356");
        list.add("12323");
        list.add("1231");

        System.out.println(list.get(3));
        System.out.println(list);
    }

}
