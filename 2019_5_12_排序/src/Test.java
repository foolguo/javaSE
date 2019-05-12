/**
 * @Author: yd
 * @Date: 2019/5/12 15:41
 * @Version 1.0
 */
//排序

/*
public class Test {
    public static void main(String[] args) {
        int[] data=new int[]{2,3,1,5,3,4,6};
        //bubbleSort(data);
        //insertSort(data);
        //binaryInsertSort(data);
        //shellSort(data);
        //choiceSort(data);
        //mergeSort(data);
        quickSort(data);
        for(int i:data){
            System.out.print(i+" ");
        }

    }
    public static void bubbleSort(int[] data){
        int len=data.length;
        if(len==1){
            return;
        }else{
            for(int i=0;i<len;i++){
                boolean flag=false;
                for (int j=0;j<len-i-1;j++){
                    if(data[j]>data[j+1]){
                        swap(data,j,j+1);
                        flag=true;
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
    }
    public static void insertSort(int[] data){
        int len=data.length;
        if(len==1){
            return ;
        }else{
            for(int i=1;i<len;i++){
                int j=i-1,value=data[i];
                for(;j>=0;j--){
                    if(value<data[j]){
                        data[j+1]=data[j];
                    }else{
                        break;
                    }
                }
                data[j+1]=value;
            }
        }

    }
    public static void binaryInsertSort(int[] data){
        int len=data.length;
        if(len==1){
            return;
        }else{
            for (int i=1;i<len;i++){
                int left=0,right=i-1,value=data[i],mid=0;
                while(left<=right){
                    mid=left+(right-left)/2;
                    if(value<data[mid]){
                        right=mid-1;
                    }else{
                        left=mid+1;
                    }
                }
                int j=i-1;
                for (;j>=left;j--){
                    data[j+1]=data[j];
                }
                data[j+1]=value;
            }
        }
    }
    public static void shellSort(int[] data){
        int len=data.length;
        if (len==1){
            return;
        }else{
            for (int step=len/2;step>0;step/=2){
                for (int i=step;i<len;i++){
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
    public static void  choiceSort(int[] data){
        int len=data.length;
        if(len==1){
            return;
        }else{
            for (int i=0;i<len-i;i++){
                int min=i;
                for (int j=i+1;j<len;j++){
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
    public static void mergeSort(int[] data){
        int len=data.length;
        if(len==1){
            return;
        }else{
            mergeSortInternal(data,0,len-1);
        }
    }
    public static void mergeSortInternal(int[] data,int left,int right){
        if(left>=right){
            return;
        }else{
            int mid=left+(right-left)/2;
            mergeSortInternal(data,left,mid);
            mergeSortInternal(data,mid+1,right);
            merge(data,left,mid,right);
        }
    }
    public static void merge(int[] data ,int left,int mid,int right){
        int i=left,j=mid+1,k=0;
        int[] temp=new int[right-left+1];
        while (i<=mid&&j<=right){
            if(data[i]<=data[j]){
                temp[k++]=data[i++];
            }else{
                temp[k++]=data[j++];
            }
        }
        int start=i,end=mid;
        if(j<=right){
            start=j;
            end=right;
        }
        while(j<=right){
            temp[k++]=data[j++];
        }
        for (start=0;start<temp.length;start++){
            data[start+left]=temp[start];
        }
    }
    public static void quickSort(int[] data){
        int len=data.length;
        if(len==1){
            return;
        }else{
            quickSortInternal(data,0,len-1);
        }
    }
    public static void quickSortInternal(int[] data,int left,int right){
        if (left>=right){
            return;
        }else{
            int q=partition3(data,left,right);
            quickSortInternal(data,left,q);
            quickSortInternal(data,q+1,right);
        }
    }
    public static int partition1(int[] data,int left,int right){
        int random=(int) (Math.random()*(right-left+1))+left;
        swap(data,left,random);
        int i=left,value=data[left];
        for (int j=left+1;j<=right;j++){
            if (data[j]<value){
                swap(data,j,i+1);
                i++;
            }
        }
        swap(data,left,i);
        return  i;
    }
    public static int partition2(int[] data,int left,int right){
        int random=((int) Math.random()*(right-left+1))+left;
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
        swap(data,left,j);
        return j;
    }
    public static int partition3(int[] data,int left,int right){
        int i=left+1,lt=left,gt=right+1,value=data[left];
        while(i<gt){
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
        swap(data,left,lt);
        return left;


    }
    public static void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }

}
*/
