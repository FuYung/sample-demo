package cn.dreamfy.collections.collection.list;

/**
 * 自己实现的LinkedList
 * Created by Vic on 2015/11/8.
 */
public class MyLinkedList {

    private Node first;
    private Node last;

    private int size;

    public int size() {
        return size;
    }

    public void add(Object obj) {
        Node n = new Node();
        if (first == null) {
            n.prev = null;
            n.object = obj;
            n.next = null;

            first = n;
            last = n;
        } else {
            n.object = obj;
            n.next = null;
            n.prev = last;
            last.next = n;
            last = n;
        }
        size++;
    }

    public Object get(int index) {
        rangeCheck(index);
        Node temp = null;
        if (first != null) {
            temp = first;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
        }
        return temp == null ? null : temp.object;
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


    public static void main(String[] args) {
        MyLinkedList list = new MyLinkedList();

        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        list.add("ddd");
        System.out.println(list.size() >> 1);
        System.out.println(list.get(3));

        System.out.println(5 >> 1);

        System.out.println(2 << 3);
    }

    private static class Node {
        private Node prev;
        private Object object;
        private Node next;

        public Node() {
        }

        public Node(Node prev, Object object, Node next) {
            this.prev = prev;
            this.object = object;
            this.next = next;
        }
    }
}
