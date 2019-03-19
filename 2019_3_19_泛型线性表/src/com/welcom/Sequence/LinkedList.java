//package com.welcom.Sequence;
//
///**
// * @Author: yd
// * @Date: 2019/3/19 10:45
// * @Version 1.0
// */
//
//public class LinkedList<T> implements Sequence<T>{
//    class Node{
//        private T data;
//        private Node next;
//
//        public Node(T data) {
//            this.data = data;
//        }
//
//        public Node(T data, Node next) {
//            this.data = data;
//            this.next = next;
//        }
//    }
//    private Node dummyHead;
//    private int size;
//    public LinkedList(){
//        dummyHead=new Node(null);
//    }
//    @Override
//    public void add(T data) {
//        add(0,data);
//    }
//    public void add(int index,T data){
//        if(index<0||index>size){
//            throw new IndexOutOfBoundsException("下标越界");
//        }
//        Node prev=prev(index);
//        Node newNode=new Node(data);
//        newNode.next=prev.next;
//        prev.next=newNode;
//        size++;
//    }
//    public Node prev(int index){
//        Node temp=dummyHead;
//        for(int i=0;i<index;i++){
//            temp=temp.next;
//        }
//        return temp;
//    }
//    public void rangCheck(int index){
//        if(index<0||index>=size){
//            throw new IndexOutOfBoundsException("下标越界");
//        }
//    }
//    private Node curr(int index){
//        Node curr=dummyHead;
//        for(int i=0;i<index+1;i++){
//            curr=curr.next;
//        }
//        return curr;
//    }
//    @Override
//    public boolean remove(int index) {
//        rangCheck(index);
//        if(index==0){
//            dummyHead=dummyHead.next;
//        }else {
//            Node prev = prev(index);
//            Node curr = curr(index);
//            prev.next = curr.next;
//            curr.next = curr = null;
//        }
//        size--;
//        return true;
//    }
//
//    @Override
//    public T get(int index) {
//        Node curr=curr(index);
//        return curr.data;
//    }
//
//    @Override
//    public boolean contains(Object data) {
//        return false;
//    }
//
//    @Override
//    public T set(int index, T newData) {
//        Node node=curr(index);
//        T temp=node.data;
//        node.data=newData;
//        return temp;
//    }
//
//    @Override
//    public int size() {
//        return size;
//    }
//
//    @Override
//    public void clear() {
//        for(Node node=dummyHead.next;node!=null;){
//            Node temp=node.next;
//            node.next=node=null;
//            node=temp;
//            size--;
//        }
//
//    }
//
//    @Override
//    public T[] toArray() {
//        return null;
//    }
//}