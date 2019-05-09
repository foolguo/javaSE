import java.util.concurrent.*;

/**
 * @Author: yd
 * @Date: 2019/5/8 23:35
 * @Version 1.0
 */
/*

线程和进程：
进程：程序执行的一个周期就叫做一个进程操作系统中资源调度的最小单位
线程：进程中的一个任务，是任务调度的最小单元

如何创建一个线程：
继承Thread：是一个具体的子类，有继承局限，其本身是Runnable的子类
继承Runnable：是Thread的父接口，但是线程启动还是要实现start
继承Callable：juc包下的接口，主要是可以返回信息   会阻塞别的线程执行，当自己的线程调度完成才会释放
让别的线程执行
线程池：（推荐使用线程池）
    线程池的优点：
        1.降低资源消耗：复用已有线程降低创建和销毁线程带来的资源消耗
        2.提高响应速度：任务不需要创建新的就可以直接执行
        3.提高线程池的可管理性：可对线程进行统一的掉读监视和销毁
    ExecutorService：（基本线程池核心接口）
    ScheduleExecutorServicer（周期性调度线程池接口）
    子类：
    ThreadPoolExecutor
    ScheduleThreadPoolExecutor

    有一个工具方法，Executors  实际上在底层创建线程池
    固定大小线程池：newFixThreadPool
    单线程池：newSingleThreadExecutor
    缓存线程池：newCatchThreadPool
多线程的几种重要方法：
    sleep（线程休眠）：运行到阻塞，不释放锁，立即交出CPU，到了指定的时间恢复执行。
    如果在线程休眠过程中另一个线程没有执行完成 咋办，
    yiled：线程让步，从运行到调度，不释放锁，不立即交出CPU，什么时候恢复执行系统调度
    join：等待线程终止，在那个线程掉用哪个线程就交出锁并且等待调用其的线程执行完毕，然后
    在恢复执行，是wait方法的包装方法

    给有无关系的两个资源上锁：
    1.查余额 存钱
    2.查密码 改密码
    上两把不同的锁
    给有关系的两个资源上锁
    1.线程1.存钱
      线程2/取钱
    JDK1.6之后对内建锁的优化:
    自适应自旋，锁粗化，锁消除，偏向锁，轻量级锁
    CAS：比较交换机制（V,O,N）V实际内存的值，O期待值，N要替换的值，
    如果V=O，说明该线程上次修改值后没有别的线程访问该锁，将N替换回去，否则
    说明上次该线程修改值后有别的线程访问，不能修改返回V值，并不断自旋尝试修改值

    自适应自旋，如果上次自旋获取到对象锁，那么这次就自旋长一些，如果没有，这次就自旋的短
    一些。
    CAS问题：1.ABA问题。int i=1， 线程1:1—>2  :  线程2:2—1，线程三不能修改
                解决 加一个版本号，juc包下atomic
              2.自旋带来的消耗问题， :自适应自旋
              3.不公平：处于自旋状态的线程总是先获取到锁

     锁粗化：如果同一个对象一直在连续的上锁解锁，就会将其整合在一起加解锁一次
     锁消除：如果要加锁的对象是线程私有的，系统判定该对象没有必要加锁（线程是安全的），
     就锁消除
     偏向锁：任何时间只有一个线程尝试获取锁。
      偏向锁的获取：线程进入同步代码块，先看线程栈帧中的锁记录存放的是不是自己的线程ID，如果是则直接
     进入同步代码块，如果不是看偏向锁字段是否为0，如果为0，呢么说明当前没有线程持有锁，CAS替换
     ,如果为1，说明当前有线程正在持有锁，不断自旋尝试获取锁（JD6之后默认开启偏向锁）
        偏向锁撤销：偏向锁的撤销条件比较高，必须要等到全局安全点（当前没有任何有用的指令集）
        每撤销一次，Epoch+1到了40，说明该锁不适合做偏向锁，升级为轻量级锁
      轻量级锁：不同时刻有不同锁尝试获取线程，基本不存在竞争
      轻量级锁的获取，在对象头中的MarkWord复制到线程用于存放锁记录的栈帧中，称为displaceMarkword
     再尝试使用CAS将对象头的markword替换成指向该线程的指针，如果成功，说明获取到锁，如果失败，存在锁竞争
     直接膨胀成重量级锁。

     对象锁的monitor机制：
     在线程进入同步代码块是要执行monitorenter在退出同步代码块要执行monitorexit。
     线程获取对象锁实际上就是获取对象的Monitor监视器，只有获取Monitor监视器程序才可以向下执行，这个过程是
     互斥的。
     执行enter 首先要看计数器是否为0，如果为0，说明当前没有线程获取锁，将锁持有线程替换成自己的，否则说明
     还有对象获取锁，看看当前锁持有线程是不是自己的，如果是，计数器加1，如果不是，（JDK1.6之后自旋获取偏向锁）
     在锁释放的时候，执行exit 知道计数器减为0，才可以锁成功释放

     wait和notify
     wait()死等，如果不被唤醒一直等下去
     wait(long Nanos,TimeUnit unit)  到了一等时间恢复执行
     wait()多例纳秒级别的控制
     notify()唤醒处于等待队列的线程
     notifyAll()唤醒所有处于等待的线程
     生产消费者模型：
     生产者消费者不直接通信，通过一个阻塞队列信（流水线）
*/
/*
public class Test {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+"开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"开始");

            }
        });
        FutureTask futureTask=new FutureTask(new Callable() {
            @Override
            public String call() throws Exception {
                System.out.println(Thread.currentThread().getName()+"开始");
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName()+"开始");
                return "haha";
            }
        });
        thread1.start();
        new Thread(futureTask).start();
        String msg= (String) futureTask.get();
        System.out.println(msg);

    }
}
*/

