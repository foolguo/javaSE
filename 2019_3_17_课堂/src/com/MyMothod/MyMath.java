package com.MyMothod;

/**
 * @Author: yd
 * @Date: 2019/3/17 19:20
 * @Version 1.0
 */
public class MyMath {
    public static int add(int...data){
        int sum=0;
        for(int i=0;i<data.length;i++){
            sum+=data[i];
        }
        return sum;
    }
}
