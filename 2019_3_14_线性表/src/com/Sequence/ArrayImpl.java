package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/15 9:58
 * @Version 1.0
 */
import  java.util.Arrays;
public class ArrayImpl implements Sequence {
    Object[] array;
    int size;
    public ArrayImpl(){
        array=new Object[3];
    }
    @Override
    public void add(Object data) {
        //判断数组是否满，如果满扩容
        ifFull(size+1);
        array[size++]=data;
    }
    private void ifFull(int n){
        if(n-array.length>0){
            grow(n);
        }
    }
    private void grow(int n){
        int newLength=size<<1;
        if(newLength-n<0){
            newLength=n;
        }else if(Integer.MAX_VALUE-newLength<0){
            newLength=Integer.MAX_VALUE;
        }
        array=Arrays.copyOf(array,newLength);
    }
    @Override
    public boolean remove(int index) {
        rangCheck(index);
        System.arraycopy(array,index+1,array,index,size-index-1);
        return true;
    }
    private void rangCheck(int index){
        if(index<0||index>=size){
            throw new IndexOutOfBoundsException("下标越界");
        }

    }


    @Override
    public Object get(int index) {
        rangCheck(index);

        return array[index];
    }

    @Override
    public boolean contains(Object data) {
        for(int i=0;i<size;i++){
            if(array[i].equals(data)){
                return true;
            }
        }
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        rangCheck(index);
        Object temp=array[index];
        array[index]=newData;
        return temp;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for (int i=0;i<size;i++){
            array[i]=null;
        }
        size=0;
    }

    @Override
    public Object[] toArray() {
        return array;
    }
}
