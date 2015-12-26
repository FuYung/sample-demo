package cn.dreamfy.collections.collection.queue;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * 自定义堆栈(LIFO)
 * 1、弹
 * 2、压
 * 3、获取头
 * Created by Vic on 2015/11/27.
 */
public class MyStack<E> {

    private Deque<E> container = new ArrayDeque<>();
    private int cap;

    public MyStack(int cap) {
        this.cap = cap;
    }


    public boolean push(E e) {
        return container.size() + 1 <= cap && container.offer(e);
    }

    public E pop() {
        return container.pollLast();
    }

    public E peek() {
        return container.peekLast();
    }

    public int size() {
        return container.size();
    }
}
