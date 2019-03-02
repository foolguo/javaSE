package com.train;

/**
 * @Author: yd
 * @Date: 2019/3/2 9:37
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        DoubleLinkList list=new DoubleLinkList();
        list.creatLink(1);
        list.insertHead(2);
        list.insertTail(3);
        list.insert("abc",1);
        System.out.println(list.getSize());
        System.out.println(list.get(1).data);
    }
}
