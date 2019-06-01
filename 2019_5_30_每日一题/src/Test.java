import java.util.*;
public class Main{
    public static void main(String[] args){
        Scanner in=new Scanner(System.in);
        int N=in.nextInt();
        int a=0,b=1;
        while(b<N){
            int temp=b;
            b=a+b;
            a=temp;
        }
        if((N-a)<=(b-N)){
            System.out.println(N-a);
        }else{
            System.out.println(b-N);
        }
    }
}



import java.util.*;
public class Robot {
    public int countWays(int x, int y) {
        int[][] dp=new int[x][y];
        for(int i=1;i<x;i++){
            dp[i][0]=1;
        }
        for (int j=1;j<y;j++){
            dp[0][j]=1;
        }
        for(int i=1;i<x;i++){
            for (int j=1;j<y;j++){
                dp[i][j]=dp[i-1][j]+dp[i][j-1];
            }
        }
        return dp[x-1][y-1];
    }
}