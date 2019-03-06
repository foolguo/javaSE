/**
 * @Author: yd
 * @Date: 2019/3/5 17:22
 * @Version 1.0
 */
public interface Sequence {
    void add(Object data);
    void add(Object data,int index);
    Object remote(int index);
    Object get(int index);
    void set(int index,Object newNode);
    void remoteDate(Object data);
    void clear();
    int getSize();


}
