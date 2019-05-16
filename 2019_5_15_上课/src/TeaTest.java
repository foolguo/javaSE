import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author: yd
 * @Date: 2019/5/15 19:09
 * @Version 1.0
 */
/*class T1 implements Callable<String>{
    private FutureTask<String> futureTask;
    public T1(FutureTask futureTask) {
        this.futureTask = futureTask;
    }
    @Override
    public String call() throws Exception {
        System.out.println("道水");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("烧开水");
        TimeUnit.SECONDS.sleep(15);
        String str=futureTask.get();
        System.out.println(str);
        return "泡茶";
    }
}
class T2 implements Callable{
    @Override
    public Object call() throws Exception {
        System.out.println("洗茶杯");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("洗茶壶");
        TimeUnit.SECONDS.sleep(1);
        System.out.println("取茶叶");
        TimeUnit.SECONDS.sleep(3);
        return "龙井";
    }
}
public class TeaTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
            FutureTask futureTask2=new FutureTask(new T2());
            FutureTask futureTask1=new FutureTask(new T1(futureTask2));
            new Thread(futureTask1).start();
            new Thread(futureTask2).start();
            String str= (String) futureTask1.get();
            System.out.println(str);

    }
}*/


/*
* 如何使用读写锁来实现一个缓存：
* */

