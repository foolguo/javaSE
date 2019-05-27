import java.util.Arrays;
import java.util.Scanner;
import java.util.Stack;

/**
 * @Author: yd
 * @Date: 2019/5/24 10:54
 * @Version 1.0
 */
//神奇袋子：
//动态规划：上一步的动作对下一步产生影响
//创建一个二维数组，
/*public class Test{
    public static void main(String[] args) {
        Scanner scanner=new Scanner(System.in);
        int n=scanner.nextInt();
        int[] a=new int[n+1];
        int k=1;
        while(k<=n){
            a[k++]=scanner.nextInt();
        }
        int[][] dp=new int[n+1][41];
        for (int i=0;i<=n;i++){
            dp[i][0]=1;
        }
        for (int i=1;i<=n;i++){
            for (int j=1;j<=40;j++){
                dp[i][j]=dp[i-1][j];
                if(j>=a[i]){
                    dp[i][j]+=dp[i-1][j-a[i]];

                }

            }
        }
        System.out.println(dp[n][40]);
    }

}*/

//两个栈实现一个链表

//
//public class Test{
//    Stack<Integer> stack1=new Stack<>();
//    Stack<Integer> stack2=new Stack<>();
//    public void push(int i){
//        stack1.push(i);
//    }
//    public int pop(){
//        while(!stack1.isEmpty()){
//            stack2.push(stack1.pop());
//        }
//       return stack2.pop();
//
//    }
//    public static void main(String[] args) {
//        Test t=new Test();
//        t.push(1);
//        t.push(2);
//        t.push(3);
//        System.out.println(t.pop());
//    }
//}

