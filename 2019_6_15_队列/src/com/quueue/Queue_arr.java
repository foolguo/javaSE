package com.quueue;

import com.Queue;

/**
 * @Author: yd
 * @Date: 2019/6/15 12:51
 * @Version 1.0
 */
public class Queue_arr<E>implements Queue<E> {
    private Object[] data;
    int head;
    int tail;
    public Queue_arr(){
        data=new Object[11];
    }
    public Queue_arr(int init){
        data=new Object[init+1];
    }
    @Override
    public void enQueue(E e) {
        if((tail+1)%data.length==head){
            throw new IndexOutOfBoundsException("队列已满");
        }

        data[tail]=e;
        tail=(tail+1)%data.length;
    }

    @Override
    public E dequeue() {
        E p= (E) data[head];
        head=(head+1)%data.length;
        return p;
    }

    @Override
    public E peek() {
        return (E) data[head];
    }

    @Override
    public void isEmpty() {
        if(head==tail){
            throw new IndexOutOfBoundsException("队列为空");
        }
    }

    @Override
    public int size() {
        if(head<tail){
            return tail-head;
        }
        if(head>tail){
            return data.length-(head-tail)-1;
        }
        return 0;
    }
}
