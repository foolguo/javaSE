/**
 * @Author: yd
 * @Date: 2019/4/19 11:22
 * @Version 1.0
 */
/*
class MyThread implements Runnable{
    private int ticket=10;

    @Override
    public synchronized  void run() {

            while (ticket > 0) {

                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("当前线程" + Thread.currentThread() + "还剩下" + ticket-- + "票");
            }
        }
    }

*/
/*class A{
    public   void testA(){
        System.out.println("方法A"+"当前线程"+Thread.currentThread().getName());
        testB();
    }
    public   void testB(){
        System.out.println("方法B"+"当前线程"+Thread.currentThread().getName());
    }
}*/
/*lass Sync{
    public synchronized void testA(){
        while(true){

        }
    }
    public synchronized void testB(){
        if ()
    }
}
class MyThread implements Runnable{

    @Override
    public  void run() {

    }

}*/
/*
class MyThread implements Runnable{

    @Override
    public void run() {
        test1();
    }
    public synchronized  void test1(){
      */
/*  if(Thread.currentThread().getName().equals("A")){
            while(true){
                teat2();
            }*//*

        if(Thread.currentThread().getName().equals("A")){
            System.out.println("A线程进入test1方法");
        }
            teat2();
    }
    public  synchronized void teat2(){
        //if(Thread.currentThread().getName().equals("B")){
          //  System.out.println("线程B进入同步方法2");
        //}else{
            System.out.println(Thread.currentThread().getName()+"进入test2方法");
        //}


    }
}
public class Test{
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        new Thread(mt,"A").start();
        //new Thread(mt,"B").start();
    }
}

*/
/*class MyThread implements Runnable{

    @Override
    public void run() {
        test1();
        teat2();
    }
    public synchronized  void test1(){
      *//*  if(Thread.currentThread().getName().equals("A")){
            while(true){
                teat2();
            }*//*
        if(Thread.currentThread().getName().equals("A")){
            while(true){}
        }
    }
    public  synchronized void teat2(){
        if(Thread.currentThread().getName().equals("B")){
         System.out.println("线程B进入同步方法2");
        }else{
        System.out.println(Thread.currentThread().getName()+"进入test2方法");
        }


    }
}
public class Test{
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        new Thread(mt,"A").start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        new Thread(mt,"B").start();
    }
}*/



//monitor机制
/*
线程在获取锁的过程其实就是获取monitor对象的过程。
执行同步代码块 先执行monitorenter指令，然后执行monitorexit指令

使用内建锁进行同步关键就是获取monitor对象，当获取其才可以向下执行代码，这个过程是互斥的 即每一个时刻只可以有一个
线程获取到monitor对象。
同步方法只是在字节码文件中有一个ACC_MINITOR标记罢了

 有一个monitorenter和若干个monitorexit 这时为了保证代码在非正常运行时都可以释放锁

  过程
  获取minitor对象实际上是获取了一个对象计数器，当前计数器为0是说明当前没有任何线程持有锁，JVM会将锁持有线程
变为设置为当前线程，计数器加1，如果当前计数器为1，说明已经有线程持有锁，验证锁持有线程是否是当前线程如果是，计数器+1
如果不是 要等待当前线程释放锁后才可以获取锁
 */
//证明可重入性
/*class MyThread implements Runnable{

    @Override
    public void run() {
        test1();
    }
    public synchronized void test1(){
        System.out.println("线程A进入test1");
        test2();
    }
    public synchronized void test2(){
        System.out.println("当前线程"+Thread.currentThread().getName()+"进入test2");
    }
}*/
/*class MyThread implements Runnable{

    @Override
    public void run() {
        test1();
        test2();
    }
    public synchronized void test1(){
        if(Thread.currentThread().getName().equals("A")){
            while(true){}
        }

    }
    public synchronized void test2(){
        if(Thread.currentThread().getName().equals("B")){
            System.out.println("线程B进入test2");
        }else{
            System.out.println(Thread.currentThread().getName()+"进入test2");
        }

    }
}
public class Test{
    public static void main(String[] args) throws InterruptedException {
        MyThread mt=new MyThread();
        new Thread(mt,"A").start();
        Thread.sleep(1000);
       new Thread(mt,"B").start();
    }
}*/

/**
 * 生产者消费者模型
 * 生产者 消费者 通过阻塞队列连接在一起，
 */
