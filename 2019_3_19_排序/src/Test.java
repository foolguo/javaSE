/**
 * @Author: yd
 * @Date: 2019/3/19 16:38
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array=new int[]{4,3,6,2,1,7,8};
       shellSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    public static void bubbleSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=0 ; i<n;i++){
                int flag=0;
                for(int j=0;j<n-1;j++){
                    if(array[j]>array[j+1]){
                        int temp=array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                        flag=1;
                    }
                }
                if(flag==0){
                    break;
                }
            }
        }
    }
    public static void insertSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=1;i<n;i++){
                int value=array[i];
                int j=i-1;
                while(j>=0&&array[j]>value){
                    array[j+1]=array[j];
                    j--;
                }
                array[j+1]=value;
            }
        }
    }
    public static void binaryInsertSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=1;i<n;i++){
                int left=0,right=i-1;
                int value=array[i];
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(array[mid]>value){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
                //1 2 4 5 7 3
                int j=i-1;
                for(;j>=right+1;j--){
                    array[j+1]=array[j];
                }
                array[right+1]=value;
            }
        }
    }
    public static void shellSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int step=n/2;step>0;step/=2){
                for(int i=step;i<n;i++){
                    int j=i-step,value=array[i];
                    while(j>=0&&array[j]>value){
                        array[j+step]=array[j];
                        j-=step;
                    }
                    array[j+step]=value;
                }
            }
        }
    }
    public static void choiceSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=0;i<n-1;i++){
                int min=i;
                for(int j=i+1;j<n;j++){
                    if(array[min]>array[j]){
                        min=j;
                    }
                }
                if(min!=i){
                    int temp=array[min];
                    array[min]=array[i];
                    array[i]=temp;
                }
            }
        }
    }
    public static void mergeSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            mergeSortInternal(array,0,n-1);
        }
    }
    private static void mergeSortInternal(int[] array,int l,int h){
        if(l>=h){
            return;
        }
        int mid=l+(h-l)/2;
        mergeSortInternal(array,l,mid);
        mergeSortInternal(array,mid+1,h);
        merge(array,l,mid,h);
    }
    private static void merge(int[] array,int l,int mid,int h){
        if(array[mid]<array[mid+1]){
            return ;
        }
        int[] temp=new int[h-l+1];
        int i=l,j=mid+1,k=0;
        while(i<=mid&&j<=h){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                temp[k++]=array[j++];
            }
        }
        int start=i,end=mid;
        if(j<=h){
            start=j;
            end=h;
        }
        while(start<=end){
            temp[k++]=array[start++];
        }
        for(k=0;k<temp.length;k++){
            array[l+k]=temp[k];
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
    private static void quickSortInternal(int[] array,int l,int h){
        if(l>=h){
            return ;
        }
        int q=partition2(array,l,h);
        quickSortInternal(array,l,q-1);
        quickSortInternal(array,q+1,h);
    }
    private static int partition1(int[] array,int l,int h){
        int random=(int) (Math.random()*(h-l+1)+l);
        swap(array,l,random);
        int value=array[l];
        int j=l;//<value;
        int i=l+1;//>value;
        for(;i<array.length;i++){
            if(array[i]<value){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,l,j);
        return j;
    }
    private  static int partition2(int[] array,int l,int h){
        int random=(int) (Math.random()*(h-l+1)+l);
        swap(array,l,random);
        int i=l+1,j=h;
        int value=array[l];
        while(i<=j){
            while(i<=h&&array[i]<value)i++;
            while(j>=l+1&&array[j]>value)j--;
            if(i>j){
                break;
            }
            swap(array,i,j);
        }
        swap(array,l,j);
        return j;
    }
    private static int partition3(int[] array,int l,int h){
        int random=(int) (Math.random()*(h-l+1)+l);
        swap(array,l,random);
        int value=array[l];
        int gt=l,lt=h+1,i=l+1;
        //arr[l+1,gt]<value   arr[gt+1,i-1]  arr[lt,h]
        while(i<lt){
            if(array[i]<value){
                swap(array,gt+1,i);
                gt++;
                i++;
            }else if(array[i]>value){
                swap(array,lt-1,i);
                lt--;
            }else{
                i++;
            }
        }
        swap(array,gt,l);
        return gt;
    }
    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }
}
