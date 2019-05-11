import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @Author: yd
 * @Date: 2019/5/11 11:26
 * @Version 1.0
 */
/*
* CountDownLatch
* */

/*class Task implements Runnable{
    private CountDownLatch downLatch;
    public Task(CountDownLatch downLatch) {
        this.downLatch = downLatch;
    }
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        downLatch.countDown();
    }
}
public class Test {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch countDownLatch=new CountDownLatch(4);
        System.out.println("比赛开始");
        for (int i=0;i<4;i++){
            new Thread(new Task(countDownLatch),"运动员"+(i+1)).start();
        }
        countDownLatch.await();
        System.out.println("比赛结束");
    }
}*/

/*
*
* CyclicBarrier
* */
//class Task implements Runnable{
//    private CyclicBarrier cyclicBarrier;
//
//    public Task(CyclicBarrier cyclicBarrier) {
//        this.cyclicBarrier = cyclicBarrier;
//    }
//    @Override
//    public void run() {
//        System.out.println(Thread.currentThread().getName()+"正在写入数据");
//        try {
//            Thread.sleep(1000);
//            System.out.println(Thread.currentThread().getName()+"写入数据完毕");
//            cyclicBarrier.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        } catch (BrokenBarrierException e) {
//            e.printStackTrace();
//        }
//        System.out.println("所有线程均写入完毕，继续执行其他任务...");
//    }
//}
//
//public class Test{
//    public static void main(String[] args) {
//        CyclicBarrier cyclicBarrier=new CyclicBarrier(4, new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("当前线程名称："+Thread.currentThread().getName());
//            }
//        });
//        ExecutorService executorService= Executors.newFixedThreadPool(4);
//        for (int i=0;i<4;i++){
//            executorService.submit(new Thread(new Task(cyclicBarrier)));
//        }
//        executorService.shutdown();
//    }
//}

/*public class Test{
    private static int num=0;
    public static void main(String[] args) {
        try {
            print();
        }finally {
            System.out.println("栈的深度"+num);
        }
    }
    public static void print(){
        num++;
        print();
    }
}*/
/*
public class Test{
    static class OOMObject{}
    public static void main(String[] args) {
        List<OOMObject> list=new ArrayList<>();
            while(true){
                list.add(new OOMObject());
            }
    }
}
*/

public class Test{
    private Object instance=null;
    public static void main(String[] args) {
        Test test1=new Test();
        Test test2=new Test();
        test1.instance=test2;
        test2.instance=test1;
        test1=null;
        test2=null;
        System.gc();
    }
}