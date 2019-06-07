package com.Day14;

import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/6/6 11:30
 * @Version 1.0
 */
//组个最小数
    //2 1 0 0 0 3 0 0 1 0;
    //输出10015558
public class Demo1 {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int[] num=new int[10];
        for(int i=0;i<num.length;i++){
            num[i]=in.nextInt();
        }
        for(int i=1;i<num.length;i++){
            if(num[i]!=0){
                System.out.print(i);
                num[i]--;
                break;
            }
        }
        while(num[0]!=0){
            System.out.print(0);
            num[0]--;
        }
        for(int i=0;i<num.length;i++){
            while(num[i]!=0){
                System.out.print(i);
                num[i]--;
            }
        }
    }
}
