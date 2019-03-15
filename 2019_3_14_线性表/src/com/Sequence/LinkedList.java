package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/15 10:45
 * @Version 1.0
 */
public class LinkedList implements Sequence {
    class  Node{
        private Object data;
        private Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead=new Node(null,null);
    }

    /**
     * 头插法
     * @param data
     */
    @Override
    public void add(Object data) {
          add(0,data);
    }
    public void add(int index,Object data){
        rangCheck(index);
        Node temp=dummyHead;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.next=new Node(data,temp.next);
        size++;

    }
    private void rangCheck(int index){
        if(index<0||index>size){
            throw new  IndexOutOfBoundsException("下标越界");
        }
    }
    private Node node(int index){
        Node temp=dummyHead.next;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        Node curr=node(index);
        Node temp=dummyHead;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        temp.next=curr.next;
        curr.next=curr=null;
        size--;
        return true;
    }

    @Override
    public Object get(int index) {
        rangCheck(index);
        Node node=node(index);
        return node.data;
    }

    @Override
    public boolean contains(Object data) {
        for(Node temp=dummyHead.next;temp!=null;temp=temp.next){
            if(temp.data.equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangCheck(index);
        Node curr=node(index);
        Object temp=curr.data;
        curr.data=newData;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (Node node=dummyHead.next;node!=null;){
            Node temp=node.next;
            node.next=node=null;
            node=temp;
            size--;

        }

    }

    @Override
    public Object[] toArray() {
        Object[] array=new  Object[size];
        int k=0;
        for(Node temp=dummyHead.next;temp!=null;temp=temp.next){
            array[k++]=temp.data;
        }
        return array;
    }
}
