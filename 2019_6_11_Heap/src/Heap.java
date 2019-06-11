import java.sql.Array;
import java.util.Arrays;
import java.util.Comparator;

/**
 * @Author: yd
 * @Date: 2019/6/11 21:49
 * @Version 1.0
 */
/*
* 堆：
* 完全二叉树，可以用数组存储
* 堆的性质 任意一颗子树的父节点都比左右两个孩子结点要大或者小
*  当前节点下标为x左孩子  left=2*x+1  right=2*x+2;
*   符结点的下表  （x-1）/2
*
*
* */

public class Heap<E> {
    Object[] elements;
    int size;
    Comparator<E> comparator;

    public Heap() {
        this(10,null);
    }
    public Heap(int initSize){
        this(initSize,null);
    }
    public Heap(int initSize,Comparator<E> comparator){
        elements=new Object[initSize];
        this.comparator=comparator;
    }
    public  void add(E e){
        if(elements.length==size){
            grow();
        }
        elements[size++]=e;
        shitUp(size-1);

    }
    public E extract(){
        E max= (E) elements[0];
        swap(0,size-1);
        size--;
        shitDown(0);
        return max;
    }
    public void replace(E e){
        elements[0]=e;
        shitDown(0);
    }
    public Heap(int[] nums){
        elements=new Object[nums.length];
        for(int i=0;i<nums.length;i++){
            elements[i]=nums[i];
        }
        size=nums.length;
        for (int i=(nums.length-1-1);i>=0;i--){
            shitDown(i);
        }
    }
    private int leftIndex(int index){
        return 2*index+1;
    }
    private int rightIndex(int index){
        return 2*index+2;
    }
    private  int parentIndex(int index){
        if(index==0){
            throw new IndexOutOfBoundsException("你没有爸爸");
        }
        return (index-1)/2;
    }
    private int compare(E e1,E e2){
        if(comparator==null){
            return ((Comparable<E>) e1).compareTo(e2);
        }
       return comparator.compare(e1,e2);
    }

    private void shitDown(int index){
        while(leftIndex(index)<size){
            int j=leftIndex(index);
            if(j+1<size) {
                if (compare((E) elements[j], (E) elements[j + 1]) < 0) {
                    j = j + 1;
                }
            }
            if(compare((E) elements[index],(E) elements[j])>0)
                    break;
                swap(j,index);
                index=j;
        }
    }

    private void shitUp(int index){
        while(index>0&&compare((E)elements[index],(E)elements[parentIndex(index)])>0){
            swap(index,parentIndex(index));
            index=parentIndex(index);
        }
    }
    public E findMax(){
        if(size==0){
            throw new IndexOutOfBoundsException("当前堆没有元素");
        }
        return (E) elements[0];
    }

    private  void swap(int i,int j){
        E e= (E) elements[i];
        elements[i]=elements[j];
        elements[j]=e;
    }
    private void grow(){
        int oldLength=elements.length;
        int newLength=oldLength+(oldLength<64?oldLength:oldLength>>1);
        if(newLength>Integer.MAX_VALUE){
            throw new IndexOutOfBoundsException("下标越界");
        }
        elements= Arrays.copyOf(elements,newLength);
    }
}
