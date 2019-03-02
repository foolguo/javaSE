package com.train;

/**
 * @Author: yd
 * @Date: 2019/3/2 9:42
 * @Version 1.0
 */
public class DoubleLinkList {
    class Node{
        public  Object data;
        private  Node next;//指向下一个结点
        private Node pre;//指向前一个结点
        public Node(Object data){
            this.data=data;
        }
    }
    private Node head;
    private Node tail;
    private Integer size;

    /**
     * 初始化链表
     */
    public DoubleLinkList(){
        head=null;
        tail=null;
        size=0;
    }

    /**
     * 创建一个新链表
     * @param data
     */
    public void creatLink(Object data){
        Node newNode=new Node(data);
        this.head=newNode;
        this.tail=this.head;
        this.size++;
    }

    /**
     * 头结点插入
     * @param data
     */
    public void insertHead(Object data){
        Node newNode=new Node(data);
        newNode.next=this.head;
        this.head.pre=newNode;
        this.head=newNode;
        this.size++;
    }

    /**
     * 尾结点插入
     * @param data
     */
    public  void insertTail(Object data){
        Node newNode=new Node(data);
        this.tail.next=newNode;
        newNode.pre=this.tail;
        this.tail=newNode;
        this.size++;
    }

    /**
     * 任意位置插入
     * @param data
     * @param index
     */
    public void insert(Object data,int index){
        Node curr=get(index-1);//要插入位置的前一个结点

        if(curr==null){
            throw new ArrayIndexOutOfBoundsException("数组越界异常");
        }
        if(index==0){
            insertHead(data);
        }else if(index==this.size-1){
            insertTail(data);
        }else {
            Node newNode = new Node(data);//创建新结点
            newNode.next = curr.next;
            curr.next=newNode;
            newNode.next.pre = newNode;
            newNode.pre = curr;
        }
        this.size++;
    }

    /**
     * 获得任意索引位置处的结点
     * @param index
     * @return
     */
    public Node get(int index){
        Node curr=this.head;
        for(int i=0;i<this.size&&curr!=null;curr=curr.next,i++){
            if(index==i){
                return curr;
            }
        }
        return null;
    }

    /**
     * 获取长度
     * @return
     */
    public int getSize(){
        return this.size;
    }

    /**
     * 删除头结点
     * @return
     */
    public Object removeHead(){
        Node curr=this.head;
        this.head=this.head.next;
        this.head.pre=null;
        this.size--;
        return curr;
    }

    /**
     * 尾结点删除
     * @return
     */
    public Object removeTail(){
        Node curr=this.tail;
        this.tail.pre=this.tail;
        this.tail.next=null;
        this.size--;
        return curr;
    }

    /**
     * 删除任意位置的结点
     * @param index
     * @return
     */
    public Object remove(int index){
        Node curr=get(index);
        curr.pre.next=curr.next;
        curr.next.pre=curr.pre;
        curr.pre=null;
        curr.next=null ;
        return index;

    }

    /**
     * 清空链表
     */
    public void cler(){
        this.head.next=null;
        this.tail.pre=null;
        this.size=0;
    }
}

