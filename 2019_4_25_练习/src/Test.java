import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yd
 * @Date: 2019/4/25 13:24
 * @Version 1.0
 */
class Goods{
    private ReentrantLock lock=new ReentrantLock();
    private int count;
    private Condition producerWait=lock.newCondition();
    private Condition consumerWait=lock.newCondition();
    private int maxCount;
    private String name;
    public Goods(int maxCount) {
        this.maxCount = maxCount;
    }

    public void producer(String name){
        lock.lock();
        try{
            while(count==maxCount){
                producerWait.await();
            }
            this.name=name;
            count++;
            System.out.println("生产了"+toString());
            consumerWait.signalAll();

        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }

    }
    public void consumer(){
        lock.lock();
        try {
            while (count==0){
                consumerWait.await();
            }
            count--;
            System.out.println("消费了,还剩下"+toString());
            producerWait.signalAll();
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {

        }
    }

    @Override
    public String toString() {
        return name+count+"只";
    }
}
class Consumer implements Runnable{
        private Goods goods;

    public Consumer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            goods.consumer();
        }
    }
}
class Producer implements Runnable{
    private Goods goods;

    public Producer(Goods goods) {
        this.goods = goods;
    }

    @Override
    public void run() {
        while (true){
            goods.producer("纪梵希");
        }
    }
}

public class Test {
    public static void main(String[] args) {
        Goods goods=new Goods(50);
        for(int i=0;i<10;i++){
            new Thread(new Producer(goods)).start();
        }
        for(int i=0;i<10;i++){
            new Thread(new Consumer(goods)).start();
        }
    }
}
