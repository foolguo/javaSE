/**
 * @Author: yd
 * @Date: 2019/4/3 15:51
 * @Version 1.0
 */
/*
class MyThread implements Runnable{
    private String title;
    public MyThread(String title) {
        this.title = title;
    }

    @Override
    public void run() {
        System.out.println("hahaha");
    }
}
*/

class MyThread implements Runnable{
    private int ticket=10;
    public void run(){
        while(this.ticket>0){
            System.out.println("当前线程"+Thread.currentThread()+"剩余票数"+this.ticket--);
        }
    }
}
/**
 * 多线程有一个类叫做Thread类，里面有一个方法 run(),但是启动多线程还是需要
 * start()方法。但是直接继承Thread来实现多线程会有继承局限，有一个接口 Runnable
 * 可以实现多线程，通过传入Runnable对象 的类实现多线程。
 * 启动多线性始终用的是Thread类的方法
 */
public class Test {
    public static void main(String[] args) {
       /*MyThread myThread1=new MyThread("1");
        MyThread myThread2=new MyThread("2");
        MyThread myThread3=new MyThread("3");
        new Thread(myThread1).start();
        new Thread(myThread2).start();
        new Thread(myThread3).start();*/
       /* Runnable runnable=()-> System.out.println("夕阳无限好");
        new Thread(runnable).start();*/

        /*
       new MyThread().start();
       new MyThread().start();
        new MyThread().start();
*/
        MyThread mt=new MyThread();
        new Thread(mt).start();
        new Thread(mt,"2").start();
        new Thread(mt).start();

    }
}
