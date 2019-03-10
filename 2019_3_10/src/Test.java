/**
 * @Author: yd
 * @Date: 2019/3/10 9:16
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[]  array={1,5,7,9,8,2,3,4};
        //binbarySort(array);
      //  shellSort(array);
        mergeSort(array);
        for(int i:array){
            System.out.print(i+" ");
        }
    }
    //折半插入排序
    //1 5 7 9 8 2 4 3
    public static void binbarySort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=1;i<n;i++){
                int low=0;
                int high=i-1;
                int value=array[i];
                while(low<=high){
                    int mid=low+(high-low)/2;
                    if(value<array[mid]){
                        high=mid-1;
                    }else{
                        low=mid+1;
                    }
                }
                int j=i-1;
                for(;j>=high+1;j--){
                    array[j+1]=array[j];
                }
                array[j+1]=value;
            }
        }
    }
    public static void shellSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            int step=n/2;
            for(;step>=1;step/=2){
                for(int i=step;i<n;i++){
                    int value=array[i];
                    int j=i-step;
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
    public static  void mergeSort(int[] array){
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
        int mid=(high-low)/2+low;
        mergeInternal(array,low,mid);
        mergeInternal(array,mid+1,high);
        merge(array,low,mid,high);

    }
private static void merge(int[] array,int p,int q,int r){
        int i=p,j=q+1;
        int[] temp=new int[r-p+1];
        int k=0;
        while(i<=q&&j<=r){
            if(array[i]<=array[j]){
                temp[k++]=array[i++];
            }else{
                temp[k++]=array[j++];
            }
        }
        int start=i;
        int end=q;
        if(j<=r){
            start=j;
            end=r;
        }
        while(start<=end){
            temp[k++]=array[start++];
        }
        for(int k2=0;k2<temp.length;k2++){
           array[k2+p]= temp[k2];
        }

}

}
