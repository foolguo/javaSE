package com.welcom.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/19 15:53
 * @Version 1.0
 */
public class LinkedList1<T> implements Sequence<T>{
    class Node{
        private T data;
        private Node next;

        public Node(T data) {
            this.data = data;
        }

        public Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node dummyHead;
    private int size;
    public LinkedList1(){
        dummyHead=new Node(null,null);
    }
    @Override
    public void add(T data) {
        add(0,data);
    }
    public void add(int index,T data){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node prev=prev(index);
        prev.next=new Node(data,prev.next);
        this.size++;
    }
    private Node prev(int index){
        Node prev=dummyHead;
        for(int i=0;i<index;i++){
            prev=prev.next;
        }
        return prev;
    }
    private Node curr(int index){
        Node curr=dummyHead.next;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        return curr;
    }
    private void rangCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node prev=prev(index);
        Node curr=curr(index);
        prev.next=curr.next;
        curr.next=null;
        size--;
        return true;
    }

    @Override
    public T get(int index) {
        rangCheck(index);
        return curr(index).data;
    }

    @Override
    public boolean contains(Object data) {
        for(Node node=dummyHead.next;node!=null;node=node.next){
            if(node.data.equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
        Node node=curr(index);
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
        for(Node node=dummyHead.next;node!=null;){
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
