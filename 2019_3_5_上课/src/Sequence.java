/**
 * @Author: yd
 * @Date: 2019/3/5 17:22
 * @Version 1.0
 */
public interface Sequence {
    void add(Object data);
   // void add(Object data,int index);
    Object remote(Object data);
    Object remote(Object data,int index);
    //删除指定元素
    Object get(int index);
    void set(int index,Object newNode);
    Object remoteDate(Object data);
    void clear();
    int getSize();


}
