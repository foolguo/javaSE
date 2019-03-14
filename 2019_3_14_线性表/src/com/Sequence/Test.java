package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/14 21:08
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        DoubleLinkedlist l=new DoubleLinkedlist();
        l.add(1);
        l.add(2);
        l.add(3);
        l.add(4);
        l.add(5);

        System.out.println(l.get(1));
        l.remove(1);
        System.out.println(l.get(1));
    }
}
