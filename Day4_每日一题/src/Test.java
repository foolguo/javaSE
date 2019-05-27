import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/23 16:48
 * @Version 1.0
 */

//买水果问题  看那个可以  8盒一个 6盒一个 看那个可以包装最小  但一定要买到指定个数
/*public class Test{
    public static void main(String[] args) {
        *//*Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();*//*
        int count=0;
        int n=20;
        if(n<6){
            System.out.println(-1);
            return;
        }
        print(n);

    }
    //如果剩下的数和8相加是6的最小公倍数或
    public static void print(int n){
        int count=0;
        while(n!=0){
            count+=n/8;
            n=n%8;
            if(n==6){
                count++;
                System.out.println(count);
                break;
            }else if((n+8)%6==0){
                count+=1;
                System.out.println(count);
                break;
            }else{
                System.out.println(-1);
            }

        }
    }
}*/


//删除第一个序列中所有第二个序列的元素
public class Test{
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        String str1=in.nextLine();
        String str2=in.nextLine();
        int[] a=new int[str1.length()];
        char[] c1=str1.toCharArray();
        char[] c2=str2.toCharArray();
        StringBuffer c=new StringBuffer();
        for(int i=0;i<c1.length;i++){
            for (int j=0;j<c2.length;j++){
                if(c1[i]==c2[j]){
                    a[i]=1;
                }
            }
        }
        for(int i=0;i<c1.length;i++){
            if(a[i]==0){
                c.append(c1[i]);
            }
        }
        System.out.println(c);
    }

}
