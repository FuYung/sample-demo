package cn.dreamfy.collections.collection.list;

import java.util.Arrays;

/**
 * 自己实现的ArrayList
 * Created by Vic on 2015/11/7.
 */
public class MyArrayList2 {

    private Object[] elementData;

    private int size;

    public MyArrayList2(){
        this(10);
    }

   public MyArrayList2(int x){
       if(x<0){
           try {
               throw new Exception() ;
           } catch (Exception e) {
               e.printStackTrace();
           }
       }
       elementData = new Object[x];
   }

    public int size(){
      return  size;
    }


    public void add(Object o) {

        elementData[size] = o;
        size = size + 1;

    }

    public Object get(int index){
     return   elementData[index];
    }

    @Override
    public String toString() {
        return "MyArrayList2{" +
                "elementData=" + Arrays.toString(elementData) +
                ", size=" + size +
                '}';
    }

    public static void main(String[] args) {
        MyArrayList2 m = new MyArrayList2(3);
        m.add("1");
        m.add("2");
        m.add(3);
        m.add(4);
        m.add(5);
        System.out.println(m.toString());

        System.out.println(m.get(3));
    }

}
