package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/28 10:45
 * @Version 1.0
 */
public class DoubleLinkedList<T> implements Sequence<T> {
    class Node{
        private Node prev;
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(Node prev, T data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    @Override
    public void add(T data) {
            add(0,data);
    }
    public void add(int index,T data){
        rangCheck(index);
        Node node=node(index);
        Node newNode=new Node(null,data,null);
        if(head==null){
            head=tail=newNode;
        }else if(node==head){
            newNode.next=head;
            head.prev=newNode;
            head=newNode;
        }else if (node==null){
            tail.next=newNode;
            newNode.prev=tail;
            tail=newNode;
        }
        else{
            Node prev=node.prev;
            newNode.next=prev.next;
            prev.next=newNode;
            newNode.prev=prev;
            newNode.next.prev=newNode;
        }
        size++;

    }
    private void rangCheck(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }
    private Node node(int index){
        if(index<(size>>1)){
            Node temp=head;
            for(int i=0;i<index;i++){
                temp=temp.next;
            }
            return temp;
        }else{
            Node temp=tail;
            for(int i=size;i>index;i--){
                temp=temp.prev;
            }
            return temp;
        }
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node node=node(index);
        Node next=node.next;
        Node prev=node.prev;
        if(node==head){
            head=head.next;
            head.prev=null;
        }else{
            prev.next=node.next;
            node.next=null;
        }
        if(node==tail){
            tail=tail.prev;
            tail.next=null;
        }else{
            next.prev=node.prev;
            node.prev=null;
        }
        size--;
        return true;
    }
    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    @Override
    public T set(int index, T newData) {
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        Node node=head;
        for(int i=0;i<size;i++){
            data[i]=node.data;
            node=node.next;
        }
        return data;
    }
}
