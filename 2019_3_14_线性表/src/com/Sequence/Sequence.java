package com.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/14 20:38
 * @Version 1.0
 */
public interface Sequence {
    public void add(Object data) ;
    public boolean remove(int index) ;
    public Object get(int index) ;
    public boolean contains(Object data);
    public Object set(int index, Object newData) ;
    public int size();
    public void clear() ;
    public Object[] toArray() ;
}
