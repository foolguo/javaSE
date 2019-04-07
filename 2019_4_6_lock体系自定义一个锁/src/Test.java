/*
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.AbstractQueuedSynchronizer;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;

*/
/**
 * @Author: yd
 * @Date: 2019/4/6 16:46
 * @Version 1.0
 *//*


//定义一个自己的锁，1.继承lock接口，2.在类的内部实现一个静态的Sync类且继承AQS
class MyLock implements Lock {
    private  Sync sync=new Sync();
    //Sync类是面向实现者的
    static class Sync extends AbstractQueuedSynchronizer{
        @Override
        protected boolean tryAcquire(int arg) {
            //默认arg为1是同步状态：同一时刻只有一个线程拿到锁
            if(arg!=1){
                throw new IllegalMonitorStateException();
            }
            if(compareAndSetState(0,1)){
                //这一步实际上和AQS是一样的
                setExclusiveOwnerThread(Thread.currentThread());
                return true;

            }
            return false;
        }

        @Override
        protected boolean tryRelease(int arg) {
            if(getState()==0){
                throw  new IllegalMonitorStateException();
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
        sync.acquire(1);
    }

    @Override
    public void lockInterruptibly() throws InterruptedException {
        sync.acquireInterruptibly(1);
    }

    @Override
    public boolean tryLock() {
        return  sync.tryAcquire(1);
    }

    @Override
    public boolean tryLock(long time, TimeUnit unit) throws InterruptedException {
        return false;
    }

    @Override
    public void unlock() {
        sync.release(1);
    }

    @Override
    public Condition newCondition() {
        return null;
    }
}
class MyThread implements Runnable{
    private  MyLock myLock=new MyLock();
    @Override
    public void run() {

            //()->相当于传入了一个真实的MyThread对象
                try {
                    myLock.lock();
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }finally {
                    myLock.unlock();
                }

    }
}
public class Test {

    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        for (int i=0;i<10;i++){
            Thread thread=new Thread(myThread);
            thread.start();

        }
    }
}
*/

    /*
    痴汉wait()方法  1.0
    1.调用wait()方法后，当前线程立刻停止运行，处于等待状态，知道被释放notify()或者interrupt()
    终断
    2.只可以在同步代码块或者同步方法中使用，必须是内键锁
    3.wait()使用后立刻释放锁
     */
