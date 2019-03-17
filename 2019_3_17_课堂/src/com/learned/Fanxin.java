package com.learned;

/**
 * @Author: yd
 * @Date: 2019/3/17 19:40
 * @Version 1.0
 */
class Computer<T>{
    private String Name;
    private  T price;
    public <T> T print(T e){
        return  e;
    }
    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public T getPrice() {
        return price;
    }

    public void setPrice(T price) {
        this.price = price;
    }
}
public class Fanxin {
    public static void main(String[] args) {
       Computer<Double> c1=new Computer<>();
       c1.setPrice(123.2);
        System.out.println(c1.getPrice());
        System.out.println(c1.print(100.1));
        Computer c2 = new Computer<>();
        System.out.println(c2.getPrice());
    }
}
