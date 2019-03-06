/**
 * @Author: yd
 * @Date: 2019/3/5 17:26
 * @Version 1.0
 */
public class DoubleLinkList {
    /*class Node {
        private Object data;
        private Node next;
    }*/
    public static void main(String[] args) {
        LinkList list=new LinkList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add("abc");
        list.add(4);
        list.add("hahaha",0);
        list.add("pig",2);
        /*list.add("pork",8);*/
        list.display();
    }
    /*public static Node remove(Node head,Object data){
        if(head==null){
            return head;
        }
        Node res=new Node(head.next,data);
        if(head.data.equals(data)) {
            return res;
        }else{
            head.next=res;
            return head;
        }
    }
    public static Node add(Object){


    }*/

}