/*class Goods {
    private int count;
    private String goodName;
    *//**
 * 生产商品
  *//*
public synchronized  void producer(String goodName) throws InterruptedException {
    if(count>0){
        wait();
    }
    this.goodName=goodName;
    count=count+1;
    System.out.println(toString());
    notify();
}
*//**
 * 消费商品
 *//*
public synchronized void consumer(String goodName) throws InterruptedException {
    if(count==0){
        wait();
    }
    this.goodName=goodName;
    count=count-1;
    System.out.println(toString());
    notify();
}

    @Override
    public String toString() {
        return "Goods{" +
                "count=" + count +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}
class Produce implements Runnable{
    private Goods goods;

    public Produce(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            this.goods.producer("生产纪梵希");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements  Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            this.goods.consumer("消费纪梵希");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test{
    public static void main(String[] args) {
        Goods goods=new Goods();
        new Thread(new Consumer(goods)).start();
        new Thread(new Produce(goods)).start();
    }
}*/
/*

class Goods {
    private int count;
    private String goodName;
    */
/**
     * 生产商品
     *//*

    public synchronized  void producer(String goodName) throws InterruptedException {
        while(count>0){
            wait();
        }
        this.goodName=goodName;
        count=count+1;
        System.out.println(toString());
        notifyAll();
    }
    */

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.atomic.AtomicReference;

/**
     * 消费商品
     *//*

    public synchronized void consumer(String goodName) throws InterruptedException {
        while(count==0){
            System.out.println("商品买完了");
            wait();
        }
        this.goodName=goodName;
        count=count-1;
        System.out.println(toString());
        notifyAll();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "count=" + count +
                ", goodName='" + goodName + '\'' +
                '}';
    }
}
class Produce implements Runnable{
    private Goods goods;

    public Produce(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            while(true) {
                this.goods.producer("生产纪梵希");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements  Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            while(true) {
                this.goods.consumer("消费纪梵希");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

public class Test{
    public static void main(String[] args) {
        Goods goods=new Goods();
        new Thread(new Consumer(goods)).start();
        new Thread(new Produce(goods)).start();
    }
}
*/

/*
class MyThread implements Callable<String>{

    @Override
    public String call() throws Exception {
        System.out.println("当前线程"+Thread.currentThread().getName());
        return "有线程进来了";
    }
}

public class Test{
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask=new FutureTask<>(new MyThread());
        new Thread(futureTask).start();
        System.out.println(futureTask.get());
    }
}*/
/*
public class Test{
    public static void main(String[] args) {
        Object
    }
}*/
/*class MyThread implements Runnable{
    private boolean flag;
    private Object obj;

    public MyThread(boolean flag, Object obj) {
        this.flag = flag;
        this.obj = obj;
    }

    public void waitMethod() throws InterruptedException {
        synchronized (obj){
            System.out.println(Thread.currentThread().getName()+"开始");
            obj.wait();
            System.out.println(Thread.currentThread().getName()+"结束");
        }
    }
public void notifyMethod(){
synchronized (obj){
        System.out.println(Thread.currentThread().getName()+"开始");
        obj.notify();
        System.out.println(Thread.currentThread().getName()+"结束");
        }
        }

@Override
public void run() {
        if(flag){
        try {
        waitMethod();
        } catch (InterruptedException e) {
        e.printStackTrace();
        }
        }else{
        notifyMethod();
        }
        }
        }

public class Test{
    public static void main(String[] args) throws InterruptedException {
        Object obj=new Object();
        MyThread mt1=new MyThread(true,obj);
        MyThread mt2=new MyThread(false,obj);
        new Thread(mt1,"wait").start();
        Thread.sleep(1000);
        new Thread(mt2,"notify").start();
    }
}*/
class MyThread {
    private boolean flag=true;
    private int count=1;

    public synchronized void printNum() throws InterruptedException {
         if(flag==false){
             wait();
         }
        System.out.print(2*count-1);
        System.out.print(2*count);
        flag=false;
        notify();


    }
    public synchronized void printChar() throws InterruptedException {
        if(flag==true){
            wait();
        }
        char c=(char) (count-1+'A');
        System.out.print(c);
        count++;
        flag=true;
        notify();
    }

}

public class Test{
    public static void main(String[] args) {
        MyThread mt=new MyThread();
        new Thread(()->{
           for(int i=0;i<26;i++){
               try {
                   mt.printNum();
               } catch (InterruptedException e) {
                   e.printStackTrace();
               }
           }
        }).start();
        new Thread(()->{
            for (int i=0;i<26;i++){
                try {
                    mt.printChar();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

