package com.learned;

/**
 * @Author: yd
 * @Date: 2019/3/17 20:21
 * @Version 1.0
 */
public class p implements IMessage {
    @Override
    public Object print() {
        return null;
    }
}
class I implements IMessage<String>{
    @Override
    public String print() {
        return null;
    }
}
class F<T> implements IMessage<T>{
    @Override
    public T print() {
        return null;
    }
}