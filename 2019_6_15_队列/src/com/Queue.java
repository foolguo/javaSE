package com;

/**
 * @Author: yd
 * @Date: 2019/6/15 12:44
 * @Version 1.0
 */
public interface Queue<E> {
    void enQueue(E e);
    E dequeue();
    E peek();
    void isEmpty();
    int size();
}
