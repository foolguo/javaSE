package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/14 20:45
 * @Version 1.0
 */
public class DoubleLinkedlist implements Sequence {
    class Node{
        private Node prev;
        private Object data;
        private  Node next;
        public Node(Object data){
            this.data=data;
        }
        public Node(Node prev, Object data, Node next) {
            this.prev = prev;
            this.data = data;
            this.next = next;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    @Override
    /**
     * 尾插法插入数据
     */
    public void add(Object data) {
        Node newNode = new Node(tail,data,null);
        if(head==null){
            head=newNode;
        }else{
            tail.next=newNode;

        }
        tail=newNode;
        size++;
    }

    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node curr=node(index);
        Node prev=curr.prev;
        Node next=curr.next;
        if(prev==null){
            curr=curr.next;
        }else{
            prev.next=curr.next;
            curr.next=null;

        }
        if(next==null){
            curr=curr.prev;
        }else{
            next.prev=curr.prev;
            curr.prev=null;
        }
        size--;

        return false;
    }
    private void rangCheck(int index){
        if(index<0||index>=size){
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
            Node temp =tail;
            for(int i=size-1;i>index;i--){
                temp=temp.prev;
            }
            return temp;
        }
    }
    @Override
    public Object get(int index) {
        rangCheck(index);
        Node node=node(index);
        return node.data;
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
    public Object set(int index, Object newData) {
        rangCheck(index);
        Node node=node(index);
        Object temp=node.data;
        node.data=newData;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(Node temp=head;temp!=null;){
            Node node=temp.next;
            temp.next.prev=null;
            temp.next=null;
            temp=null;
            temp=node;
            size--;

        }

    }

    @Override
    public Object[] toArray() {
        Object[] array=new Object[size];
        int k=0;
        for(Node temp=head;temp!=null;temp=temp.next){
            array[k++]=temp.data;
        }
        return array;
    }
}
