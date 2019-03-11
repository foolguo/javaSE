/**
 * @Author: yd
 * @Date: 2019/3/11 17:17
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array=new int[]{8,2,4,1,5,3,6,7};
        //bubbleSort(array);
        //insertaSort(array);
        //binarySort(array);
//        shellSort(array);
      //  mergeSort(array);
        //    choiceSort(array);
          quickSort(array);
        for (int i:
             array) {
            System.out.print(i+" ");
        }
    }
    public static void bubbleSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for (int i=0;i<n;i++){
                int flag=0;
                for(int j=0;j<n-i-1;j++){
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
    public static void insertaSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            //外侧循环表示待排序区间
            for(int i=1;i<n;i++){
                int j=i-1,temp=array[i];
                //已排序区间，目的是将待排序区间的第一个数temp插入进去
                for(;j>=0;j--){
                    //如果temp小于已排序空间最后一个数，将该数向后移动一位
                    if(temp<array[j]){
                        array[j+1]=array[j];
                    }else{
                        //否则退出循环，说明已经找到位置
                        break;
                    }
                }
                //j+1就是找到的位置，因为在退出循环之前，一定是和插入位置的前一个位置进行比较，此时j是前一个位置的下标，所以插入位置是j+1
                array[j+1]=temp;
            }
        }
    }
         public static void binarySort(int[] array){
            int n=array.length;
            if(n<=1){
                return ;
            }else{
                for(int i=1;i<n;i++){
                    int low=0,high=i-1;
                    int temp=array[i];
                    while(low<=high){
                        int mid=low+(high-low)/2;
                        if(temp<array[mid]){
                            high=mid-1;
                        }else{
                            low=mid+1;
                        }
                    }
                    int j=i-1;
                    for(;j>=high+1;j--){
                        array[j+1]=array[j];
                    }
                    array[high+1]=temp;

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
                        int j=i-step,temp=array[i];
                        for(;j>=0;j-=step){
                            if(temp<array[j]){
                                array[j+step]=array[j];
                            }else{
                                break;
                            }
                        }
                        array[j+step]=temp;
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
                        for (int j=i;j<n;j++){
                            if(array[min]>array[j]){
                                min=j;
                            }
                        }
                        if(min!=i){
                            int temp=array[i];
                            array[i]=array[min];
                            array[min]=temp;
                        }
                    }
                }
         }
         public static void mergeSort(int[] array){
            int n=array.length;
            if(n<=1){
                return ;
            }else{
                mergeInternal(array,0,n-1);
            }
         }
         private static void mergeInternal(int[] array,int low,int high){
            if(low<=high){
                return ;
            }
            int mid=low+(high-low)/2;
            mergeInternal(array,low,mid);
            mergeInternal(array,mid+1,high);
            merge(array,low,mid,high);
         }
         private static void merge(int[] array,int low,int mid,int high){
                int i=low,j=mid+1,k=0;
                int[] temp=new int[high-low+1];
                while(i<=mid&&j<=high){
                    if(array[i]<=array[mid]){
                        temp[k++]=array[i++];
                    }
                    if(array[j]<=array[mid]){
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
                for(start=0;start<temp.length;start++){
                    array[start+low]=temp[start++];
                }
         }
         public static void quickSort(int[] array){
            int n=array.length;
            if(n<=1){
                return ;
            }else{
                quick(array,0,array.length-1);
            }
         }
         private static void quick(int[] array,int low, int high){
                if(low>=high){
                    return ;
                }
                int j=partition(array,low,high);
                quick(array,low,j-1);
                quick(array,j+1,high);


         }
         private  static int partition(int[] array,int low,int high){
                int i=low,j=high+1;
                int set=array[i];
                while(true){
                    while(set>array[++i]){
                        if(i==high){break;}
                    }
                    while(set<array[--j]){
                        if(j==low){
                            break;
                        }
                    }
                    if(i>=j){
                        break;
                    }
                    int temp=array[i];
                    array[i]=array[j];
                    array[j]=temp;
                }
                int temp=array[low];
                array[low]=array[j];
                array[j]=temp;
                return j;
         }
}
