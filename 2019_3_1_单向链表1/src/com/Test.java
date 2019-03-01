package com;

/**
 * @Author: yd
 * @Date: 2019/3/1 20:42
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        LinkList link=new LinkList();
        link.insert(1,0);
        link.insertTail(2);
        link.insertTail("abc");
        link.insertTail("ced");
        System.out.println(link.getSize());
        link.insert("insert",1);
        System.out.println(link.get(1).data);
    }
}
