/**
 * @Author: yd
 * @Date: 2019/3/13 22:45
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array={3,2,5,4,1,6,8};
        quickSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
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
        }
        int q=partition3(array,l,r);
        quickSortInternal(array,l,q-1);
        quickSortInternal(array,q+1,r);
    }
    private static int partition(int[] array,int l,int r){
        int j=l,i=l+1,value=array[l];
        for(;i<=r;i++){
            if(array[i]<value){
                swap(array,j+1,i);//交换不能交换已经是<value的元素，所以交换的是她后面的元素
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }
    //但是上面的算法会有一个问题，就是如果排列的是一个近乎有序的数组，
    //分割的次数就会接近为n，时间复杂度退化成 O（n^2）;
    private static int partition2(int[] array,int l,int r){
        int randomIndex=(int) (Math.random()*(l-r+1))+l;
        swap(array,l,randomIndex);
        int j=l;//表示小于value 的序列，
        int i=l+1;//表示大于value的序列
        int value=array[l];
        for(;i<=r;i++){
            if(value>array[i]){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }
    private static int partition3(int[] array,int l,int r){
        int randomIndex=(int) (Math.random()*(r-l))+l;
        swap(array,l,randomIndex);
        int i=l+1,j=r,value=array[l];
        while(true){
            while (i<=r&&value>array[i])i++;
            while(j>=l&&value<array[j])j--;
            if(j<i){
                break;
            }
            swap(array,i,j);
        }
        swap(array,j,l);
        return j;
    }



    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
