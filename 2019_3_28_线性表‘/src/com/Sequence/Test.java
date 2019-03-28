package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/28 10:00
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
 /*       LinkedList<Integer> list=new LinkedList<>();
        list.add(5);
        list.add(4);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(4);
        list.add(1);
        list.delete(4);
        Object[] data= list.toArray();
        for(Object i:data){
            System.out.print(i+" ");
        }*/
        DoubleLinkedList<Integer> list=new DoubleLinkedList<>();
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.remove(0);
        list.remove(3);
        Object[] data=list.toArray();
        for(Object i:data){
            System.out.print(i+" ");
        }
    }
}
