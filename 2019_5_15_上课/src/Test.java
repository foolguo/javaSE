import java.util.concurrent.*;

/**
 * @Author: yd
 * @Date: 2019/5/15 23:57
 * @Version 1.0
 */
class MyThread implements Callable {

    @Override
    public String call() throws Exception {
        System.out.println(Thread.currentThread().getName()+"开始");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"结束");
        return "执行完毕";
    }
}
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<String>(new MyThread());
        ExecutorService executorService=Executors.newFixedThreadPool(5);
        for (int i=0;i<5;i++){
            executorService.submit(new MyThread());


        }
        String str=futureTask.get();
        System.out.println(str);

    }
}
