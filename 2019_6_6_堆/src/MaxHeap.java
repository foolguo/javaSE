import java.util.Arrays;
import java.util.Comparator;
import java.util.TreeMap;

/**
 * @Author: yd
 * @Date: 2019/6/6 19:45
 * @Version 1.0
 */
public class MaxHeap<E> {
    int size;
    Object[] elements;
    Comparator<E> comparator;
    private final static int DEFAULT_INIT=10;

    public MaxHeap() {
        this(DEFAULT_INIT,null);
    }
    public MaxHeap(int initCapcity) {
        this(initCapcity,null);
    }
    public MaxHeap(int initCapcity,Comparator<E> comparator){
        this.comparator=comparator;
        elements=new Object[initCapcity];
    }
    public int parent(int index){
        return (index-1)*2;
    }
    public int childrenLeft(int index){
        return  2*index+1;
    }
    public int childrenRight(int index){
        return 2*index+2;
    }
    public int compare(E e1,E e2){
        if(this.comparator==null){
            return (( Comparable<? super E>) e1).compareTo((E) e2);

        }
      return  comparator.compare(e1,e2);
    }
    public void add(E e){
        if(size==elements.length){
            grow();
        }
        elements[size++]=e;


    }
    private void shiftUp(int index){
        while(index>0&& compare((E)elements[index], (E) elements[parent(index)])>0){
            swap(index,parent(index));
            index=parent(index);
        }
    }
    private void swap(int l,int r){
        E temp= (E) elements[l];
        elements[l]=elements[r];
        elements[r]=temp;
    }
    private void grow(){
        int old=elements.length;
        int newc=old+(old<64?old:old>>1);
        if(newc>Integer.MAX_VALUE-8){
            throw new IndexOutOfBoundsException("数组太大");
        }
        elements= Arrays.copyOf(elements, newc);

    }
    public E exactMax(){
        swap(0,size-1);
        E e= (E) elements[--size];
        siftDown(0);
        return e;
    }
    //         6  (0)
    //   7(1)          9 (2)
    //5(3) 2(4)  3(5)    8(6）
 // 3(7)
    private void siftDown(int index){
        while(childrenLeft(index)<size){
            int max=childrenLeft(index);
            if(compare((E)elements[max],(E)elements[childrenRight(index)])<0){
                max=childrenRight(index);
            }
            if(compare((E)elements[index],(E) elements[max])<0){
                swap(index,max);
            }
            index=max;
        }
    }

}