/*
public class Test{
    public static void main(String[] args) {
        Thread thread=new Thread(()->{
            Object obj=new Object();
            synchronized (obj){
                try {
                    System.out.println("方法开始");
//                    obj.wait();
                    obj.wait(10000);
                    System.out.println("结束");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        thread.start();
    }
}*/
/*
class MyThread implements Runnable{
    private Object object;
    private Boolean flag;

    public MyThread(Object object, Boolean flag) {
        this.object = object;
        this.flag = flag;
    }

    @Override
    public void run() {
        if(flag){
            this.waitMethod();
        }else{
          this.notifyAllMethod();
        }
    }
    public void waitMethod(){
        synchronized (object){
            try {
                System.out.println("线程"+Thread.currentThread().getName()+"等待开始");
                object.wait();
                System.out.println("线程"+Thread.currentThread().getName()+"等待结束");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void notifyMethod(){
        synchronized (object){
            try{
            System.out.println("线程"+Thread.currentThread().getName()+"唤醒开始");
            object.notify();
            System.out.println("线程"+Thread.currentThread().getName()+"唤醒结束");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public void notifyAllMethod(){
        synchronized (object){
            try{
                System.out.println("线程"+Thread.currentThread().getName()+"唤醒开始");
                object.notifyAll();
                System.out.println("线程"+Thread.currentThread().getName()+"唤醒结束");
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
}

public class Test{
    public static void main(String[] args) {
        Object obj=new Object();
        MyThread myThread1=new MyThread(obj,true);
        MyThread myThread2=new MyThread(obj,false);

        Thread thread1=new Thread(myThread1,"wiat1");
        Thread thread2=new Thread(myThread1,"wiat2");
        Thread thread3=new Thread(myThread1,"wiat3");
        Thread thread4=new Thread(myThread1,"wiat4");

        Thread thread5=new Thread(myThread2,"notify");
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();


        thread5.start();



    }
}*/
/**
 * 消费者，生产者模型
 * 1.一个商品类（生产，出售）
 * 2.一个生产者类
 * 3.一个消费者类
 *
 * wait():
 * 调用wait 程序立刻终止运行，进入等待状态，并且立刻释放锁
 * wait方法必须在同步代码块或者同步方法使用
 *               同步问题：多个线程轮番抢占同一个资源的问题(黄牛买票会出现-1)
 *                 同步处理：（同步代码块和同步方法可以在普通类中出现）
 *              同步代码块：synchronized){},可以锁当前对象，任意对象，类对象（全局锁）
 *              同步方法：public synchronize void  可以锁当前对象，和全局锁
 *              synchronize：首先要执行monitorenter，使用synchronize进行同步最主要的是对对象监视器进行获取，当线程获取monitor
 *              后才继续执行。否则等待，是一个互斥过程。。。。同一时刻只可以有一个线程获取到monitor
 *              反编译有多个monitor原因是为了让monitor在正常和异常路径上都可以解锁
 *              synchronize传统内键锁问题是线程阻塞和唤起锁所消耗的性能太低，
 *              CAS：有三个指标V：内存存放的值  O ：期待的值  N：更新的值
 *              如果 V==O 将 V=N；
 *              如果V！=O将 return V；
 *              成功的线程拿到锁，不成功的线程自旋，不断尝试拿锁：
 *              以前的内键锁的问题是，只要线程那不到锁，就会将线程  ->阻塞态，下次唤起线程的效率低（类车启动费油）
 *              CAS不会将线程直接弄成阻塞状态，而是会尝试不断获取锁；
 *              CAS带来的三个问题：
 *              ABA：线程1->V 1
 *                   线程2->V 1--2:
 *                   线程3-> 2--1;
 *                   这时线程1在来尝试获得锁时，如果该了值，2,3线程全部瘫痪；
 *                   解决，加一个版本号
 *              自旋：自旋浪费大量资源。
 *                      解决，自旋一定次数，让钱程进入阻塞态
 *              不公平性：处于阻塞态的锁，无法立刻获取锁
 *
 *              对象头：实际上就是一个标志：对象头的mark Word救赎存放对象的harshcode
 *              锁的状态：无锁，偏向锁，轻量级锁，重量级锁，
 *                        0|01   1|01      00         10
 *              这四种状态为了让拿到锁的代价低
 *              偏向锁：多个线程在不同时间取得一把锁（几乎无竞争）
 *               偏向锁的获得  ：
 *               1.一个线程访问同步代码块---->对比对象头中的线程ID是否是当前线程的ID---->如果不是用CAS替换Mark word（）--->
 *               如果成功将对象头中的xiancID指向自己（检查偏向锁是否为0）----
 */

import java.util.ArrayList;
import java.util.List;

/**
 * 商品类：
 *
 */
class Good{
    private String name;
    private int count;
    /*
    生产方法
     */
    public synchronized void set(String name) throws InterruptedException {
        while(count>0){
            wait();
        }
        this.name=name;
        this.count=this.count+1;
        System.out.println("生产"+toString());
         Thread.sleep(1000);
         notifyAll();
    }
    /*
    消费方法
     */
    public synchronized void get() throws InterruptedException {
        while (count==0){
            System.out.println("卖光了");
            wait();
        }
        this.count=this.count-1;
        Thread.sleep(1000);
        System.out.println("消费"+toString());
        notifyAll();
    }

    @Override
    public String toString() {
        return "Goods [gooname]="+name+"库存为"+count;
    }
}
class producer implements  Runnable{
    private  Good good;

    public producer(Good good) {
        this.good = good;
    }

    @Override
    public void run() {
        while (true) {
            try {
                good.set("生产一个口红");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consume implements Runnable{
    private Good good;

    public Consume(Good good) {
        this.good = good;
    }
    @Override
    public void run() {
        while (true) {
            try {
                this.good.get();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class Test{
    public static void main(String[] args) {
        Good good=new Good();
        List<Thread> list=new ArrayList<>();
        for(int i=0;i<10;i++) {
            Thread produce = new Thread(new producer(good), "生产线程"+i);
            list.add(produce);
        }
        for (int i=0;i<6;i++) {
            Thread consume = new Thread(new Consume(good), "消费者线程"+i);
            list.add(consume);
        }
        for (Thread thread:list){
            thread.start();
        }

    }
}