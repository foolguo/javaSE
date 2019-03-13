/**
 * @Author: yd
 * @Date: 2019/3/13 18:43
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
        int q=partition2(array,l,r);
        quickSortInternal(array,l,q-1);
        quickSortInternal(array,q+1,r);
    }

    /**
     * 分区点选取方法
     * @param array
     * @param l
     * @param r
     * @return  返回已经到达最终位置的下标
     */
    public static int partition(int[] array,int l,int r){
        //二路快排
         //arr[1+1......j]<v    arr[j+1.....i-1]>v
        //返回下标为l……r的任意一个数
        int randomIndex=(int)(Math.random()*(r-l+1)+l);
        swap(array,l,randomIndex);
        int j=l,i=l+1;
        int value=array[l];
        //将数组分成两个区间，array[1+1....i-1]<v   array[i.....r]>=v
        for(;i<=r;i++){//该区间是大于v的区间
            //依次向后遍历，如果 大于v的区间里有小于v的区间
            if(value>array[i]){
                //交换
                swap(array,j+1,i);
                j++;
            }
        }
        //这一次交换将基准值与小于v的最后一个元素交换
        swap(array,l,j);
        return j;

    }
    public static int partition2(int[] array,int l,int r){
        //如果一个数组是近乎有序的数组,如果选择最左边的元素为基准点，
        // 分割的次数就会进乎与n，排序算法退化成O（n^2），
        //当数组中重复元素过多，也会将与基准元素相同的元素放到基准元素的右边

        //优化 二路快排  ， 一个向后，一个向左
        int randomIndex=(int) (Math.random()*(r-l+1))+l;
        swap(array,l,randomIndex);
        int i=l+1,j=r;
        int value=array[l];
        while(true){
            while(value>array[i]&&i<=r) i++;
            while(value<array[j]&&j>=l) j--;
            if(i>j){
                break;
            }
            swap(array,i,j);
        }
        swap(array,l,j);
        return j;
    }
    public static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
