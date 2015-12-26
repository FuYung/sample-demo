package cn.dreamfy.collections.collection.queue;

/**
 * 测试自定义堆栈
 * Created by Vic on 2015/11/27.
 */
public class MyStackDemo {

    public static void main(String[] args) {
        MyStack<String> backHistory = new MyStack<>(3);
        backHistory.push("A");
        backHistory.push("B");
        backHistory.push("C");
        backHistory.push("D");
        backHistory.push("E");

        System.out.println(backHistory.size());
        String item;
        while (null != (item = backHistory.pop())) {
            System.out.println(item);
        }

    }
}
