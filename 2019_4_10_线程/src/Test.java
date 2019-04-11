/*
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

*/

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author: yd
 * @Date: 2019/4/10 14:29
 * @Version 1.0
 *//*

class Mylock implements Lock{
    private Sysn sysn=new Sysn();
    static class Sysn extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            if(arg!=1){
                throw new RuntimeException("信号量不为1");
            }
            if(compareAndSetState(0,1)){
                setExclusiveOwnerThread(Thread.currentThread());
                return true;
            }
            return  false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                throw new IllegalStateException("没有获得锁");
            }
            setExclusiveOwnerThread(null);
            setState(0);
            return true;
        }

        @Override
        protected boolean isHeldExclusively() {
            return getState()==1;
        }
    }

    @Override
    public void lock() {
        sysn.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sysn.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return  sysn.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sysn.tryRelease(0);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
public class Test {
    private static Mylock mylock=new Mylock();
    public static void main(String[] args) throws Exception {
        Lock lock=new Mylock();
        lock.lock();
        for(int i=0;i<10;i++){
            Thread thread=new Thread(()->{
                mylock.lock();
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                finally {
                    mylock.unlock();
                }
            });
            thread.start();
        }
    }
}
*/
/*
    class A implements Runnable{

    @Override
    public void run() {
        System.out.println("A的优先级"+Thread.currentThread().getPriority());
        Thread thread=new Thread(new B());
        thread.start();
    }
}
class B implements  Runnable{
    @Override
    public void run() {
        System.out.println("B的优先级"+Thread.currentThread().getPriority());
    }
}
public class Test{
    public static void main(String[] args)  {
            Thread thread=new Thread(new A());
      thread.setPriority(Thread.MAX_PRIORITY);
      thread.start();

    }
}*/
/*
class A extends Thread{
    private String title;
    public A(String title){
        this.title=title;
    }
    @Override
    public void run() {
        System.out.println("启动一个线程"+title);
    }
}
public class Test{
    public static void main(String[] args) {
            A a1=new A("1");
            A a2=new A("2");
            A a3=new A("3");
            a1.start();
            a2.start();
            a3.start();
    }
}*/
/*class C implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getName());
    }
}*/
/*
public class Test{
    public static void main(String[] args) {
        Runnable c=()->System.out.println("当前线程"+Thread.currentThread().getName());
        Thread thread1 = new Thread(c,"线程1");
        Thread thread2= new Thread(c,"线程2");
        Thread thread3= new Thread(c,"线程3");
        thread1.start();
        thread2.start();
        thread3.start();

    }
}*/
/*
class A implements Callable<String>{
    private int ticket=10;
    @Override
    public String call() throws Exception {

            while(ticket>0){
                System.out.println("剩余票数" + ticket--);
            }
        return "没有票了";
    }
}
public class Test{
    public static void main(String[] args) {
        FutureTask task=new FutureTask(new A());
        new Thread(task,"黄牛1").start();
        new Thread(task,"黄牛2").start();
        new Thread(task,"黄牛3").start();

    }
}*/
/*class MyThread1 implements Runnable{
    @Override
    public void run() {
        System.out.println("线程m1优先级:  "+Thread.currentThread().getPriority());
        MyThread2 myThread2=new MyThread2();
        new Thread(myThread2).start();
    }
}
class  MyThread2 implements Runnable{
    @Override
    public void run() {
        System.out.println("线程m2优先级：  "+Thread.currentThread().getPriority());
    }
}*/

/**
 * 多线程锁之前：
 * 1.创建线程  :
 * 可以继承Thread，但是又继承的局限性
 * 还可以继承Runnable 接口，
 * 但是实现接口的类的实例化对象必须要传入Tread
 * 但是所有线程的启动都要通过start()方法
 * start—>start0—>JVM_Thread_Start—>JVM_thread_entry—>vmSymbolHandles---->statrt_method_name
 * 注：不会按照start顺序来运行随机
 * start从阻塞态到就绪态
 * 2.线程的几种方法Thread
 * 1.构造方法：1.Thread(Runnable run)  Thread(Runnable run,String name)
 * 2.获取当前线程,静态方法：  static Thread  currentThread()
 * 3.获取线程名字 getName()   设置线程名字setName()
 * 3.sleep join  yield方法
 *  sleep:线程休眠 会立刻交出CPU让其他任务执行，不会释放锁，线程从运行态到阻塞态
 *  join：等待线程停止： 在那个线程运行就会让那个线程停止 会立刻交出CPU并释放锁，
 *  让调用该方法的线程先执行完毕后再执行原线程
 *  线程从运行态到阻塞态，
 *  yield：线程让步：会交出CPU但不会立刻交出CPU , 线程从阻塞态到就绪态，让与其相同优先级的线程优先获取锁
 *  4.线程停止
 *  有一个方法stop()但是现在基本不用
 *  他会导致一个问题就是产生残缺数据，因为一调用这个方法就会立刻终止线程
 *  Interrupt()方法 有一个标记
 *  如果线程是运行状态，将标记设置为TRUE
 *  如果线程是阻塞状态，将线程设置为false并且抛出InterruptException
 *  如果线程运行状态并且标志位true 调用 wait  join  sleep 直接false 抛出  InterruptException
 * 5.线程的优先级
 * setPriority  和  getPriority
 * 线程的优先级有继承性，集在那个线程启动新的线程，那么这两个线程的优先级一样
 * 主线程是中等优先级
 * 查看主线程的优先级
 * 有几个常量：
 * Thread.MAX_Priority
 * Thread.MIN_Priority
 * Thread.NORM_Priority
 *
 * 6.守护线程
 *守护线程是一个陪伴线程  线程分成两个，守护线程和用户线程
 * 直到最后一个用户线程结束，守护线程才会结束，   垃圾回收线程
 *
 *7.主线程和子线程:所有线程都是要通过主线程执行的所以。。
 *
 *8.同步问题：多个线程共同抢占共享资源导致的问题
 * 对应到黄牛卖票就是：多个线程进入run()方法的while循环
 * 导致资源抢占的问题
 * 8.线程锁
 * a.同步代码块
 * synchronized(this){}
 * 同步方法
 *
 *
 */

/*
class MyThread implements Runnable{
    private  int ticket=10;

    @Override
    public void run() {
        synchronized (this) {
            for (int i = 0; i < 10; i++) {
                if (ticket > 0) {
                    System.out.println(Thread.currentThread() + "还剩下" + ticket--);
                }
            }
        }


    }
}
public class Test{
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        new Thread(mt,"黄牛1").start();
        new Thread(mt,"黄牛2").start();
        new Thread(mt,"黄牛3").start();


    }
}
*/
/*class A{
    public synchronized void B() throws InterruptedException {
        System.out.println("B"+Thread.currentThread().getName());
        while(true) {
            this.A();
            Thread.sleep(2000);
        }
    }
    public synchronized void A(){
        System.out.println("A"+Thread.currentThread().getName());
    }
}*/
class Sync{
    public synchronized void test() throws InterruptedException {
            System.out.println("test方法开始" + Thread.currentThread().getName());
            Thread.sleep(1000);
        System.out.println("test方法结束" + Thread.currentThread().getName());
    }
    public synchronized void testA(){
        System.out.println("testA方法开始" + Thread.currentThread().getName());
        System.out.println("test方法开始" + Thread.currentThread().getName());
    }

}
class MyThread extends Thread{
    Sync sync=new Sync();
/*    private  Sync sync;
    public MyThread(Sync sync){
        this.sync=sync;
    }*/
    @Override
    public void run() {
        try {
            sync.test();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
public class Test{
    public static void main(String[] args) {
        MyThread myThread=new MyThread();

        myThread.start();

    }
}



/*class Mythread implements Runnable{
    private int ticket=1000;
    @Override
    public void run() {
        for(int i=0;i<1000;i++) {
       *//*     try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }*//*
            Thread.yield();
            System.out.println("当前线程是" + Thread.currentThread().getName()+
                    "还剩下"+this.ticket--+"票");
        }
        }
}*/


/*class A implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程是"+Thread.currentThread().getPriority());
        B b= new B();
        new Thread(b).start();
    }
}
class B implements Runnable{
    @Override
    public void run() {
        System.out.println("当前线程"+Thread.currentThread().getPriority());
    }
}

public class Test{
    public static void main(String[] args) throws InterruptedException {
        A a=new A();
        a.run();
        Thread thread=new Thread(a);
        thread.setPriority(Thread.MAX_PRIORITY);
        thread.start();
        */



       /* System.out.println("主线程开始");
        Mythread mythread=new Mythread();
        *//**
         * 看上去三个线程是同时谁的同时回来的，应该是A B C顺序完全一样（睡完  执行）
         *//*
        Thread thread=new Thread(mythread ,"A");
        thread.start();
        thread.join();
       // Thread.sleep(1000);
        *//*Thread.yield();*//*
        new Thread(mythread ,"B").start();
        new Thread(mythread ,"C").start();
        System.out.println("主线程结束");*/
        //Thread.interrupted();
/*
    }
}
*/



/*
//1
class MyThread extends Thread {
    @Override
    public void run() {
        System.out.println("当前线程是"+Thread.currentThread().getName());
    }
}
public class Test{
    public static void main(String[] args) {
        MyThread myThread1=new MyThread();
        MyThread myThread2=new MyThread();
        MyThread myThread3=new MyThread();
        myThread1.start();
        myThread2.start();
        myThread3.start();
    }
}*/