/*
class Sync implements Runnable{
    @Override
    public void run() {
        Sync sync=new Sync();
        try {
            test1();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    public synchronized void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"开始");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}

public class Test{
    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Thread(new Sync()).start();
        }
    }
}*/
/*
class MyThread implements Callable{

    @Override
    public String call() throws Exception {
        MyThread myThread=new MyThread();
        test1();
        return "haha";
    }
    public synchronized void test1() throws InterruptedException {
        System.out.println(Thread.currentThread().getName()+"开始");
        Thread.sleep(1000);
        System.out.println(Thread.currentThread().getName()+"结束");
    }
}

public class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        for (int i=0;i<3;i++){
            FutureTask futureTask=new FutureTask(new MyThread());
            new Thread(futureTask).start();
            System.out.println(futureTask.get());
        }

    }
}*/
/*
*标志位中断线程
* */
/*
class Sync implements Runnable{
    private volatile boolean flag=true;
    @Override
    public void run() {
        int i=0;
        while(flag){
        */
/*    try{
                Thread.sleep(1000);
                System.out.println("第"+i+"次执行，线程名称为："+Thread.currentThread().getName());
                i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*

            System.out.println("第"+i+"次执行，线程名称为："+Thread.currentThread().getName());
            i++;

        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}

public class Test{
    public static void main(String[] args) throws InterruptedException {
        Sync sync=new Sync();
        for(int i=0;i<3;i++) {
            new Thread(sync, "线程" + i).start();
        }
        //new Thread(sync,"线程2").start();
        Thread.sleep(5000);
        sync.setFlag(false);
        System.out.println("代码结束");
    }
}
*/

/*
class MyThread implements Runnable{
    private boolean flag=true;
    @Override
    public void run() {
        int i=1;
        while(flag){
            try {
                if(i==10) {
                    Thread.sleep(1000);
                }
   boolean bool=Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("非阻塞情况下执行该操作。。。线程状态"+bool);
                    break;
                }

                System.out.println("第"+i+"次执行，线程名称为："+Thread.currentThread().getName());
                if(i==10){
                    break;
                }
                i++;

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Test{
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread,"子线程A");
        thread.start();
        thread.interrupt();
        //thread.interrupt();
        System.out.println("代码结束");
    }
}
*/

