/**
 * @Author: yd
 * @Date: 2019/3/15 17:14
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array={3,2,5,1,2,8,6};
        choiceSort(array);
        for (int i:array){
            System.out.print(i+" ");
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
                    int temp=array[i];
                    array[i]=array[min];
                    array[min]=temp;
                }
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
                    int j=i-step;
                    int temp=array[i];
                    for(;j>=0;j-=step){
                        if(array[j]>temp){
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
    public static void bianarySort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=1;i<n;i++){
                int l=0,r=i-1;
                int temp=array[i];
                while(l<=r){
                    int mid=l+(r-l)/2;
                    if(array[mid]<=temp){
                        l=mid+1;
                    }else{
                        r=mid-1;
                    }
                }
                int j=i-1;
                for(;j>=l;j--){
                    array[j+1]=array[j];
                }
                array[l]=temp;

            }


        }

    }
    public static void insertSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }
        for(int i=1;i<array.length;i++){
            int j=i-1,temp=array[i];
            for(;j>=0;j--) {
                if (temp< array[j]) {
                    array[j + 1] = array[j];
                }else{
                    break;
                }
            }
            array[j+1]=temp;
        }
    }
    /**
     * 快速排序的三种方法
     * @param array
     */
    public static void quickSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            quickSortInternal(array,0,n-1);
        }
    }

    /**
     * 按照分区点分割数组
     * @param array
     * @param l
     * @param h
     */
    private static void quickSortInternal(int[] array,int l,int h) {
        long start=System.currentTimeMillis();
         if(h-l<=15){
            //调用直接插入排序
            insertSort(array,l,h);
            return;
         }
        int q=partition4(array,l,h);
        quickSortInternal(array,l,q-1);
        quickSortInternal(array,q+1,h);
        long end=System.currentTimeMillis();
        System.out.println("耗时"+(end-start+1)+"毫秒");
    }
    //插入排序
    private static void insertSort(int[] array,int l,int h){
        for(int i=l+1;i<=h;i++){
            int j=i-1,temp=array[i];
            for(;j>=l;j--){
                if(temp<array[j]){
                    array[j+1]=array[j];
                }
                else{
                    break;
                }
            }
            array[j+1]=temp;
        }

    }
    private static int partition(int[] array,int l,int h){

        //以第一个元素为分区点
        int value=array[l];
        //array[l+1,j]<value,j为小于value的最后一个元素的下标
        int j=l;//此时小于value的空间还没有，所以j是l
        //array[j+1,i-1] ，此时大于Value的空间还没有，所以
        int i=l+1;
        for(;i<=h;i++){
            if(array[i]<value){
                swap(array,j+1,i);
                j++;//此时小于value的元素增加一个，向左扩充
            }
        }
        swap(array,l,j);
        return  j;
    }
    //为了避免数组有序，算法时间复杂度退化成O（n^2）
    private static int partition2(int[] array,int l,int h){
        int randomIndex=(int) (Math.random()*(h-l+1)+l);
        swap(array,l,randomIndex);
        int value=array[l];
        int j=l,i=l+1;
        for(;i<=h;i++){
            if(array[i]<value){
                swap(array,j+1,i);
                j++;
            }
        }
        swap(array,j,l);
        return  j;
    }
    private static int partition3(int[] array,int l,int h){
        int randomIndex=(int) (Math.random()*(h-l+1)+l);
        swap(array,l,randomIndex);
        int i=l+1,j=h;
        int value=array[l];
        while(true){
            while(array[i]<value&&i<=h)i++;
            while(array[j]>value&&j>=l+1)j--;//一定是l+1,因为l+1是<value数组的第一个元素
            if(i>j)break;
            swap(array,i,j);
            i++;
            j--;
        }
        swap(array,j,l);
        return j;
    }
    private static int partition4(int[] array,int l,int h){

        //三路快排
        int value=array[l];
        //array[l+1,lt]<value
        int lt=l;
        //array[gt,r]>value
        int gt=h+1;//从后向前遍历,这时，>value的空间一个都没有，所以是h+1
        //array[lt+1,i-1]==value
        int i=l+1;//从中间元素开始排序
        while(i<gt){
            if(array[i]<value){
                swap(array,lt+1,i);
                lt++;
                i++;
            }else if(array[i]>value){
                swap(array,gt-1,i);
                gt--;
            }else{
                i++;
            }
        }
        swap(array,l,lt);

        return gt;


    }
    private static void swap(int[] array,int i,int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

    public static void mergeSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            mergeInternal(array,0,n-1);
        }
    }
    private static void mergeInternal(int[] array,int l,int h){
        if(l>=h){
            return ;
        }
        //进行分割 ，并且每一次是以最终间的值均等分割  所以分割次数固定为 log n
        int mid=l+(h-l)/2;
        mergeInternal(array,l,mid);
        mergeInternal(array,mid+1,h);
        //合并的过程
        merge(array,l,mid,h);
    }
    private static void merge(int[] array,int l,int mid,int h){
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
        for(start=0;start<temp.length;start++){
            array[start+l]=temp[start];
        }
    }
}
