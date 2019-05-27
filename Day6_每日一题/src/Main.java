import java.awt.image.SampleModel;
import java.util.LinkedList;
import java.util.concurrent.*;

/**
 * @Author: yd
 * @Date: 2019/5/24 20:50
 * @Version 1.0
 */
// 本题为考试单行多行输入输出规范示例，无需提交，不计分。
/*import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        while (in.hasNextInt()) {// 注意，如果输入是多个测试用例，请通过while循环处理多个测试用例
            int n1=in.nextInt();
            int n2=in.nextInt();
            int n3=in.nextInt();
            int n4=in.nextInt();
            int A=0,B=0,C=0;
            if((n3-n1)!=(n4+n2)&&(n3-n1)<0&&(n3-n1)%2 !=0){
                System.out.print("No");
                return ;
            }
            B=(n3-n1)/2;

            if((n3-B)!=(n1+B)&&(n3-B)<0){
                System.out.print("No");
                return;
            }
            A=n3-B;
            if((n4-B)!=(B-n2)&&(n4-B)<0){
                System.out.print("No");
                return ;
            }
            C=n4-B;
            if((A-n1)!=(n4-C)){
                System.out.print("No");
                return ;
            }
            System.out.print(A+" ");
            System.out.print(B+" ");
            System.out.print(C);
            return ;

        }
    }
}*/
/*

import java.util.ArrayList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner in=new Scanner(System.in);
        int[] count=new int[10];
        int n=0;
        while(in.hasNext()){
            count[in.nextInt()]++;
            n++;
        }

        for(int i=0;i<count.length;i++){
            if(count[i]>=n/2){
                System.out.print(i);

            }
        }
    }
}*/
/*
class Factory implements Runnable{
    private Semaphore s;

    public Factory(Semaphore s) {
        this.s = s;
    }

    @Override
    public void run() {

        try {
            s.acquire();
            System.out.println(Thread.currentThread().getName()+"使用设备");
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"结束");
            s.release();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }
}
public class Main{
    public static void main(String[] args) {
        Semaphore s=new Semaphore(5);
        Factory factory=new Factory(s);
        for(int i=0;i<8;i++){
            new Thread(factory).start();
        }

    }


}*/

//CountDownLatch
/*
class MyThread implements Runnable{
    private CountDownLatch countDownLatch;

    public MyThread(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+"跑完");
        countDownLatch.countDown();
    }
}
public class Main{
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch c=new CountDownLatch(5);
        MyThread myThread=new MyThread(c);
        System.out.println("比赛开始");
        for(int i=0;i<5;i++){
            new Thread(myThread,"运动员"+('A'+i)).start();
        }
        c.await();
        System.out.println("比赛结束");
    }
}*/
class MyThread implements Runnable{
    private CyclicBarrier cyclicBarrier;

    public MyThread(CyclicBarrier cyclicBarrier) {
        this.cyclicBarrier = cyclicBarrier;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName()+"开始写书");
        try {
            TimeUnit.SECONDS.sleep(1);
            System.out.println(Thread.currentThread().getName()+"写完");
            cyclicBarrier.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (BrokenBarrierException e) {
            e.printStackTrace();
        }finally {
            System.out.println("出版");
        }
    }
}
public class Main{
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier=new CyclicBarrier(3);
        MyThread myThread=new MyThread(cyclicBarrier);
        for(int i=0;i<3;i++){
            new Thread(myThread,"作家"+(i+1)).start();
        }
        LinkedList

    }
}