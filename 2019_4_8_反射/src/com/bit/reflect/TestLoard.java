package com.bit.reflect;

/**
 * @Author: yd
 * @Date: 2019/4/9 18:30
 * @Version 1.0
 */
class Member{

}
public class TestLoard {
    public static void main(String[] args) {
        Class cls=Member.class;
        System.out.println(cls.getClassLoader());
        System.out.println(cls.getClassLoader().getParent());
        System.out.println(cls.getClassLoader().getParent().getParent());
    }
}
