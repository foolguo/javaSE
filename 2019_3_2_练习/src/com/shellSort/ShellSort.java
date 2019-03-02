package com.shellSort;

/**
 * @Author: yd
 * @Date: 2019/3/2 15:09
 * @Version 1.0
 */
public class ShellSort {
    public static void Sort(int[] data) {
        int N=data.length;
        for(int gap=N/2;gap>0;gap=gap/2){
            for(int i=gap;i<data.length;gap++){
                int j=i-gap,temp=data[i];
              for(;j>=0&&temp<data[j];j-=gap){
                    data[j+gap]=data[j];
                }
                data[j+gap]=temp;

            }
        }

    }

    public static void main(String[] args) {
        int[] data={5,4,6,7,3,9,1};
        Sort(data);

    }
}
