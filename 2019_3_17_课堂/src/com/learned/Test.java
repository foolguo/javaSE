package com.learned;

/**
 * @Author: yd
 * @Date: 2019/3/17 15:22
 * @Version 1.0
 */


interface  ISubject<P,R>{
    public P switchCase(R r);
}
interface Print{
    public void print();
}
interface H<T>{
    public T add(T t1,T t2);
}
public class Test {
    /*public static void main(String[] args) {
        //引用对象的静态方法
        ISubject<String,Integer> subject=
                String::valueOf;//就相当于String.value();
        System.out.println(subject.switchCase(10)+" "+10);
        //Lamda表达式无返回值，一行代码
        Print p1=()-> System.out.println("Hello world");
        p1.print();
        //Lamda表达式无返回值，多行代码
        Print p2=()->{
            System.out.println("hello thank you ");
            System.out.println("thank you very much");
        };
        p2.print();
        //Lamda表达式有返回值 一行代码

    }*/
}
