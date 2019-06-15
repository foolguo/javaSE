/**
 * @Author: yd
 * @Date: 2019/6/15 13:50
 * @Version 1.0
 */
public interface BST<E> {
    void add(E e);
    boolean contains(E e);
    E findMax();
    E findMin();
    void removeMax();
    void removeMin();
    void removeNode(E e);
    void isEmpty();
    int size();
    void inOrder();


}
