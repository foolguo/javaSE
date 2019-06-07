package com.Day14;

import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/6/6 11:41
 * @Version 1.0
 */
//尼克丝彻定理
    //一个数的立方可以由其相同的个数的奇数组成
    //1^3=1
    //2^3=3+5
    //3^3=7+9+11;
    //4^3=13+15+19+21;
public class Demo2 {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int n=in.nextInt();
        int m=n*n-(n-1);
        long result=(int) Math.pow(n,3);
        System.out.print(result+"=");
        for(int i=0;i<n;i++) {
            if (i == n - 1) {
                System.out.print(m);
            }else{
                System.out.print(m+"+");
                m=m+2;
            }
        }
    }
}
