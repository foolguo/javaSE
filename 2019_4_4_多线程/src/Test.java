/**
 * @Author: yd
 * @Date: 2019/4/4 22:41
 * @Version 1.0
 */
/*1.最直接的方法就是继承Thread类，调用 Thread类 run方法，但是run方法不能
* 被直接调用 要先调用start()方法
*向下面的行为，有线程重复执行了一个代码，这时因为
*
* 该类的run()方法就相当于主类的main方法，但是run方法不能直接被调用，启动线程
* 只能通过start()  总而言之，线程启动都是要靠Thread类中的start()方法调用的
*
* run()的具体调用流程：调用start()方法-->start0()[这个方法是一个系统原生的本地方法]
* --->start0()实际上是调用JVM_StartThread———>调用run_method_name----->在调用run方法
*
* 直接继承Thread类有继承的局限性，所以，有一个Runnable接口，应该继承Runnable接口
* 是Thread类的直接子类，Thread可以当做一个辅助业务类，
* 我们还可以看 Thread类的构造方法，可以传入一个Runnable接口，
* public Tread(Runnable target)
* public Thread(Runnable target,String name)
* 别的方法
* currentThread()  获取当线程，返回Thread对象
* getName()  获取当前线程名字
*
* 对比Thread类和Runnable接口
* Thread实现Runnable接口， 实现Runnable实现多线程比Thread好，因为避免继承的局限性
*
*主线程也是一个线程，线程的几种方法
* 1.线程休眠sleep():线程会立刻交出cpu，但不会释放锁，线程从运行状态到阻塞状态
* 虽然看上去三个线程是同时休眠，但是他们是依次进入run()方法的  谁先进入不一定
* 看系统调度， 如果是同时进，同时出每个线程的顺序应该一样（有一个同步问题）
* 2.线程让步yield()：线程会交出CPU，但是不会立即交出，线程会从运行状态到就绪状态
* 但是什么时候交要靠系统调度，
* 3.join(),等待线程终止，在那个线程调用该方法，那个线程就休眠，会释放对象锁
* 是对Object类外套、做了一层包装而已
*
*
* 同步问题，多个线程轮番抢占资源
* 同步处理  synchronize
* 1.同步代码块  synchronize(){}
* 1.括号里面可以是当前对象，锁的是一个对象，不是多个对象
* 2.可以是类对象：将代码块锁住一个全局锁，
* 3.可以是任意对象
*
* public synchronize void 方法名()  默认锁住this对象  ，没有让这段代码同一时刻只能有一个对象访问
*
* */
/*
class MyThread extends Thread{
    private String title;
    public MyThread(String title){
        this.title=title;
    }
    @Override
    public void run() {
        for(int i=0;i<100;i++){
            System.out.println(this.title+",i="+i);
        }
    }
}*/


//来个买票的例子
class MyThread implements Runnable{
    /*private int ticket=100;
    @Override
    public void run() {
        while(this.ticket>0){
            System.out.println("当前的线程是"+Thread.currentThread().getName()+"剩余票数"+this.ticket--);
        }
    }*/

    @Override
    public void run() {
        for(int i=0;i<1000;i++){
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            System.out.println("当前线程"+Thread.currentThread().getName()+"i="+i);
        }
    }
}
public class Test {
    public static void main(String[] args) {
        MyThread myThread=new MyThread();
        System.out.println("主线程开始");

        Thread thread=new Thread(myThread,"线程1");
        thread.start();
        new Thread(myThread,"线程2").start();
        /*Thread.yield();*/
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        new Thread(myThread,"线程3").start();
        System.out.println("主线程结束");

    }
}
