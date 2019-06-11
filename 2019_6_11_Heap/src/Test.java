/**
 * @Author: yd
 * @Date: 2019/6/11 22:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        Heap<Integer> heap=new Heap<>();
        int[] data=new int[]{12,1,6,7,4,8,9,5,10};
        for(int i=0;i<data.length;i++){
            heap.add(data[i]);
        }
        System.out.println(heap.findMax());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
        System.out.println(heap.extract());
    }
}
