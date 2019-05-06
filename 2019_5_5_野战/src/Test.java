/**
 * @Author: yd
 * @Date: 2019/5/5 23:03
 * @Version 1.0
 */
/*
public class Test {
    public static void main(String[] args) {
        int[] data=new int[]{4,2,1,3,7,6,5};
        //mergeSort(data);
        quickSort(data);
        for (int i:data){
            System.out.println(i+" ");
        }
    }
    public static void quickSort(int[] data){
        int len=data.length;
        if (len==1){
            return;
        }else{
            quickSortInternal(data,0,len-1);
        }
    }
    public static void quickSortInternal(int[] data,int left,int right){
        if (left>=right){
            return;
        }else {
            int q=partition3(data,left,right);
            quickSortInternal(data,left,q);
            quickSortInternal(data,q+1,right);
        }
    }
    //随机选择快排
    public static int partition1(int[] data,int left,int right){
        int j=left;
        int value=data[left];
        for (int i=left+1;i<=right;i++){
            if (data[i]<value){
                swap(data,i,j+1);
                j++;
            }
        }
        swap(data,j,left);
        return j;
    }
    public static int partition2(int[] data,int left,int right){
       int random=(int) (Math.random()*(right-left+1))+left;
        //System.out.println(random);
        swap(data,left,random);
        int i=left+1,j=right,value=data[left];
        while (i<=j){
            while(i<=right&&data[i]<value)i++;
            while(j>=left+1&&data[j]>value)j--;
            if(i>j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,j,left);
        return j;
    }
    public static  int partition3(int[] data,int left,int right){
        int i=left+1,lt=left,gt=right+1;
        int value=data[left];
        while (i<gt){
            if (value>data[i]){
                swap(data,i,lt+1);
                i++;
                lt++;
            }else if(value<data[i]){
                swap(data,i,gt-1);
                gt--;
            }else {
                i++;
            }
        }
        swap(data,lt,left);
        return lt;
    }
    public static void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }



    public static void mergeSort(int[] data){
        int len=data.length;
        if(len==1){
            return ;
        }else{
            mergeSortInternal(data,0,len-1);
        }
    }
    public static void mergeSortInternal(int[] data,int left,int right){
        if(left>=right){
            return;
        }
        int mid=left+(right-left)/2;
        mergeSortInternal(data,left,mid);
        mergeSortInternal(data,mid+1,right);
        merge(data,left,right,mid);
    }
    public static void merge(int[] data,int left,int right,int mid){
        int i=left,j=mid+1,k=0;
        int[] temp=new int[right-left+1];
        while(i<=mid&&j<=right){
            if(data[i]<=data[j]){
                temp[k++]=data[i++];
            }else{
                temp[k++]=data[j++];
            }
        }
        int start = i,end=mid;
        if(j<=right){
            start=j;
            end=right;
        }
        while(start<=end){
            temp[k++]=data[start++];
        }
        for(start=0;start<temp.length;start++){
            data[left+start]=temp[start];
        }
    }
}
*/

/