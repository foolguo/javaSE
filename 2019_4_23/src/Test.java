/*
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.concurrent.locks.ReentrantLock;

*//*


import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

*/

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yd
 * @Date: 2019/4/23 16:16
 * @Version 1.0
 *//*
*/
/*

class Person{
    private String name;
    public Integer age;
    public static String conuty;

    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
class Student extends Person{
    private String school;
    public String number;
    private Student() {
    }
    public Student(String school) {
        this.school = school;
    }

    private String getSchool() {
        return school;
    }

    protected void setSchool(String school) {
        this.school = school;
    }
    public static void print(){}
}

public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, NoSuchFieldException {
        Class cls=Class.forName("Student");
        *//*

*/
/*Constructor[] constructors=cls.getDeclaredConstructors();
        for(Constructor i:constructors){
            System.out.println(i+" ");
        }*//*
*/
/*

    *//*

*/
/*    Method[] methods=cls.getMethods();
        for (Method method:methods){
            System.out.println(method);
        }*//*
*/
/*

       *//*

*/
/*Method method=cls.getDeclaredMethod("setName");
        System.out.println(method);*//*
*/
/*

       *//*

*/
/* Field[] fields=cls.getDeclaredFields();
        for(Field field:fields){
            System.out.println(field);
        }*//*
*/
/*

      *//*

*/
/* Field field = cls.getDeclaredField("name");
        System.out.println(field);*//*
*/
/*

     *//*

*/
/*   Field field = cls.getField("number" );
        System.out.println(field);*//*
*/
/*

   *//*

*/
/*     Constructor[] constructors=cls.getDeclaredConstructors();
        for (Constructor constructor:constructors){
            System.out.println(constructor);
        }*//*
*/
/*

    *//*

*/
/*    Constructor constructor=cls.getConstructor(String.class);
        System.out.println(constructor);*//*
*/
/*



    }
}
*//*

class Goods{
    private String goodsName;
    private int count;

    public synchronized void produce(String goodsName) throws InterruptedException {
        while(count>0){
            wait();
        }
        this.goodsName=goodsName;
        count++;
        System.out.println("生产了"+toString());
        System.out.println("生产好了你继续");
        notifyAll();
    }
    public synchronized void customer() throws InterruptedException {
        while(count==0){
            System.out.println("没货了客官稍等");
            wait();
        }
        this.goodsName=goodsName;
        count--;
        System.out.println("消费了"+toString());
        notifyAll();
    }

    @Override
    public String toString() {
        return "Goods{" +
                "goodsName='" + goodsName + '\'' +
                ", count=" + count +
                '}';
    }
}
class Producer implements Runnable{
    private Goods goods;
    public Producer(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
        try {
            while(true) {
                goods.produce("纪梵希");
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
class Consumer implements Runnable{
    private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        try {
            while(true) {
                goods.customer();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


public class Test{
    public static void main(String[] args) throws InterruptedException {
        Goods goods=new Goods();
        Producer producer=new Producer(goods);
        Consumer consumer=new Consumer(goods);
        for(int i=0;i<10;i++) {
            new Thread(producer).start();
            new Thread(consumer).start();

            Lock lock= (Lock) new  ReentrantReadWriteLock();
            lock.lock();
            //获取与Lock绑定的Condition对象

        }
    }
}*/

    /*使用：Condition队列进行生产消费者的写
    *
    * */
class Goods{
    private String name;
    private int count;
    private int maxCount=50;
    private ReentrantLock lock=new ReentrantLock();
    private Condition producerCondition=lock.newCondition();
    private Condition consumerCondition=lock.newCondition();
    public void producer(String name) throws InterruptedException {
        lock.lock();
        try {
            while (count == maxCount) {
                producerCondition.await();
            }
            this.name = name;
            count++;
            System.out.println(Thread.currentThread().getName() + "生产" + toString());
            consumerCondition.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public  void consumer() throws InterruptedException {
        lock.lock();
        try {
            while(count==0){
                consumerCondition.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费"+toString());
            producerCondition.signalAll();
        }finally {
            lock.unlock();
        }

    }

    @Override
    public String toString() {
        return "Goods{" +
                "name='" + name + '\'' +
                ", count=" + count +
                '}';
    }
}
class Producer implements  Runnable{
    private  Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            try {
                goods.producer("mac106");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
class Consumer implements  Runnable{
    private  Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while(true){
            try {
                goods.consumer();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

public class Test{
    public static void main(String[] args) {
        Goods goods=new Goods();
        Producer producer=new Producer(goods);
        Consumer consumer=new Consumer(goods);
        for(int i=0;i<5;i++){
            new Thread(producer,"生产者"+(i+1)).start();
        }
        for(int i=0;i<10;i++){
            new Thread(consumer,"消费者"+(i+1)).start();
        }
    }
}