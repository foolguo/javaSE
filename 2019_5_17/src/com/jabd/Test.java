package com.jabd;

import java.util.Arrays;

/**
 * @Author: yd
 * @Date: 2019/5/17 14:54
 * @Version 1.0
 */
/*
class Stack{
    private int[] data;
    private  int maxSize;
    private int top;
    public Stack(int maxSize){
        this.maxSize=maxSize;
        data=new int[maxSize];
    }
    public void push(int value){
        check();
        data[++top]=value;
    }
    public int push(){
        return  data[top--];
    }
    public int peek(){
        return  data[top];
    }
    public boolean isFull(){
        if(maxSize-1==top){
            return true;
        }else{
            return false;
        }
    }

    private void check(){
        if(top==maxSize-1){
            grow();
        }
    }
    private  void grow(){
        int newSize=0;
        if((maxSize<<1)>Integer.MAX_VALUE){
            newSize=Integer.MAX_VALUE;
        }else{
            newSize=maxSize<<1;
        }
        data=Arrays.copyOf(data,newSize);
    }
    public int size(){
        return maxSize;
    }
}
public class Test{
    public static void main(String[] args) {
        Stack stack=new Stack(3);
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        System.out.println(stack.peek());
        System.out.println(stack.size());
    }
}*/

/*
class Queue{
    private int[] data;
    private int maxSize;
    private int rear;
    private int front;
    private int nItems;
    public Queue(int maxSize){
        this.maxSize=maxSize;
        data=new int[maxSize];
        rear=-1;
        front=0;
    }
    public void Insert(int value){
        if(isFull()) throw  new ArrayIndexOutOfBoundsException("队列已满");
        if(rear==maxSize-1){
            rear=-1;
        }
        data[++rear]=value;
        nItems++;
    }
    public  int remove(){
        if (nItems==0){
            throw new ArrayIndexOutOfBoundsException("队列以空");
        }
        if (front==maxSize){
            front=0;
        }
        int num= data[front++];
        nItems--;
        return num;
    }
    public int size(){
        return nItems;
    }
    private boolean isFull(){
        if(nItems==maxSize){
            return true;
        }
        return false;
    }
}
public class Test{
    public static void main(String[] args) {
        Queue queue=new Queue(3);
        queue.Insert(1);
        queue.Insert(2);
        queue.Insert(3);
        System.out.println(queue.remove());
        queue.Insert(4);
    }
}*/

/*
class LinkList {
    class Node {
        private Object obj;
        private Node next;

        public Node(Object obj) {
            this.obj = obj;
        }

        public Node(Object obj, Node next) {
            this.obj = obj;
            this.next = next;
        }
    }

    private Node dummyHead;
    private int size;

    public LinkList() {
        dummyHead = new Node(null, null);
    }

    public void add(int value) {
        add(0, value);
    }

    public void add(int index, Object value) {
        if (index > size) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
        Node prev=prev(index);
        prev.next=new Node(value,prev.next);
        size++;
    }
    public void remove(int index) {
        check(index);
        Node prev = prev(index);
        Node node =node(index);
        prev.next=node.next;
        node=node.next=null;
        size--;
    }
    public void clear(){
        for (Node node =dummyHead.next;node!=null;){
            Node temp=node.next;
            node.next=node=null;
            node=temp.next;

        }

    }

    private void check(int index){
        if (index >= size) {
            throw new ArrayIndexOutOfBoundsException("下标越界");
        }
    }
    private Node node(int index){
        Node temp=dummyHead.next;
        for (int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    private Node prev(int index){
        Node temp=dummyHead;
        for (int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;

    }
}


*/
