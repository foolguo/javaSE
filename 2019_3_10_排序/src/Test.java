/**
 * @Author: yd
 * @Date: 2019/3/10 17:14
 * @Version 1.0
 */

/**
 * 1.冒泡排序
 * 2.插入排序
 * 3.直接插入排序
 * 4.希尔排序
 * 5.选择排序
 * 6.归并排序
 */
public class Test {
    public static void main(String[] args) {
        int[] array=new int[]{1,5,7,9,8,2,3,4};
        // bubbleSort(array);
        // insertSort(array);
         //   binarySort(array);
        //choice(array);
        mergeSort(array);
        sortHelper.printArray(array);
    }

    /**
     * 冒泡排序：
     * 分析算法：
     * 1.时间复杂度：最好最坏都是O（n^2）,因为无论如何内部循环都要走一遍
     *              但是交换次数多，
     * 2.空间复杂度：O（1）  原地排序  循环时因为没有开辟新空间
     * 3.稳定性：稳定排序，只有大于前一个元素的数据才会交换
     * @param array
     */

    public static void bubbleSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            //控制比较次数
            for(int i=0;i<n;i++){
                boolean flag=false;//设定标签进行排序算法的优化；
                //相邻两个数组进行比较
                for(int j=0;j<n-i-1;j++){
                    if(array[j]>array[j+1]){
                        int temp=array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                        flag=true;
                    }
                }
                if(!flag){//表示一次都没有交换，说明数组本身就有序，结束排序
                    break;
                }
            }
        }
    }

    /**
     * 插入排序；
     * 1.时间复杂度：最好O（n）, 最坏O（n^2）
     * 2.空间复杂度：O（1）原地排序
     * 3.稳定性，稳定排序
     * @param array
     */
    public static void  insertSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            //外侧循环代表的是无序数组
            for(int i=1;i<n;i++){
                int value=array[i];//将无序数组的第一个值保存起来
                int j=i-1;//有序数组最后一个元素的下标
                //查找 value 应该插入的位置
                for(;j>=0;j--){
                    //如果value比最后一个元素小，j向后移一个
                    if(value<array[j]){
                        array[j+1]=array[j];
                    }else{
                        //表示比比较的元素大结束循环
                        break;
                    }
                }
                //插入位置为 j+1
                array[j+1]=value;
            }
        }
    }

    /**
     * 折半插入排序：对直接插入排序的优化
     * 主要是在查找插入位置的时候，用了二分查找的思想
     *
     * 时间复杂度：O（n）
     * 空间复杂度：O（1）
     * 稳定性：稳定排序
     *
     * @param array
     */
    public static void binarySort(int[] array) {
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=1;i<array.length;i++){
                int low=0,high=i-1;
                int value=array[i];
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(array[mid]<value){
                        low=mid+1;
                    }else{
                       high=mid-1;
                    }
                }
                int j=i-1;
                for(;j>=high+1;j--){
                    array[j+1]=array[j];
                }
                array[high+1]=value;


            }
        }


    }

    /**
     * 希尔排序：
     * 思想：
     * 将一个序列以step步 分成若干个子区间
     * 让没个子区间有序
     * 减小划分步骤重复上述两步，至间隔为1，这时序列基本有序，进行直接插入排序，
     *
     * 时间复杂度：太过复杂，不知道
     * 空间复杂度 O（1）
     * 稳定性： 原地排序
     * @param array
     */

    public static void shellSort(int[] array){
        int n=array.length;
        if(n<=1){
            return;
        }else{
            //进行分组
            for(int step=n/2;step>0;step/=2){
                //将每一组进行排序
                for(int i=step;i<n;i++){
                    int j=i-step;
                    int value=array[i];
                    for(;j>=0;j-=step){
                        if(array[j]>value){
                            array[j+step]=array[j];
                        }else{
                            break;
                        }
                    }
                    array[j+step]=value;
                }
            }
        }
    }

    /**
     * 选择排序，将区间分为有序和无须的两部分
     * 找到序列中最小值插入有序数组的最后，每次排序都会有一个值到到他的位置上
     * 1.时间复杂度 O（n^2）
     * 2.空间复杂度 O（1）
     * 3.稳定不， 不稳定   2 5 2 1 3   第一次排序  1 5 2 2 3  两个相同的元素相对位置改变
     * @param array
     */
    public static void choice(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=0;i<n-1;i++){
                int min=i;
                for(int j=i;j<n;j++){
                    if(array[min]>array[j]){
                        min=j;
                    }
                }
                if(i!=min){
                    int temp=array[i];
                    array[i]=array[min];
                    array[min]=temp;
                }
            }
        }
    }

    /**
     * 归并排序：
     * 时间复杂度  O（nlogn)
     * 空间复杂度O（n）
     * 稳定，排序
     * @param array
     */
    public static void mergeSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            mergeInternal(array,0,array.length-1);
        }
    }
    private static void mergeInternal(int[] array,int low,int high){
        if(low>=high){
            return ;
        }
        int mid=low+(high-low)/2;
        mergeInternal(array,low,mid);
        mergeInternal(array,mid+1,high);
        merge(array,low,mid,high);
    }
    //合并
    private static void merge(int[] array,int low,int mid,int high){
        int i=low,j=mid+1,k=0;
        int[] temp=new int[high-low+1];
        while(i<=mid&&j<=high){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                temp[k++]=array[j++];
            }
        }
        int start=i,end=mid;
        if(j<=high){
            start=j;
            end=high;
        }
        while(start<=end){
            temp[k++]=array[start++];
        }
        for(int n=0;n<temp.length;n++){
            array[n+low]=temp[n];
        }
    }
}
