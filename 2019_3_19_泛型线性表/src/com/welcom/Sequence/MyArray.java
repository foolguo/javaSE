package com.welcom.Sequence;

/**
 * @Author: yd
 * @Date: 2019/3/19 10:41
 * @Version 1.0
 */
public class MyArray implements Sequence {

    @Override
    public void add(Object data) {

    }

    @Override
    public boolean remove(int index) {
        return false;
    }

    @Override
    public Object get(int index) {
        return null;
    }

    @Override
    public boolean contains(Object data) {
        return false;
    }

    @Override
    public Object set(int index, Object newData) {
        return null;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public void clear() {

    }

    @Override
    public Object[] toArray() {
        return new Object[0];
    }
}
