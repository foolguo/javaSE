package com.welcom.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/19 11:21
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
      DoubleLinkedList1<Integer> list=new DoubleLinkedList1<>();
      list.add(1);
      list.add(2);
      list.add(3);
        System.out.println(list.get(0));
        list.remove(0);
        System.out.println(list.get(0));

    }
}
