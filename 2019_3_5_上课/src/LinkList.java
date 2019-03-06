/**
 * @Author: yd
 * @Date: 2019/3/5 21:19
 * @Version 1.0
 */
public class LinkList implements Sequence{
    class Node{
        private Node prev;//前驱结点
        private Object data;
        private Node next;//后继结点

        public Node(Object data) {
            this.data = data;
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

    /**
     * 尾插法插入
     * @param data
     */
    @Override
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

    /**
     * 在指定位置插入元素
     * @param data
     * @param index
     */
    @Override
    public void add(Object data, int index) {
        if(index<0||index>size){
            throw  new IndexOutOfBoundsException("下标越界");
        }
        Node curr=node(index);
        Node prev=curr.prev;
        if (curr==head){
            Node node=new Node(null,data,head);
            head=node;
            size++;
        }else{
            Node node=new Node(prev,data,curr);
            prev.next=node;
            curr.prev=node;
            size++;
        }
    }

    public Object get(int index){
        rangcheck(index);
        Node curr=node(index);
        return curr.data;
    }
    public void set(int index,Object newData){
        rangcheck(index);
        Node curr=node(index);
        curr.data=newData;
    }
    private Node node(int index){
        Node temp=head;
        for(int i=0;i<index;i++){
            temp=temp.next;
        }
        return temp;
    }
    private void rangcheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    /**
     *  * 删除元素
     *      * 思路
     *      * 1.判断是否是头结点，
     *      * 2.判断是否是尾结点
     * @param index
     * @return
     */
    @Override
    public Object remote(int index) {
        rangcheck(index);
        Node curr=node(index);
        Object temp=curr.data;
        Node prev=curr.prev;
        Node next=curr.next;
        if(curr==head){
            head=head.next;
        }else{
            prev.next=curr.next;
            curr.next=null;
        }
        if(curr==tail){
            tail=tail.prev;
        }else{
            next.prev=curr.prev;
            curr.prev=null;
        }
        size--;
        return temp;
    }




    /**
     * 删除指定元素
     * @param data
     * @return
     */
    @Override
    public void remoteDate(Object data) {
        Node temp=head;
        while(temp!=null){
           Node next=temp.next;
           Node prev=temp.prev;
            if(temp.data==data){
                if(temp==head){
                    head=head.next;
                }else{
                    prev.next=temp.next;
                    temp.next=null;
                 }
                if(temp==tail){
                    tail=tail.prev;
                }else {
                    next.prev=temp.prev;
                    temp.prev=null;
                }
            }
            temp=next;
        }
    }

    @Override
    public void clear() {
        for(Node temp=head;temp!=null;){
            Node node=temp.next;
            temp.next=temp.prev=temp=null;
            temp=node;
            size--;
        }
    }

    @Override
    public int getSize() {
        return size;
    }
    public void display(){
        for(Node temp=head; temp!=null;temp=temp.next){
            System.out.print(temp.data+"、");
        }
    }
}
