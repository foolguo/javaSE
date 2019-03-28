package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/28 9:46
 * @Version 1.0
 */
public interface Sequence<T> {
    public void add(T data) ;
    public boolean remove(int index) ;
    public T get(int index) ;
    public boolean contains(Object data);
    public T set(int index, T newData) ;
    public int size();
    public void clear() ;
    public Object[] toArray() ;
}
