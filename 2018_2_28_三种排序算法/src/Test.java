////冒牌排序
//
///*public class Test {
//    public static void main(String[] args) {
//        int[] array=new int[]{5,4,3,2,1};
//        int flag=0;
//        for(int i=0;i<array.length-1;i++){//外层控制循环个数
//            for(int j=0;j<array.length-1-i;j++){//相邻两个元素相比较
//                if(array[j]>array[j+1]){
//                    int temp=array[j];
//                    array[j]=array[j+1];
//                    array[j+1]=temp;
//                    flag=1;
//                }
//            }
//            if(flag==0){
//                break;
//            }
//        }
//        for (int i:array
//             ) {
//            System.out.print(i+" ");
//        }
//    }
//}*/

//选择排序

/*public class Test {
    public static void main(String[] args) {
        int[] array=new int[]{7,3,4,8,6};
        for(int i=0;i<array.length-1;i++){
            int min=0;
            for(int j=i+1;j<array.length;j++){
                if(array[i]>array[j]){
                    min=j;
                }
            }
            if(min!=i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }
        for(int i:array){
            System.out.print(i+" ");
        }*/
//       /* for(int i=0;i<data.length-1;i++){
//            int n=0;
//            for(int j=i+1;j<data.length;j++){
//                if(data[i]>data[j]){
//                    n=j;
//                }
//            }
//            int tmp=data[n];
//            data[n]=data[i];
//            data[i]=tmp;
//        }
//        for (int i:data
//                ) {
//            System.out.print(i+" ");
//   }   */
  /*  }
}*/

//public class Test {
//    //测试
//    public static void main(String[] args) {
//        // TODO Auto-generated method stub
//        int[] a = {2,5,1,7,4,3,6};
//        sort(a);
//    }
//    //排序
//    public static void sort(int[] a){
//        //双重循环，依次比较大小
//        for(int i = 0;i<a.length-1;i++){
//            for(int j = i+1;j<a.length;j++){
//                if(a[j]<a[i]){
//                    int tmp = a[j];
//                    a[j] = a[i];
//                    a[i] = tmp;
//                }
//            }
//        }
//        for(int i = 0;i<a.length;i++){
//            System.out.println(a[i]);
//        }
//    }
//}


/*public class Test {
    public static void main(String[] args) {
        int[] a = {2,5,1,7,4,3,6};
        sort(a);
    }

    public static void sort(int[] array){
        int minI = 0;

*//*        for(int i = 0;i<a.length-1;i++){
            minI = i;
            for(int j = i+1;j<a.length;j++){
                if(a[j]<a[minI]){
                    minI = j;
                }
            }
            if(minI!=i){
                int tmp = a[minI];
                a[minI] = a[i];
                a[i] = tmp;
            }
        }*//*
        for(int i=0;i<array.length-1;i++){
            int min=i;
            for(int j=i+1;j<array.length;j++){
                if(array[min]>array[j]){
                    min=j;
                }
            }
            if(min!=i) {
                int temp = array[min];
                array[min] = array[i];
                array[i] = temp;
            }
        }

        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}*/

//插入排序，将第一个数当做一个序列 ，向里面插入数字
public class Test{
    public static void main(String[] args) {
        int[] a = {2,5,1,7,4,3,6};
        for(int i=1;i<a.length;i++){
            int temp=a[i];
            int j=i;
            while(j>0&&a[j-1]>temp){
                a[j]=a[j-1];
                j--;
            }
            a[j]=temp;
        }
        for(int i:a){
            System.out.print(i+" ");
        }
    }
}