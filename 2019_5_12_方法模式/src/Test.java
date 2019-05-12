import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/12 17:31
 * @Version 1.0
 */
/*
* 1.模板方法模式：第三方 模板方法，核心流程一样，具体步骤有所不同
* 2.工厂模式
* 3.单例模式：
* 4.多例模式
* 5.代理模式
* */
/*abstract class Coffeein{
    public final void drink(){
        boil();
        pao();
        pour();
        add();
        System.out.println("请取走你的饮料");
    }
    public void boil(){
        System.out.println("烧开水");
    }
    public abstract void pao();
    public void pour(){
        System.out.println("将半成品放入杯子中");
    }
    public abstract void add();
    public boolean gouzi(){
        return true;
    }
}
class Coffee extends Coffeein{


    @Override
    public void pao() {
        System.out.println("冲泡咖啡");
    }

    @Override
    public void add() {
        if (gouzi()) {
            System.out.println("加糖");
        }
    }
    public boolean gouzi(){
        Scanner scanner=new Scanner(System.in);
        System.out.println("请选择是否要加糖y/n");
        String str=scanner.nextLine();
        if(str.equals("y")){
            return true;
        }
        return false;
    }
}


public class Test {
    public static void main(String[] args) {
        Coffeein coffee=new Coffee();
        coffee.drink();
    }
}*/

//工厂模式
/*
interface Computer{
    void buy();

}
class Mac implements Computer{

    @Override
    public void buy() {
        System.out.println("买一台Mac电脑");
    }
}
class Surface implements  Computer{


    @Override
    public void buy() {
        System.out.println("买一台微软电脑");
    }
}
*/
/*class Factory{
    public static Computer instance(String objName) throws ClassNotFoundException {
         Class cls=Class.forName(objName);
        try {
            Computer computer=null;
            computer= (Computer) cls.newInstance();
            return computer;
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

}*//*

interface Factory{
     Computer newInstance(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException;
}
class AppleFactory implements Factory{


    @Override
    public Computer newInstance(String string) throws ClassNotFoundException, IllegalAccessException, InstantiationException {
        Class cls=Class.forName(string);
        Computer computer=null;
        computer= (Computer) cls.newInstance();
        return computer;
    }
}


public class Test{
    public static void main(String[] args) throws ClassNotFoundException {
       */
/* Computer mac=Factory.instance("Mac");
        mac.buy()*//*
;
    }
}*/

//单例模式
class Singleton{
    private static  Singleton singleton;
    private int num=10;
    private Singleton(){}
    public static Singleton getInstance(){
        if(singleton==null){
            synchronized (Singleton.class){
                if(singleton==null){
                    singleton=new Singleton();
                }
            }
        }
        return singleton;
    }

    public void setNum(int num) {
        this.num = num;
    }
}
/*
class Singleton {
    private static Singleton singleton=new Singleton();
    private Singleton(){}
    public static Singleton getInstance(){
        return singleton;
    }
}
*/
/*
class NewInstance implements  Runnable{

    @Override
    public void run() {
      get();
    }
    public Singleton get(){
        return Singleton.getInstance();
    }
}
//1.在堆上开辟空间
//2.属性初始化
//3.栈空间指向  singleton  =null  返回后报错
public class Test{
    public static void main(String[] args) {
        NewInstance newInstance1=new NewInstance();
        Thread thread1=new Thread(newInstance1);
        Thread thread2=new Thread(newInstance1);
        thread1.start();
        thread2.start();


    }
}*/


//代理模式   Thread类
/*
interface Buy{
    void buy();
}
class Consumer implements Buy{

    @Override
    public void buy() {
        System.out.println("买一个口红");
    }
}
class DaiGou implements Buy{
    private Consumer consumer;
    public DaiGou(Consumer consumer) {
        this.consumer = consumer;
    }
    @Override
    public void buy() {
        before();
        consumer.buy();
        after();
    }
    public void before(){
        System.out.println("排队");
    }
    public void after(){
        System.out.println("寄回");
    }
}
public class Test{
    public static void main(String[] args) {
        Buy buy=new DaiGou(new Consumer());
        buy.buy();
    }
}*/
