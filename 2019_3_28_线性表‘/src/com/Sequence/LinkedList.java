package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/28 9:47
 * @Version 1.0
 */
public class LinkedList<T> implements Sequence<T> {
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
    public LinkedList(){
        dummyHead=new Node(null,null);
    }

    @Override
    public void add(T data) {
        add1(0,data);
    }
    public void add1(int index,T data){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        Node prev=prev(index);
        Node newNode = new Node(data);
        newNode.next=dummyHead.next;
        dummyHead.next=newNode;
       // prev.next=new Node(data,prev.next);
        size++;
    }
    private Node prev(int index){
        Node prev=dummyHead;
        for (int i=0;i<index;i++){
            prev=prev.next;
        }
        return prev;
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        if (dummyHead.next==null){
            return  false;
        }
        Node prev=prev(index);
        Node curr=curr(index);
        prev.next=curr.next;
        curr.next=curr=null;
        size--;
        return true;
    }
    public void delete(T data){
        if(!(contains(data))){
            throw new IndexOutOfBoundsException("元素不存在");
        }
        deleteInternal(dummyHead.next,data);

    }
    private Node deleteInternal(Node node,T data){
        if(node==null){
            return null;
        }
         Node res=deleteInternal(node.next,data);
        if(node.data.equals(data)){
            size--;
            return res;
        }
         node.next=res;
        res=node;
        return res;
    }
    private void rangCheck(int index){
        if(index<0||index>=size){
            throw  new IndexOutOfBoundsException("越界");
        }
    }
    private Node curr(int index){
        Node curr=dummyHead.next;
        for(int i=0;i<index;i++){
            curr=curr.next;
        }
        return curr;
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
        rangCheck(index);
        Node curr=curr(index);
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
        for(Node node=dummyHead.next;node!=null;){
            Node temp=node.next;
            node=node.next=null;
            node=temp;
            size--;
        }
    }

    @Override
    public Object[] toArray() {
        Object[] data = new Object[size];
        Node node=dummyHead.next;
        for(int i=0;i<size;i++){
            data[i]=node.data;
            node=node.next;
        }
        return data;
    }
}
