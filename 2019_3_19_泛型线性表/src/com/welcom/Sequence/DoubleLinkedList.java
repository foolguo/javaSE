package com.welcom.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/19 14:05
 * @Version 1.0
 */
public class DoubleLinkedList<T> implements Sequence<T>{
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
           add(size,data);
    }
    public void add(int index,T data){
       if(index<0||index>size){
           throw  new IndexOutOfBoundsException("下标越界");
       }
       if(head==null){
           head=tail=new Node(null,data,null);
           size++;
           return ;
       }
       Node curr=node(index);
       Node prev=curr.prev;
       Node newNode=new Node(data);
       if(curr==head){
           curr.prev=newNode;
           newNode.next=curr;
           head=curr;
           size++;
           return ;
       }
       if(curr==tail){
           tail.next=newNode;
           newNode.prev=tail;
           tail=newNode;
           size++;
            return ;
       }
           newNode.next = prev.next;
           prev.next = newNode;
           newNode.prev = prev;
       size++;

    }
    private void rangCheck(int index){
        if(index<0||index>=size){
            throw  new IndexOutOfBoundsException("下标越界");
        }
    }
    private Node node(int index){
        if((size>>1)>index){
            Node curr=head;
            for(int i=0;i<index;i++){
                curr=curr.next;
            }
            return curr;
        }else{
            Node curr=tail;
            for (int i=size-1;i>index;i--){
                curr=curr.prev;
            }
            return curr;

        }
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node curr=node(index);
        Node prev=curr.prev;
        Node next=curr.next;
        if(curr==head){
            next.prev=null;
            head=head.next;
        }else{
            prev.next=curr.next;
            curr.next=null;
        }
        if(curr==tail){
            tail=tail.prev;
            prev.next=null;
        }else{
            next.prev=curr.prev;
            curr.prev=null;
        }
        size--;
        return true;
    }

    @Override
    public T get(int index) {
        rangCheck(index);
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        for(Node temp=head;temp!=null;temp=temp.next){
            if(data.equals(temp.data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
        rangCheck(index);
        Node node=node(index);
        T temp=node.data;
        node.data=newData;
        return temp;

    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node node = head;node!=null;){
            Node temp=node.next;
            node.next=node=null;
            node=temp;
            size--;
        }
    }

    @Override
    public T[] toArray() {
        return null;
    }
}
