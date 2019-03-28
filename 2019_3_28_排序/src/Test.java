/**
 * @Author: yd
 * @Date: 2019/3/28 11:22
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] data={2,3,1,5,4,8,6,7};
        quickSort(data);
        for(int i:data){
            System.out.print(i+" ");
        }
    }
    public static void bubbleSort(int[] data){
        int n=data.length;
        if(n<=1){
            return ;
        }else{
            /**
             * 基于交换思想的排序
             * 两两比较 小的放前面，大的放后面
             */
            for(int i=0;i<n;i++){
                int flag=0;
                for(int j=0;j<n-i-1;j++){
                    if (data[j]>data[j+1]){
                        int temp=data[j];
                        data[j]=data[j+1];
                        data[j+1]=temp;
                        flag=1;
                    }
                }
                if(flag==0){
                    break;
                }
            }
        }
    }
    public void insertSort(int[] data) {
        int n = data.length;
        if (n <= 1) {
            return;
        } else {
            /**
             * 基于插入思想的排序，将数组分为有序的和无序的，
             * 每次将无序数组的第一个插入有序数组的中，
             */
            for (int i = 1; i < n; i++) {
                int j=i-1;//有序数组最后一个元素；
                int value=data[i];//待插入的元素
                for(;j>=0;j--){
                    if(value<data[j]){
                        data[j+1]=data[j];
                    } else{
                        break;
                    }
                }
                data[j+1]=value;
            }
        }
    }
    public  static void binarySort(int[] data){
        int n=data.length;
        if(n<=1) {
            return;
        }else{
            for(int i=1;i<n;i++){
                int low=0,high=i-1;
                int value=data[i];
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(value<data[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                int j=i-1;
                for(;j>=high+1;j--){
                    data[j+1]=data[j];
                }
                data[j+1]=value;

            }

        }
    }
    public static void shellSort(int[] data){
        int n=data.length;
        if(n<=1){
            return ;
        }else{
            for(int step=n/2;step>0;step/=2){
                for(int i=step;i<n;i++){
                    int j=i-step,value=data[i];
                    for(;j>=0;j-=step){
                        if(value<data[j]){
                            data[j+step]=data[j];
                        }else{
                            break;
                        }
                    }
                    data[j+step]=value;
                }
            }
        }
    }
    public static void choice(int[] data){
        int n = data.length;
        if (n<=1){
            return ;
        }else{
            for(int i=0;i<n-1;i++){
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
    private static void swap(int[] data,int min,int i){
        int temp=data[min];
        data[min]=data[i];
        data[i]=temp;
    }
    public static void mergeSort(int[] data){
        int n = data.length;
        if (n<=1){
            return ;
        }else{
            mergeSortInternal(data,0,n-1);
        }
    }
    private static void mergeSortInternal(int[] data,int low,int high){
        if(low>=high){
            return ;
        }
        int mid=low+(high-low)/2;
        mergeSortInternal(data,low,mid);
        mergeSortInternal(data,mid+1,high);
        merge(data,low,mid,high);
    }
    private static void merge(int[]data,int low,int mid,int high){
        if(data[mid]<data[mid+1]){
            return ;
        }
        int i=low,j=mid+1;
        int[] temp=new int[high-low+1];
        int k=0;
        while(i<=mid&&j<=high){
            if(data[i]<=data[j]){
                temp[k++]=data[i++];
            }else{
                temp[k++]=data[j++];
            }
        }
        int start=i,end=mid;
        if(j<=high){
            start=j;
            end=high;
        }
        while(start<=end){
            temp[k++]=data[start++];
        }
        for(start=0;start<temp.length;start++){
            data[start+low]=temp[start];
        }
    }
    public static void quickSort(int[] data){
        int n=data.length;
        if(n<=1){
            return ;
        }else{
            quickSortIntern(data,0,n-1);
        }
    }
    private static void quickSortIntern(int[] data,int low,int high){
        if(low>=high){
            return ;
        }
        int q=partition3(data,low,high);
        quickSortIntern(data,low,q-1);
        quickSortIntern(data,q+1,high);

    }
    private static int partition1(int[] data,int low,int high){
        int random=(int)(Math.random()*(high-low+1)+low);
        swap(data,low,random);
        int j=low,i=low+1;
        int value=data[j];
        for(;i<data.length;i++){
            if(value>data[i]){
                swap(data,j+1,i);
                j++;
            }
        }
        swap(data,low,j);
        return j;
    }
    private static int partition2(int[] data,int low,int high){
        int random=(int)(Math.random()*(high-low+1)+low);
        swap(data,low,random);
        int value =data[low];
        int i=low+1,j=high;
        while(i<=j){
            while(data[i]<value&&i<=high)i++;
            while(data[j]>value&&i>=low+1) j--;
            if(i>j){
                break;
            }
            swap(data,i,j);
            i++;j--;
        }
        swap(data,j,low);
        return j;
    }
    private static int partition3(int[] data,int low,int high){
        int random=(int)(Math.random()*(high-low+1)+low);
        swap(data,low,random);
        int value=data[low];
        int lt=low,gt=high+1,i=low+1;
       while(i<gt){
            if(value>data[i]){
                swap(data,lt+1,i);
                lt++;
                i++;
            }else if(value<data[i]){
                swap(data,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(data,low,lt);
       return lt;
    }
}
