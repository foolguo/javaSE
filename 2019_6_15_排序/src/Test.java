import java.util.Random;

/**
 * @Author: yd
 * @Date: 2019/6/15 15:53
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] num={3,2,6,5,1,4,9,8,7};
       // bubbleSort(num);
        //insert(num);
       // shellSort(num);
        //binarySotr(num);
        //mergeSort(num);
        //choice(num);
        //heapSort(num);
        quickSort(num);
        for(int i:num){
            System.out.print(i+" ");
        }
    }
    public static void quickSort(int[] num){
        if(num.length==1){
            return;
        }else{

            quickSortInternal(num,0,num.length-1);
        }
    }
    private static void quickSortInternal(int[] num,int l,int r){
        if(l>=r){
            return;
        }
        int q=partition3(num,l,r);
        quickSortInternal(num,l,q-1);
        quickSortInternal(num,q+1,r);

    }
    private static int partition3(int[] num,int l,int r){
        int radom=(int) (Math.random()*(r-l+1))+l;
        swap(num,l,radom);
        int i=l, lt=l,gt=r+1,value=num[i];
        while (i<gt){
            if(value>num[i]){
                swap(num,i,lt+1);
                i++;
                lt++;
            }else if(value<num[i]){
                swap(num,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(num,l,lt);
        return lt;
    }
    private static int partition2(int[] num,int l,int r){
        int radom=(int) (Math.random()*(r-l+1))+l;
        swap(num,l,radom);
        int i=l+1,j=r,value=num[l];
        while(i<=j){
            while(i<=r&&num[i]<value) i++;
            while (j>=l+1&&num[j]>value) j--;
            if(i>j){
                break;
            }
            swap(num,i,j);
            i++;
            j--;
        }
        swap(num,l,j);
        return j;

    }
    private static int partition1(int[] num,int l,int r){
        int radom=(int) (Math.random()*(r-l+1))+l;
        swap(num,l,radom);
        int i=l+1,j=l,value=num[j];
        for(;i<=r;i++){
            if(num[i]<value){
                swap(num,j+1,i);
                j++;
            }
        }
        swap(num,j,l);
        return j;
    }



    public static void binarySotr(int[] num){
        if (num.length==1) {
            return;
        }else {
            for(int i=1;i<num.length;i++){
                int left=0,right=i-1,value=num[i];
                while(left<=right){
                    int mid=left+(right-left)/2;
                    if(num[mid]>value){
                        right=mid-1;
                    }
                    if(num[mid]<value){
                        left=mid+1;
                    }
                }
                int j=i-1;
                for (;j>=right+1;j--){
                    num[j+1]=num[j];
                }
                num[right+1]=value;
            }
        }
    }
    public static void bubbleSort(int[] num){
        if (num.length==1){
            return;
        }else{
            for(int i=0;i<num.length;i++){
                boolean flag=false;
                for (int j=0;j<num.length-i-1;j++){
                    if(num[j]>num[j+1]){
                        swap(num,j,j+1);
                        flag=true;
                    }
                }
                if(!flag){
                    break;
                }
            }
        }
    }

    public static void insert(int[] num){
        if (num.length==1) {
            return;
        }else{
            for(int i=1;i<num.length;i++){
                int j=i-1,value=num[i];
                for(;j>=0;j--){
                    if(value<num[j]){
                        num[j+1]=num[j];
                    }else{
                        break;
                    }
                }
                num[j+1]=value;
            }
        }
    }
    public static void shellSort(int[] num) {
        if (num.length == 1) {
            return;
        }else{
            for(int step=num.length/2;step>0;step/=2){
                for (int i=step;i<num.length;i++){
                    int j=i-step,value=num[i];
                    for (;j>=0;j-=step){
                        if(value<num[j]) {
                            num[j + step] = num[j];
                        }
                        else {
                            break;
                        }
                    }
                    num[j+step]=value;

                }
            }
        }
    }
    public static void mergeSort(int[] num) {
        if (num.length == 1) {
            return;
        }else {
            mergeInternal(num,0,num.length-1);

        }
    }
    private static void mergeInternal(int[] num,int l,int r){
        if(l>=r){
            return;
        }
        int mid=(r-l)/2+l;
        mergeInternal(num,l,mid);
        mergeInternal(num,mid+1,r);
        merge(num,l,r,mid);
    }
    private static void merge(int[] num,int l,int r,int mid){
        int i=l,j=mid+1,k=0;
        int[] temp=new int[r-l+1];
        while (i<=mid&&j<=r){
            if(num[i]<=num[j])
                temp[k++]=num[i++];
            else{
                temp[k++]=num[j++];
            }
        }
        int start=i,end=mid;
        if(j<=r){
            start=j;
            end=r;
        }
        while(start<=end){
            temp[k++]=num[start++];
        }
        for(start=0;start<temp.length;start++){
            num[start+l]=temp[start];
        }
    }
    public static  void choice(int[] num){
        if(num.length==1){
            return;
        }else{
            for (int i=0;i<num.length-1;i++){
                int min=i;
                for(int j=i+1;j<num.length;j++){
                    if(num[min]>num[j]){
                        min=j;
                    }
                }
                if(min!=i){
                    swap(num,min,i);
                }
            }
        }
    }
    public static void heapSort(int[] num){
        if(num.length==1){
            return;
        }else{
            for(int i=(num.length-1-1)/2;i>=0;i--){
                shitDown(num,num.length,i);
            }
            for(int i=num.length-1;i>=0;i--){
                swap(num,i,0);
                shitDown(num,i,0);
            }



        }
    }
    private static void shitDown(int[] num,int len,int k){
        while(2*k+1<len){
            int j=2*k+1;
            if (j+1<len){
                if(num[j]<num[j+1]){
                    j=j+1;
                }
            }
            if(num[j]<num[k]){
                break;
            }
            swap(num,j,k);
            k=j;
        }
    }

    public static void swap(int[] arr,int i,int j){
        int temp=arr[i];
        arr[i]=arr[j];
        arr[j]=temp;
    }
}
