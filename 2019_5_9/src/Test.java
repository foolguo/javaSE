/**
 * @Author: yd
 * @Date: 2019/5/10 13:29
 * @Version 1.0
 */

/*
* 排序：
* 内部排序和外部排序：
* 内部排序分为4中类型：
* 1.交换思想的排序：冒泡排序，快速排序
* 2.选择思想的排序：选择排序,堆排序
* 3.插入排序：直接插入排序，希尔排序
* 4.归并排序
*
 *
  * 验证一个算法好坏的指标：
  * 1.时间复杂度；
  * 2.空间复杂度
  * 3.原地排序
  *
  * */


public class Test {
    public static void main(String[] args) {
        int[] data=new int[]{1,4,2,4,7,5,6,3};
       // bubbleSort(data);
        //insertSort(data);
        //hellSort(data);
        //binarySort(data);
        //choice(data);
        //mergeSort(data);
        quickSort(data);
        for(int i:data){
            System.out.println(i+" ");
        }
    }
    /*
    * 算法的执行效率：
    * 最好时间复杂度：O（n），最坏O（n^2）
    * 低阶系数
    * 比较和移动的次数：
    * 内存消耗：
    * 原地排序：O（1）
    * 稳定排序：稳定
    * */
    public static void bubbleSort(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            int count=0;
            for(int i=0;i<n;i++){
                boolean flag=false;
                for(int j=0;j<n-i-1;j++){
                    if(data[j]>data[j+1]){
                     swap(data,j,j+1);
                     flag=true;
                    }
                    count++;
                }
                if(!flag){
                    break;
                }
            }
            System.out.println(count);
        }
    }
    /*
    * 1.算法的执行效率：
    * 最好时间复杂度O（n），只有待插入的元素比有序序列中的最后一个元素大，说明，有序，
    * 如果待排列序列已经有序，就相当于从前向后遍历一遍；
    * 最坏时间复杂度（o(n^2)）
    * 2.原地排序
    * 3.稳定排序
    * */
    public static void insertSort(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            //两块区域：1.未排序，2.有序
            for (int i=1;i<n;i++){
                int j=i-1,value=data[i];
                for (;j>=0;j--){
                    if(data[j]>value){
                        data[j+1]=data[j];
                    }else{
                        break;
                    }
                }
                data[j+1]=value;
            }
        }
    }
    /*
    * 折半插入排序
    *
    * */
    public static void binarySort(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            for (int i=1;i<n;i++){
                int left=0,right=i-1,value=data[i];
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(value<data[mid]){
                        right=mid-1;
                    }else {
                        left=mid+1;
                    }
                }
                int j=i-1;
                for(;j>=left;j--){
                    data[j+1]=data[j];
                }
                data[j+1]=value;

            }


        }
    }

    /*
    * 希尔排序：
    * 将序列分组，每一组按照插入排序来排序，
    *  时间复杂度O（nlogn）
    *   空间复杂度   原地排序
    *   不稳定排序：
    * */
    public static void  shellSort(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            for(int step=n/2;step>0;step=step/2){
                for (int i=step;i<n;i++){
                    int j=i-step,value=data[i];
                    for (;j>=0;j-=step){
                        if(value<data[j]){
                            data[j+step]=data[j];
                        }else {
                            break;
                        }
                    }
                    data[j+step]=value;
                }
            }

        }
    }
    public static void choice(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            for (int i=0;i<n-1;i++){
                int min=i;
                for (int j=i+1;j<n;j++){
                    if(data[min]>data[j]){
                        min=j;
                    }
                }
                if(min!=i){
                    swap(data,min,i);
                }
            }

        }
    }
    /*
    * 归并排序O(nlogn)
    * */
    public static void mergeSort(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            mergeInternal(data,0,n-1);
        }
    }
    private static void mergeInternal(int[] data,int low,int hight){
        if(low>=hight){
            return;
        }else{
            int mid=low+(hight-low)/2;
            mergeInternal(data,low,mid);
            mergeInternal(data,mid+1,hight);
            merge(data,low,mid,hight);
        }
    }
    private static void merge(int[] data,int low,int mid,int height){
        int i=low,j=mid+1,k=0;
        int[] temp=new int[height-low+1];
        while(i<=mid&&j<=height){
            if(data[i]<=data[j]){
                temp[k++]=data[i++];
            }else{
                temp[k++]=data[j++];
            }
        }
        int start=i,end=mid;
        if(j<=height){
            start=j;
            end=height;
        }
        while(start<=end){
            temp[k++]=data[start++];
        }
        for (start=0;start<temp.length;start++){
            data[start+low]=temp[start];
        }
    }
    public static void quickSort(int[] data){
        int n=data.length;
        if(n==1){
            return;
        }else{
            quickInternal(data,0,n-1);
        }
    }
    private static void quickInternal(int[] data,int low,int height){
        if(low>=height){
            return;
        }else {
            int q=partition2(data,low,height);
            quickInternal(data,low,q);
            quickInternal(data,q+1,height);
        }
    }
    private static int partition1(int[] data,int low,int height){
        int radom=(int)(Math.random()*(height-low+1))+low;
        swap(data,radom,low);
        int j=low,value=data[low];
        for (int i=low+1;i<data.length;i++){
            if(data[i]<value){
                swap(data,i,j+1);
                j++;
            }
        }
        swap(data,low,j);
        return j;
    }
    public static int partition(int[] data,int low,int height){
        int i=low+1,j=height;
        int value=data[low];
        while (i<=j){
            while(i<=height&&data[i]<value)i++;
            while (j>=low+1&&data[j]>value)j--;
            if (i>j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,low,j);
        return j;
    }
    private static int partition2(int[] data,int low,int height){
        int i=low+1,lt=low,gt=height+1;
        int value=data[low];
        while (i<gt){
            if(data[i]<value){
                swap(data,i,lt+1);
                i++;
                lt++;
            }else if(data[i]>value){
                swap(data,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(data,low,lt);
        return lt;
    }
    private static void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}
