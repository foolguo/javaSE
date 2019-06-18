/**
 * @Author: yd
 * @Date: 2019/6/18 19:52
 * @Version 1.0
 */
public class DoubleLinkList<E> {
    private class Node{
        E e;
        Node pre;
        Node next;

        public Node(E e) {
            this.e = e;
        }
    }
    private Node head;
    private Node tail;
    private int size;
    public void addFirst(E e){
        Node newNode=new Node(e);
        if (size==0){
            head=tail=newNode;

        }else{
            newNode.next=head;
            head.pre=newNode;
            head=newNode;
        }
        size++;
    }
    public void addTail(E e){
        Node newNode=new Node(e);
        if (size==0){
            head=tail=newNode;

        }else{
            tail.next=newNode;
            newNode.pre=tail;
            tail=newNode;
        }
        size++;
    }
    public void add(int index, E e) {
        //检查下标是否越界
        if(index<0||index>size){
            throw new IndexOutOfBoundsException("下标越界");
        }
        //取得要插入的结点位置的结点
        Node node =node(index);
        //创建新结点
        Node newNode=new Node(e);
        if(node==null){
            //如果当前节点为空右两种情况，第一种当前链表为空，初始化链表
            if (size==0){
                tail=head=newNode;
            }else{
                //当前链表不为空，插入位置为尾结点的末尾
                //直接采用尾插
                tail.next=newNode;
                newNode.pre=tail;
                tail=newNode;
            }
        }else{
            //当前节点不为空
            //取得当前节点的前驱结点
            Node prev=node.pre;
            //如果当前节点为头结点
            if(node==head){
                //头插
                head.pre=newNode;
                newNode.next=head;
                head=newNode;
            }else {
                //直接插入
                newNode.pre=prev;
                prev.next=newNode;
                node.pre=newNode;
                newNode.next=node;
            }

        }
        size++;
    }
    private Node node(int index){
        //取size的一半
        int n=size>>1;
        if(index<=n) {
            //如果当前t下标小于n，说明在链表的前半段
            Node temp = head;
            for (int i = 0; i < index; i++) {
                temp = temp.next;
            }
            return temp;
        }else {
            //否则在链表的后半段
            Node temp=tail;
            for (int i=size-1;i>index;i--){
                temp=temp.pre;
            }
            return temp;
        }
    }
    private void checkIndex(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }
    }
    public boolean contains(E e){
        for (Node temp=head;temp!=null;temp=temp.next){
            if(temp.e.equals(e)){
                return true;
            }
        }
        return false;

    }

    public E removeFirst(){
        return remove(0);
    }
    public E remove(int index){
        checkIndex(index);
        Node node=node(index);
        Node prev=node.pre;
        Node next=node.next;
        E e=node.e;
        //如果node为head 删除头结点
        if(node==head){
            head=head.next;
            head.pre=null;

        }else{
            //和前驱结点的关系断了
            prev.next=node.next;
            node.next=null;
        }

        if(node==tail){
            tail=tail.pre;
        }else{
            //和后继结点的关系断了
            next.pre=node.pre;
            node.pre=null;
        }
        size--;
        return e;
    }
    public E set(E e,int index){
        checkIndex(index);
        E temp=e;
        Node node=node(index);
        node.e=e;
        return temp;

    }
    public  E  get(int index){
        checkIndex(index);
        return node(index).e;
    }
    public int size(){
        return size;
    }

}
