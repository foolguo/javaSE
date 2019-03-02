/**
 * @Author: yd
 * @Date: 2019/3/2 16:27
 * @Version 1.0
 */
public class Test {
    public static void main(String[] args) {
        int[] data=new int[]{2,1,4,3,6,5};
        shellSort(data);
    }
    public static void shellSort(int[] data){
        int N=data.length;
        for(int gap=N/2;gap>0;gap/=2){
            for(int i=gap;i<data.length;i++){
                int temp=data[i],j=i-gap;
                for(;j>=0&&temp<data[j];j-=gap){
                    data[j+gap]=data[j];
                }
                data[j+gap]=temp;
            }
        }
    }
}
