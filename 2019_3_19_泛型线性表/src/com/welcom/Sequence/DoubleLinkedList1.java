package com.welcom.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/19 16:23
 * @Version 1.0
 */
public class DoubleLinkedList1<T> implements Sequence<T> {
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
    private  int size;

    @Override
    public void add(T data) {
        Node newNode=new Node(null,data,null);
        if(head==null){
            head=tail=newNode;
        }else{
            newNode.prev=tail;
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node curr=node(index);
        Node prev=curr.prev;
        Node next=curr.next;
        if (curr == head) {
            head=head.next;
            next.prev=null;
        }else{
            prev.next=curr.next;
            curr.next=null;
        }
        if(tail==null){
            tail=tail.prev;
            prev.next=null;
        }else{
            next.prev=curr.prev;
            curr.prev=null;
        }
        size--;
        return true;
    }
    private  Node node(int index){
        Node curr=head;
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
    public T get(int index) {
        return node(index).data;
    }

    @Override
    public boolean contains(Object data) {
        for(Node node = head;node!=null;node=node.next){
            if(node.data.equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public T set(int index, T newData) {
        Node curr=node(index);
        T temp=curr.data;
        curr.data=newData;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node node=head;node!=null;){
            Node temp=node.next;
            node.next=node.prev=node=null;
            node=temp;
            size--;
        }

    }

    @Override
    public T[] toArray() {
        return null;
    }
}
