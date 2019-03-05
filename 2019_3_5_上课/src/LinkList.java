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
    }

    //@Override
    //public void add(Object data, int index) { }

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
        if(index<0||index>=0){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }

    @Override
    public Object remote(Object data) {
        return null;
    }

    @Override
    public Object remote(Object data, int index) {
        rangcheck(index);
        Node curr=node(index);
        Node prex=curr.prev;
        Node next=curr.next;
        if(head==null){
            return head;
        }
        return null;
    }

    @Override
    public Object remoteDate(Object data) {
        return null;
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
