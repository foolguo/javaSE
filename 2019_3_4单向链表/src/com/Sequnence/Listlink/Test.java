package com.Sequnence.Listlink;

/**
 * @Author: yd
 * @Date: 2019/3/4 11:10
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        ListLink list=new ListLink();
        list.add(1);
        list.add(2);
        list.add(3,2);
        list.add("abc",0);
        list.display();
       //System.out.println(list.removeIndex(1));
       list.display();
       list.motify("hahahah",1);
       list.display();
       list.motify("bibi","hahahah");
       list.display();
       list.cler();
       list.display();
        System.out.println(list.getSize());

    }
}
