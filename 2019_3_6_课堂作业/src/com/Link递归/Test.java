package com.Link递归;

/**
 * @Author: yd
 * @Date: 2019/3/6 15:57
 * @Version 1.0*/


public class Test {
    class Node{
        private Node next;
        private Object data;
        public Node(Object data) {
            this.data = data;
        }
        public Node(Node next, Object data) {
            this.next = next;
            this.data = data;
        }
    }
    private  static Node head;
   public void add(Object data){
        head=new Node(head,data);

    }
    public void add(Object newData,int index,Node head) {
       if(index==0){
           head=new Node(head,newData);
           return ;
       }else if(index==1){
           head.next=new Node(head.next,newData);
           return ;
       }
       add(newData,index-1,head.next);

    }

    public static void main(String[] args) {
        Test list=new Test();
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(1);
        list.add(5,4,head);
        //list.reverseBetween(head,2,4);
        list.reverseKGroup(head,2);
        for(Node temp=head;temp!=null;temp=temp.next){
            System.out.print(temp.data+"、");
        }
    }
    public Node reverseBetween(Node head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        Node dummyHead = new Node(-1);
        dummyHead.next = head;
        if (m == n) {
            return dummyHead.next;
        }
        Node prev=dummyHead;
        for(int i=0;i<m-1;i++){
            prev=prev.next;
        }
        Node f=prev.next;
        Node s=f.next;
        int k=n-m;
        while(k>0){
            f.next=s.next;
            s.next=prev.next;
            prev.next=s;
            s=f.next;
            k--;
        }
        return dummyHead.next;
    }

    /**
     * k个一组翻转链表
     * @param head
     * @param k
     * @return
     */
    public Node reverseKGroup(Node head, int k){
        if(head==null||head.next==null){
            return head;
        }
       Node dummyHead= new Node(-1);
       dummyHead.next=head;
       Node prev=dummyHead;

        int size=0;
        for(Node temp=head;temp!=null;temp=temp.next){
            size++;
        }
        int n=size/k;
        while(n>0){
            Node f=prev.next;
            Node s=f.next;
            for(int i=0;i<k-1;i++){
                f.next=s.next;
                s.next=prev.next;
                prev.next=s;
                s=f.next;
            }
            for(int j=0;j<k;j++){
                prev=prev.next;
            }
            n--;
        }
       return head;
    }


    public static Node remove(Node head,Object data){
        if(head==null){
            return null;
        }
        Node res=remove(head.next,data);
        if(head.data==data){
            return res;
        }else{
            head.next=res;
            return head;
        }
    }
}
