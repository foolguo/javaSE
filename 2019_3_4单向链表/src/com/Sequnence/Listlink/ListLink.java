package com.Sequnence.Listlink;

/**
 * @Author: yd
 * @Date: 2019/3/4 10:25
 * @Version 1.0
 */
public class ListLink implements Sequence {
    private class Node{
        Object data;
        Node next;

        public Node(Object data) {
            this.data = data;
        }

        public Node(Object data, Node next) {
            this.data = data;
            this.next = next;
        }
    }
    private Node dummyHead;//虚拟头结点
    private int size;
    public ListLink(){
        dummyHead=new Node(null,null);

    }
    @Override
    public void add(Object data) {
     add(data,0);
    }
    public void add(Object data,int index){//头插法
            rangCheck(index);
            Node prev=dummyHead;
            for(int i=0;i<index;i++){
                prev=prev.next;
            }
            prev.next=new Node(data,prev.next);
            size++;
    }
    private void rangCheck(int index){
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }
    private Node get(int index){
        rangCheck(index);
        Node temp=dummyHead.next;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }

    @Override
    public Object removeIndex(int index) {
        rangCheck(index);
        Node pre=dummyHead;
        for(int i=0;i<index;i++){
            pre=pre.next;
        }
        Node curr=get(index);
        Object temp=curr.data;
        pre.next=curr.next;
        curr.next=curr=null;
        return temp;

    }

    @Override
    public void removeVal(Object data) {
        Node prev=dummyHead;
        while(prev.next!=null){
            if(prev.next.data==data){
                prev.next=prev.next.next;
                size--;
            }else{
                prev=prev.next;
            }
        }
    }

    @Override
    public void cler() {
      for(Node node=dummyHead.next;node!=null;){
          node.data=null;
          Node temp=node.next;
          node.next=null;
          node=temp;
          size--;
      }

    }

    @Override
    public Object motify(Object newData,int index) {
        rangCheck(index);
        Node temp=get(index);
        Object datas=temp.data;
        temp.data=newData;
        return datas;
    }

    @Override
    public void motify(Object newData,Object val) {
        //找到指定内容的位置，改
        Node curr=dummyHead.next;
        while(curr!=null){
            if(curr.data==val){
                curr.data=newData;

            }
            curr=curr.next;
        }
    }
    public int getSize(){
        return size;
    }
    public void display(){
        for(Node temp=dummyHead.next; temp!=null;temp=temp.next){
            System.out.print(temp.data+"->");

        }
        System.out.println();
    }
}
