import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @Author: yd
 * @Date: 2019/4/27 9:44
 * @Version 1.0
 */

/*
* ThreadLocal 实际上是为线程提供局部变量，在多线程的环境下可以保证各个线程的变量独立于其他线程的变量
* 就是线程为每个线程创建一个单独的副本，相当于线程的private static 变量.
    同步机制是为了保证多线程环境下的统一性，  ThreadLocal是保证多线程环境下数据的独立性
*  为什么ThreadLocal可以为线程提供局部变量呢?
*  每次创建一个ThreadLocal实例对象并向其添加数据时
*  实际上是创建一个线程的ThreadMap，这类是ThreadLocal的静态内部类
*  它和HashMap的结构差不多，是一组key—Value，key是thread对象，value是实际要添加的值
*  由于每个值是线程独有的，所以互相不干涉。
*
*
*/
/*
class MyThread implements Runnable{
    private int num=10;
    @Override
    public  void run() {

    }
}
*/
/*public class Test {
    private static ThreadLocal<String> threadLocal=new ThreadLocal();
    private static String str;
    public static void main(String[] args) throws InterruptedException {
        //MyThread mt=new MyThread();
        str="main";
        threadLocal.set(str);
        Thread thread=new Thread(new Runnable() {
            @Override
            public void run() {
                str="thread";
                threadLocal.set(str);
                threadLocal.remove();
                threadLocal.set("hahaha");
                System.out.println(threadLocal.get());
            }
        });
        thread.start();
        thread.join();
        System.out.println(str);
        System.out.println(threadLocal.get());


    }
}*/

/*public class Test{
    public static void main(String[] args) {
        ThreadPoolExecutor threadPoolExecutor=new ThreadPoolExecutor(
                3, 5, 1000, TimeUnit.NANOSECONDS,
                new LinkedBlockingQueue<>(20),

        new ThreadPoolExecutor.DiscardPolicy()
        );
        for(int i=0;i<5;i++){
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    System.out.println(Thread.currentThread().getName()+"hello");
                }
            });
        }
    }
}*/
/*
* Collections，工具类  仅限Collection使用
* 有集合翻转，集合排序等等
* */
/*public class Test{
    public static void main(String[] args) {
        *//*ArrayList<Integer> arrayList=new ArrayList();
        Collections.addAll(arrayList,1,2,3);
        Collections.reverse(arrayList);
        Iterator<Integer> iterator=arrayList.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }*//*
        List<String> arrayList=new ArrayList();*//*
        Collections.addAll(arrayList,"c++","java","php","JavaScript" );
        Stream<String> stream=arrayList.stream();
        System.out.println(stream.filter((e)->e.contains("java")).collect(Collectors.toList()));*//*
        Collections.addAll(arrayList,"1","Python","2","Java","3","php","4","C++","5","Go");
        Stream<String> stream=arrayList.stream();
        List<String> resultList= (List<String>) stream.skip(0).limit(3).map((s)->s.toUpperCase()).collect(Collectors.toList());
        System.out.println(resultList);
    }
}*/




   /*  @Override
   public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }*/

/*    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test{
    public static void main(String[] args) {
        ArrayList<Person> list=new ArrayList<>();
        list.add(new Person("张三",19));
        list.add(new Person("李四",10));
        list.add(new Person("王麻子",0));
        System.out.println(list.contains(new Person("张三",19)));
        Iterator iterator=list.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

    }
}*/
/*
class Person implements Comparable {
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return Objects.equals(name, person.name) &&
                Objects.equals(age, person.age);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    @Override
    public int compareTo(Object o) {
        return 0;
    }
}

public class Test{
    public static void main(String[] args) {
        TreeSet<Person> treeSet=new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                return ((Person)o1).getAge()-((Person) o2).getAge();
            }
        });
        treeSet.add(new Person("a",19));
        treeSet.add(new Person("b",18));
        treeSet.add(new Person("c",20));
        treeSet.add(new Person("d",21));
        treeSet.add(new Person("d",21));

        Iterator iterator=treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }
        Collections.synchronizedList();

    }
}*/
/*
public class Test{
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap<>();
        map.put(1,"2");
        map.put(2,"2");
        map.put(3,"2");
        map.put(4,"2");
        Set  set=map.entrySet();
        Iterator iterator=set.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());

        }
    }
}*/

/*



public class Test{
    public static void main(String[] args) throws IOException {

        Properties properties=new Properties();
        properties.setProperty("1","haha");
        properties.setProperty("2","hehe");
        properties.setProperty("3","gungun");
        properties.store(new FileOutputStream(new File("D:\\Test.java")),"输出信息");


    }
}*/


/*
* 线程池：
* 两种线程池：
* ThreadPoolExecutor
* ScheduledThreadPoolExecutor
* */
public class Test{
    public static void main(String[] args) {
        //ScheduledThreadPoolExecutor scheduledThreadPoolExecutor=new ScheduledThreadPoolExecutor();
        /*ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                3,
                5,
                1000L,
                TimeUnit.NANOSECONDS,
                new SynchronousQueue<>(),
                new ThreadFactory() {
                    @Override
                    public Thread newThread(Runnable r) {
                        Thread thread=new Thread(r);
                        thread.setName("haha");
                        return thread;
                    }
                },
        new ThreadPoolExecutor.DiscardPolicy()
                );
        for(int i=0;i<5;i++) {
            threadPoolExecutor.execute(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 5; i++) {
                        System.out.println(Thread.currentThread().getName() + " " + i);
                    }
                }
            });
        }*/
        /*ExecutorService threadPoolExecutor=Executors.newSingleThreadExecutor();
        for(int i=0;i<5;i++) {
            threadPoolExecutor.submit(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10;j++)
                    System.out.println(Thread.currentThread().getName()+" "+j);
                }
            });
        }
        threadPoolExecutor.shutdown();*/
        /*ExecutorService executor=Executors.newFixedThreadPool(5);
        for(int i=0;i<5;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10;j++){
                        System.out.println(Thread.currentThread().getName()+" "+j);
                    }
                }
            });
        }
        executor.shutdown();
*/
/*
        ExecutorService executor = Executors.newCachedThreadPool();
        for(int i=0;i<5;i++){
            executor.submit(new Runnable() {
                @Override
                public void run() {
                    for(int j=0;j<10;j++){
                        System.out.println(Thread.currentThread().getName()+" "+j);
                    }
                }
            });
        }
        executor.shutdown();*/
            ScheduledExecutorService scheduledExecutorService=Executors.newScheduledThreadPool(5);
            for(int i=0;i<5;i++){
                scheduledExecutorService.scheduleAtFixedRate()
            }
    }
}