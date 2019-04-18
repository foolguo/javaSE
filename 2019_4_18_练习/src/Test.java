import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Stack;

/**
 * @Author: yd
 * @Date: 2019/4/18 17:53
 * @Version 1.0
 */

/*
汉诺塔
 */


/*
public class Test {
    public static void main(String[] args) {
        hanoi(3,'A','B','C');
    }
    public static void hanoi(int n,char x,char y ,char z){
        if(n==1){
            move(1,x,z);
        }else{
            hanoi(n-1,x,z,y);
            move(n,x,z);
            hanoi(n-1,y,x,z);
        }
    }
    public static void move(int n,char x,char z){
        System.out.println(x+"->"+z);
    }
}
*/

/*
栈：数组实现
    链表实现
 */
//数组实现
/*class MyStack{
    private int[] array;
    public final static int MAX_Capacity= Integer.MAX_VALUE-8;
    private int realSize=3;
    private int size=-1;
    public MyStack() {
        array=new int[realSize];
    }
    public void push(int data){
        //入栈时先判断是否需要扩容
        ensureCapacity(array.length+1);
        array[++size]=data;
    }
    public int pop(){
        //出栈是判断是否为空
        isEmpty();
        int data=array[--size];
        return data;
    }
    public int peek(){
        //查看栈顶元素判断是否为空
        isEmpty();
        return array[size];
    }
    public void  isEmpty(){
        if(array.length==0){
            throw  new IndexOutOfBoundsException("栈为空");
        }

    }
    public void ensureCapacity(int n){
        if(n>=realSize){
            grow(n);
        }else{
            return ;
        }
    }*/
/**
 * 判断是否需要扩容
 */
/*private void grow(int minCapacity){
        int oldCapacity=array.length;
        int newCapacity=oldCapacity<<1;
        if(newCapacity-minCapacity<0){
        newCapacity=minCapacity;
        }
        if(newCapacity-MAX_Capacity>0){
        newCapacity=MAX_Capacity;
        }
        array=Arrays.copyOf(array,newCapacity);
        realSize=newCapacity;
        }*/

class MyStack<E>{
    class Node{
        private Node pre;
        private E data;
        private Node next;



        public Node(E data) {
            this.data = data;
        }

        public Node(Node pre, E data, Node next) {
            this.pre = pre;
            this.data = data;
            this.next = next;
        }
    }
    private Node tail;
    private int size;
    public void push(E data){
        if(tail==null){
            tail=new Node(data);
        } else {
            Node newNode=new Node(data);
            newNode.next=tail.next;
            newNode.pre=tail;
            tail.next=newNode;
            tail=newNode;
        }
        size++;
    }
    public E pop(){
         isEmpty();
         E data=tail.data;
         Node preNode=tail.pre;
         tail.pre=tail=null;
         tail=preNode;
         return data;

    }
    public E peek(){
        return tail.data;
    }
    private void isEmpty(){
        if (size==0){
            throw new IndexOutOfBoundsException("没有元素了");
        }
    }

}
public class Test{
    public static void main(String[] args) {
        MyStack stack=new MyStack();
            stack.push(1);
            stack.push(2);
            stack.push(3);
        /*System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.peek());*/
        stack.push(4);
        System.out.println(stack.peek());
    }
}
