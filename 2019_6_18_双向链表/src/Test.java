/**
 * @Author: yd
 * @Date: 2019/6/18 20:29
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        DoubleLinkList<Integer> list=new DoubleLinkList<>();
        list.addFirst(1);
        list.addFirst(2);
        list.addFirst(3);
        list.addFirst(4);
        list.addFirst(5);
       System.out.println(list.get(3));
        System.out.println(list.remove(2));
    }
}
