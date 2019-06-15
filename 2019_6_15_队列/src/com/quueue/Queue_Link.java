package com.quueue;

import com.Queue;

/**
 * @Author: yd
 * @Date: 2019/6/15 13:19
 * @Version 1.0
 */
public class Queue_Link<E> implements Queue<E> {
    @Override
    public int size() {
        return size;
    }

    private class Node{
         E e;
         Node next;

        public Node(E e) {
            this.e = e;
        }

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private  int size;
    @Override
    public void enQueue(E e) {
        if(head==null){
            Node newNode=new Node(e);
            head=tail=newNode;
            size++;
            return;
        }
        tail.next=new Node(e);
        tail=tail.next;
        size++;
    }

    @Override
    public E dequeue() {
        E e=head.e;
        head=head.next;
        size--;
        return e;
    }

    @Override
    public E peek() {
        return head.e;
    }

    @Override
    public void isEmpty() {
        if (head == null) {
            throw new IndexOutOfBoundsException("为空");
        }
    }

}
