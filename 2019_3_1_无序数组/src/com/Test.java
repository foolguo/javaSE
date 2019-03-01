package com;

public class Test {
    public static void main(String[] args) {
        Sequence array=new MyArray(2);
        array.add(1);
        array.add(2);
        array.add("abc");
        array.remove(1);
    }
}
