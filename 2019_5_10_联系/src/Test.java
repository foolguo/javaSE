import java.io.*;
import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author: yd
 * @Date: 2019/5/10 16:58
 * @Version 1.0
 */

/*
class Person{
    private String name;
    private Integer age;
    public Person(){}
    private Person(String name) {
        this.name = name;
    }

     Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
class Student extends Person{
    private String school;
    public Student(){}
    private Student(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
    private static void print(){}
}
public class Test{
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        Class cls1=Class.forName("Person");
        Class cls2=Class.forName("Student");
       */
/* Method[] method1=cls2.getMethods();
        for (Method i:method1){
            System.out.println(i);
        }
        System.out.println("------------------");
        Method[] methods2=cls2.getDeclaredMethods();
        for (Method i:methods2){
            System.out.println(i);
        }
        System.out.println("------------------");

        Method method3=cls2.getDeclaredMethod("print");
        System.out.println(method3);
        Method method4=cls2.getMethod("getSchool");
        System.out.println(method4);
        Person person= (Person) cls2.newInstance();
        System.out.println(method4.invoke(person));*//*

        */
/*Constructor constructor1=cls1.getConstructor();
        System.out.println(constructor1);
        Constructor constructor2=cls1.getDeclaredConstructor(String.class,Integer.class);
        System.out.println(constructor2);
        Constructor[] constructor3=cls2.getConstructors();
        for (Constructor i:constructor3){
        System.out.println(i);}
        Constructor[] constructors4=cls2.getDeclaredConstructors();
        for (Constructor i:constructors4){
            System.out.println(i);}*//*



    }
}*/


/*
* 深浅拷贝
* */

/*class Teacher implements Cloneable{
    private String name;
    private String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    protected Object clone() throws CloneNotSupportedException {
        Teacher teacher= (Teacher) super.clone();
        return teacher;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
class Student implements Cloneable{
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }

    protected Student clone() throws CloneNotSupportedException {
        Student student= (Student) super.clone();
        this.teacher= (Teacher) teacher.clone();
        return student;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}*/

/*
class Teacher implements  Serializable{
    private String name;
    private String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }
*/
/*
    @Override
    protected Object clone() throws CloneNotSupportedException {
        Teacher teacher= (Teacher) super.clone();
        return teacher;
    }*//*


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
class Student implements Serializable {
    private String name;
    private Integer age;
    private Teacher teacher;

    public Student(String name, Integer age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
    public Student objectClone(Student student) throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(student);
        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois=new ObjectInputStream(bis);
        return (Student) ois.readObject();
    }
    */
/*protected Student clone() throws CloneNotSupportedException {
        Student student= (Student) super.clone();
        this.teacher= (Teacher) teacher.clone();
        return student;
    }*//*

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
public class Test{
    public static void main(String[] args) throws CloneNotSupportedException, IOException, ClassNotFoundException {
        Teacher teacher=new Teacher("老王","数学老师");
        Student student=new Student("老张",11,teacher);
        Student student1=student.objectClone(student);
        System.out.println(student1);
    }
}*/
class Goods{
    private String name;
    private int count;
    private Lock lock=new ReentrantLock();
    private Condition producer=lock.newCondition();
    private Condition consumer=lock.newCondition();
    private int maxSize;

    public Goods(int maxSize) {
        this.maxSize = maxSize;
    }
    public void producer(String name) throws InterruptedException {
        lock.lock();
        try{
            while(count==maxSize){
                producer.await();
            }
            Thread.sleep(1000);
            this.name=name;
            count++;
            System.out.println(Thread.currentThread().getName()+"生产了"+toString());
            consumer.signalAll();
        }finally {
            lock.unlock();
        }
    }
    public void consumer() throws InterruptedException {
        lock.lock();
        try{
            while (count<maxSize){
                consumer.await();
            }
            count--;
            System.out.println(Thread.currentThread().getName()+"消费了"+toString());
            producer.signalAll();
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
class Produce implements Runnable{
    private Goods goods;

    public Produce(Goods goods) {
        this.goods = goods;
    }
    @Override
    public void run() {
     while(true){
         try {
             goods.producer("爱马仕");
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
     }
    }
}

class Consumer implements Runnable{
    private Goods goods;

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

    public Consumer(Goods goods) {
        this.goods = goods;
    }
}


public class Test{
    public static void main(String[] args) {

    }
}
