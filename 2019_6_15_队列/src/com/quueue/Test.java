package com.quueue;

import com.Queue;

/**
 * @Author: yd
 * @Date: 2019/6/15 13:28
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Queue<Integer> queue=new Queue_Link<>();
        int[] num={3,2,5,4,1,6,7};
        for(int i:num)
        queue.enQueue(i);
        System.out.println(queue.peek());
        System.out.println(queue.dequeue());
        System.out.println(queue.peek());
    }
}
