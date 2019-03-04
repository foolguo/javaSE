package com.Sequnence.Listlink;

/**
 * @Author: yd
 * @Date: 2019/3/4 10:01
 * @Version 1.0
 */
public interface Sequence {

    void add(Object data);
    void add(Object data,int index);
    Object removeIndex(int index);
    void removeVal(Object data);
    void cler();
    Object motify(Object newData,int index);
    void motify(Object newData,Object val);

}
