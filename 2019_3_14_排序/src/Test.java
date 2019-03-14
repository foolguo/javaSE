/**
 * @Author: yd
 * @Date: 2019/3/14 18:56
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array=new int[]{3,2,4,1,8,5,7};
        quickSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }

    /**
     * 快速排序
     * @param array
     */
    public static void quickSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{

            quickSortInternal(array,0,n-1);

        }
    }
    public static void quickSortInternal(int[] array,int l,int r){
        if(l>=r){
            return ;
        }else{
            int q=partition3(array,l,r);//一次分割后 基准点一定在它的最终位置上
            quickSortInternal(array,l,q-1);
            quickSortInternal(array,q+1,r);

        }


    }
    private static int partition(int[] array,int l,int r){
        int value=array[l];//基准值的选取
        //array[l+1……j]<value的区间，刚开始时 此区间没有元素，所以j初始值为l
        int j=l;
        //arra[j+1……i-1]>value的区间，刚开始时也没有元素,但是开始也一定在l+1,在基准值之后
        int i=l+1;
        for(;i<=r;i++){
            if(value>array[i]){
                swap(array,j+1,i);//j是<value的最后一个元素，所以只能和j+1进行交换,小于value的空间扩大一个
                j++;//将j的下标向后移一个
            }
        }
        swap(array,j,l);//此时全部<value 的空间一定在<=j的区间里，
        return j;

    }
    private static int partition2(int[] array,int l,int r){
        int randomIndex=(int) (Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int j=l,i=l+1,value=array[l];
        for(;i<=r;i++){
            if(array[i]<value){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,j,l);
        return j;

    }


    private static int partition3(int[] array,int l,int r){
        int randomIndex=(int) (Math.random()*(r-l+1)+l);
        swap(array,randomIndex,l);
        //array[l+1……i]<value     array[j……r]>value
        int i=l+1,j=r,value=array[l];
        while(true){
            while(array[i]<value&&i<=r)i++;
            while(array[j]>value&&j>=l)j--;
            if(i>j){
                break;
            }
            swap(array,i,j);
          i++;
          j--;
        }
        swap(array,j,l);
        return j;

    }
    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
