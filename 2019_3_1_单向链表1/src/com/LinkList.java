package com;

public class LinkList {

    class Node {
       public Object data;
       public Node next;

        public Node(Object data) {
            this.data = data;
        }
    }
    private Node head;
    private Node tail;
    private Integer size;
    public LinkList(){
        this.size=0;
    }
    //头结点插入
    public void insertHead(Object data){
        Node newNode=new Node(data);
        if(size==0){//此种情况是创建一个链表
            this.head=newNode;
            this.tail=this.head;
            this.size++;
        }else{
            newNode.next=this.head;
            head=newNode;
            this.size++;
        }
    }
    //尾结点插入
    public void insertTail(Object data){
        Node newNode=new Node(data);
        if(size==0){
          insertHead(data);
        }else{
            tail.next=newNode;
            tail=newNode;
            this.size++;
        }
    }
    //找到任意位置
    public Node get(int index){
        if(index<0||index>this.size-1){
            throw new ArrayIndexOutOfBoundsException("数组越界");
        }
        Node curr=this.head;
        for(int i=0;i<this.size&&curr!=null;curr=curr.next,i++){
            if(i==index){
                return curr;
            }
        }
        return null;
    }
    //任意位置插入
    public void insert(Object data,int index){

        Node newNode=new Node(data);
        if(this.head==null){
            insertHead(data);
        }else{
            //插入链表头
            if(index==0){
                insertHead(data);
            }else if(index==this.size-1){
                insertTail(data);
            }else{

                Node pre=get(index-1);
                if(pre==null){
                    throw new ArrayIndexOutOfBoundsException("index="+(index-1)+"not found node");
                }
                newNode.next=pre.next;
                pre.next=newNode;
            }

        }
        this.size++;

    }
    //该链表结点个数


    public int getSize(){
        return this.size;
    }

    /**
     * 获取头结点的信息
     * @return  Object
     */
    public Object getHead(){
        return this.head.data;
    }

    /**
     * 获取尾结点的信息
     * @return  Object
     */
    public Object getTail(){
        return this.tail.data;
    }

    /**
     * 删除指定结点，并返回删除结点的信息；
     * @param index
     * @return
     */
    public Object delete(int index){
        Node curr=get(index);
        Node pre=get(index-1);
        if(this.size==0) {
            throw new ArrayIndexOutOfBoundsException("该链表不存在");
        }
        if(index==0){
            head=head.next;

        }else if(index==this.size-1){
            pre.next=null;
        }else{
            pre.next=curr.next;
        }
        this.size--;
        return curr;
    }

    /**
     * 清空链表
     */
    public void clear(){
        this.head=null;
        this.tail=null;
        this.size=0;
    }

    /**
     * 取得任意索引处的元素
     * @param index
     * @return
     */
    public Object getData(int index){
        Node curr=get(index);
        return curr.data;
    }

}