/*
* 代码验证interrupted方法的情况：
* 1.线程处于阻塞状态，调用interrupted()方法让线程退出阻塞状态，抛出异常 中断标志位被重新设置成false
* 2.线程处于非阻塞状态，这时调用interrupted将标志位设置成true，一旦调用了wait，join sleep，
* 就会抛出异常，中断标志位设置为false
*
*
* interrupted方法不会让线程终止，只是改变其中断状态而已，给受阻塞的线程发出一个中断状态，这样
* 其就可以退出阻塞状态
*
* */
/*
class MyThread implements Runnable{
    private boolean flag=true;

    @Override
    public void run() {
        int i=1;
        while(true){
            try {
                Thread.sleep(1000);
                boolean bool=Thread.currentThread().isInterrupted();
                if(bool){
                    System.out.println("在非阻塞的情况下执行该操作,中断状态："+bool);
                    break;
                }
                System.out.println("当前线程："+Thread.currentThread().getName()+i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程退出阻塞状态");
                boolean bool=Thread.currentThread().isInterrupted();
                return;
            }

        }


    }
}

public class Test{
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread);
        thread.start();
        Thread.sleep(3000);
        thread.interrupt();
        System.out.println("程序执行完毕....");
    }
}*/

/*
class MyThread implements Runnable{
    private boolean flag=true;

    @Override
    public void run() {
        int i=1;
        while(flag){
            try {
                System.out.println("当前线程"+Thread.currentThread().getName()+i);
                if(i==2){
                    Thread.sleep(1000);
                }
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
                System.out.println("线程退出阻塞状态");
                return;
            }
        }
    }
}
public class Test{
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread);

        thread.start();
        System.out.println("开启interrupt方法");
        thread.interrupt();
        System.out.println("调用interrupt()后线程的状态"+thread.isInterrupted());
    }
}*/

/*class MyThread implements Runnable{
    private volatile boolean flag=true;
    @Override
    public void run() {
        int i=1;
        while(flag){
            try {
                Thread.sleep(1000);
                System.out.println("当前执行次数："+Thread.currentThread().getName()+i);
                i++;
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void setFlag(boolean flag) {
        this.flag = flag;
    }
}
public class Test{
    public static void main(String[] args) throws InterruptedException {
        MyThread myThread=new MyThread();
        Thread thread=new Thread(myThread);
        thread.start();
        Thread.sleep(2000);
        myThread.setFlag(false);
        System.out.println("程序执行结束");
    }
}*/

/*
* 生产者，消费者模型
* */

class Goods {
    private String name;
    private int count;
    /*
    * 生产方法
    * */
    public synchronized  void produce(String name) throws InterruptedException {
        while(count>0){
            wait();
        }
        Thread.sleep(1000);
        this.name=name;
        count++;
        System.out.println(Thread.currentThread().getName()+"生产"+toString());
        notifyAll();
    }
    /*
    * 消费方法
    * */
    public synchronized void consumer() throws InterruptedException {
        while(count==0){
            wait();
        }
        Thread.sleep(1000);
        count--;
        System.out.println(Thread.currentThread().getName()+"消费了"+toString());
        notifyAll();
    }
    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
//创建生产者
class Produce implements Runnable{
    private Goods goods;
    private String goodsName;
    public Produce(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            while (true) {
                this.goods.produce(goodsName);
            }
        }catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }
}
//创建消费者
class Consumer implements Runnable{
    private  Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            while(true) {
                this.goods.consumer();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test{
    public static void main(String[] args) {
       Goods goods=new Goods();
       Produce p=new Produce(goods);
       p.setGoodsName("祖马龙香水");

        ExecutorService producer=Executors.newFixedThreadPool(5);
        ExecutorService consumer=Executors.newFixedThreadPool(10);
        for(int i=0;i<5;i++){
            producer.submit(new Thread(p,"生产者"+i+1));
        }
        for (int i=0;i<10;i++){
            consumer.submit(new Thread(new Consumer(goods),"消费者"+i+1));
        }
       /*
       Thread produce=new Thread(p);
       Thread consumer=new Thread(new Consumer(goods));
       produce.start();
       consumer.start();*/
    }
}


