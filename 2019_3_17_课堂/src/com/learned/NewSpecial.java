package com.learned;

/**
 * @Author: yd
 * @Date: 2019/3/17 19:13
 * @Version 1.0
 */
//import com.MyMothod.MyMath;
import static com.MyMothod.MyMath.*;
//可变参数
public class NewSpecial {
    public static void main(String[] args) {
        System.out.println(add(1,2));//传参的时候不需要进行数组的声明
        System.out.println(add(1,2,3));
        System.out.println(add(1,2,3,4,5));
        System.out.println(add(1,2,3,4,5));//没有静态倒入入之前
    }
//    public static int add(int...data){
//        int sum=0;
//        for(int i=0;i<data.length;i++){//...其实就是[]  表示一个数组
//            sum+=data[i];
//        }
//        return sum;
//    }

}
