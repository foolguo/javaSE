/**
 * @Author: yd
 * @Date: 2019/6/15 15:16
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        BST<Integer> bst=new Binary_Tree<>();
        int[] num={12,35,43,54,32,14};
        for (int i:num){
            bst.add(i);
        }
        bst.inOrder();
        System.out.println();
        bst.removeMin();
        bst.inOrder();
        bst.removeNode(54);
        System.out.println();
        bst.inOrder();
    }
}
