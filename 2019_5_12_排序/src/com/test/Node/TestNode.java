/*
package com.test.Node;

*/
/**
 * @Author: yd
 * @Date: 2019/5/12 16:33
 * @Version 1.0
 *//*

class LinkedList{
    class Node{
        private Integer data;
        private Node next;
        public Node(int data) {
            this.data = data;
        }

        public Node(Integer data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node dummyHead;
    private int size;

    public LinkedList() {
        dummyHead=new Node(null,null);
    }
    //头插法
    public void add(int data){
        add(0,data);
    }
    //插入任意位置
    public void add(int index,int data){
        rangeCheck(index);
        //找到要插入位置的前驱结点
        Node prev=node(index);
        prev.next=new Node(data,prev.next);
        size++;
    }
    private Node node(int index){
        Node node=dummyHead;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        return node;
    }
    private void rangeCheck(int index){
        if(index>size){
            throw  new IndexOutOfBoundsException("下标越界");
        }
    }

    public int get(int index){
        if(index>=size){
            throw  new IndexOutOfBoundsException("=没有此下标");
        }
        Node node=currentNode(index);
        return node.data;
    }
    private Node currentNode(int index){
        Node node=dummyHead.next;
        for (int i=0;i<index;i++){
            node=node.next;
        }
        return  node;
    }
    public  int set(int index,int data){

        Node node=currentNode(index);
        int num=node.data;
        node.data=data;
        return num;
    }
    public int remove(int index){
        if(index>=size){
            throw  new IndexOutOfBoundsException("=没有此下标");
        }
        Node prev=node(index);
        Node node=currentNode(index);
        int data=node.data;
        prev.next=node.next;
        node.next=node=null;
        return data;
    }
    public void clear(){
        for (Node node=dummyHead.next;node!=null;){
            Node temp=node.next;
            node=node.next=null;
            size--;
            node=temp;
        }
    }
    public int size()    {
        return size;
    }
    public int[] toArray(){
        int[] data=new int[size];
        int k=0;
        for (Node temp=dummyHead.next;temp!=null;temp=temp.next){
            data[k++]=temp.data;
        }
        return data;

    }

}
public class TestNode {
    public static void main(String[] args) {
        LinkedList linkedList=new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(3,4);
        int[] data=linkedList.toArray();
        for (int i:data){
            System.out.println(i+" ");
        }
        System.out.println(linkedList.size());
    }
}
*/
