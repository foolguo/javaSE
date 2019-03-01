package com;
import java.util.Arrays;
public class MyArray implements Sequence {
    private Object[] array;
    public final static Integer INIT_LENGTH=8;
    public final static Integer MAX_LENGTH=Integer.MAX_VALUE;
    private int size;//数组实际长度
    public MyArray(){
        array=new Object[INIT_LENGTH];
    }
    public MyArray(int length){
        array=new Object[length];
    }
    @Override
    public void add(Object data) {
        ifFull(size+1);
        array[size++]=data;
    }
    @Override
    public boolean remove(int index) {
        if(size==0){
            return false;
        }else if(index==-1){
            return false;
        }else if(index>=size){
            return false;
        }
        if(index==size-1){
            array[--size]=null;
        }else{
            System.arraycopy(array,index+1,array,index,array.length-index-1);
            size--;
        }
        return true;
    }

    @Override
    public Object get(int index) {
        if(indexIfLegal(index)) {
            return array[index];
        }
        return null;
    }

    @Override
    public int contains(Object data) {
        for(int i=0;i<array.length;i++){
            if(array[i]==data){
                return i;
            }
        }
        return -1;
    }

    @Override
    public Object set(int index, Object newData) {
        Object oldData=null;
        if(indexIfLegal(index)){
            oldData=array[index];
            array[index]=newData;
            return oldData;
        }
        return null;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        for(int i=0;i<array.length;i++){
            array[i]=null;
        }
        this.size=0;
    }

    @Override
    public Object[] toArray() {
        return this.array;
    }
    private boolean indexIfLegal(int index){
        if(index>=0||index<size){
            return true;
        }
        return false;

    }
     private void ifFull(int n){
        if(n-array.length>0){
            grow();
        }
     }
     private void grow(){
        int oldLength=array.length;
        int newLength=oldLength<<1;
        if(newLength-oldLength<0){
            newLength=oldLength;
        }
        if(newLength-MAX_LENGTH>0){
            newLength=MAX_LENGTH;
        }
        this.array=Arrays.copyOf(array,newLength);

     }
}
