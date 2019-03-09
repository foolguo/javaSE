/**
 * @Author: yd
 * @Date: 2019/3/9 10:35
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] array=new int[]{5,4,3,2,1};
     //   bubbleSort(array);
       // insertSort(array);
        //shellSort(array);
        //choiceSort(array);
        quickSort(array,0,array.length-1);
        for(int i:array){
            System.out.print(i+"、");
        }
    }
    public static void bubbleSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
            for(int i=0;i<n;i++){
                boolean flag=false;
                for(int j=0;j<n-i-1;j++){
                    if(array[j]>array[j+1]){
                        int temp=array[j];
                        array[j]=array[j+1];
                        array[j+1]=temp;
                        flag=true;
                    }
                }
                if(!flag){
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
            for(int i=0;i<n;i++){
                int j=i-1,temp=array[i];
                for(;j>=0;j--){
                    if(temp<array[j]){
                        array[j+1]=array[j];
                    }else{
                        break;
                    }
                }
                array[j+1]=temp;
            }
        }
    }
    public static void  shellSort(int[] array){
        int N=array.length;
        if(N<=1){
            return ;
        }else {
            //控制增量
            for (int gap = N / 2; gap > 0; gap = gap / 2) {
                //每组内部排序
                for (int i = gap; i < N; i++) {
                    //进行插入排序
                    insert(array,gap);

                }
            }
        }
    }
    public static void insert(int[]array,int gap){
        for(int i=gap;i<array.length;i+=gap){
            int j=i-gap,temp=array[i];
            for(;j>=0;j-=gap){
                if(temp<array[j]){
                    array[j+gap]=array[j] ;
                }else{
                    break;
                }
            }
            array[j+gap]=temp;
        }
    }
    public static void choiceSort(int[] array){
        //将当前元素与其后面的全速进行比较，如果比他小，，将其下标方到min中，
        //找到最小的，将其余当前元素交换
        int N=array.length;
        for (int i=0;i<N-1;i++){
            int min=i;
            for(int j=i;j<N;j++){
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
    public static void quickSort(int[] array,int low,int high){
        if(low<high){
            int index=part(array,low,high);
            quickSort(array,low,index-1);
            quickSort(array,index+1,high);

        }
    }
    public  static  int  part(int[] array,int low,int high){
        int i=low,j=high+1;
        int flag=array[low];
        while(true){
            while(array[++i]<flag){
                if(i==high){
                    break;
                }
            }
            while(array[--j]>flag){
                if(j==low){
                    break;
                }
            }
            if(i>=j){break;}
            swap(array,i,j);
        }
        swap(array,low,j);
        return j;

    }
    public  static void swap(int[]array,int i, int j){
        int temp=array[i];
        array[i]=array[j];
        array[j]=temp;
    }

}
