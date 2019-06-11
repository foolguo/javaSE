/**
 * @Author: yd
 * @Date: 2019/6/11 23:05
 * @Version 1.0
 */
public class HeapSort {
    Heap<Integer> heap=new Heap();
    public void heapSort1(int[] arr){
        for (int i=0;i<arr.length;i++){
            heap.add(arr[i]);
        }
        for (int i=arr.length-1;i>=0;i--){
            arr[i]=heap.extract();
        }
    }
    //原地堆排序
    public void heapSort(int[] arr){
        //先将数组整成一个堆
        int len=arr.length;
        for(int i=(len-1-1)/2;i>=0;i--){
            //shiftDown 交换对顶元素和最后一个元素
            shitDown(arr,len,i);
        }
        //先将第一个位置的元素和最后一个交换，然后再将剩余元素整成堆
        for (int i=len-1;i>=0;i--){
            swap(arr,i,0);
            shitDown(arr,i,0);
        }

    }
    private void shitDown(int[] arr,int n,int k){
        while(2*k+1<n){
            int j=2*k+1;
            if(j+1<n) {
                if (arr[j] < arr[j + 1]) {
                    j = j + 1;
                }
            }
            if(arr[k]>arr[j]){
                break;
            }
            swap(arr,k,j);
            k=j;


        }
    }
    private void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }

    public static void main(String[] args) {
        int[] arr=new int[]{2,3,1,5,4,8,7,6};
        HeapSort heapSort=new HeapSort();
        heapSort.heapSort(arr);
        for(int i=0;i<arr.length;i++){
            System.out.print(arr[i]+" ");
        }

    }
}
