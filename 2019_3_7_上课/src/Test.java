/**
 * @Author: yd
 * @Date: 2019/3/7 19:15
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        long start=System.currentTimeMillis();
        int[] data=new int[]{6,5,4,3,1,2};
//        bubbleSort(data);
        insertSort(data);
        for(int i:data){
            System.out.print(i+"  ");
        }
    }
    public static void bubbleSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{

            for(int i=0;i<n;i++){
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
    public static void insertSort(int[] array){
        int n=array.length;
        if(n<=1){
            return ;
        }else{
                for(int i=1;i<n;i++){
                    int temp=array[i];
                    int j=i-1;
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
}
