package com.bit.reflect;

/**
 * @Author: yd
 * @Date: 2019/4/8 15:36
 * @Version 1.0
 */

import java.io.File;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/*
*
 * 1.获取类的Class的对象，三种方法：
 * 1.Object类里面的 getClass() 方法  对象名.getClass();
 * 2.类名.Class
 * 3.利用Class类的  forName()方法
 * 在获取对象后可以用 newInstance()实例化对象
 *
 * 我们获取类的Class对象目的是为了他里面的  方法，构造方法和成员变量
 * 然后：
 * 1.取得构造方法，
 * ·取得指定参数的构造方法：getConstructor()  getDeclaredConstructor()
 * ·取得全部构造方法:getConstructors()   getDeclaredConstructors()'
 * 带有Declared的只可以取得自己声明的所有构造，反之可以取得所有的构造
 * 如果，类中没有无参度构造，用newInstance()实例化对象比较难，要newInstance(指定参数)实例对象
 *
 * 2.取得包名，接口名 父类名
 *
 * 3.取得方法(包括静态方法)
 * 1.取得类中指定参数的方法：getMethod()   getDeclaredMethod()
 * 2.取得所有方法:getMethods() 取得子类父类所有的public方法  getDeclaredMethods()  后者会取得本类中所有权限的方法
 *      在Method里
 *      前者：取得本类父类所有public 属性的方法包括static
 *      后者：取得本类中所有权限的属性，包括static
 *
 *  4.取得属性：
 *  1.取得父类的所有属性：  getFields()
 *  2.取得父类中指定名称属性: getField( String name);
 *  getFields()取得本类父类中所有public属性包括static
 *
 *  3.在本类中取得属性：getDeclaredFields()
 *  4.在本类中取得指定名称属性:getDeclaredField(String name);
 *
 *  set(属性名，传入的值)
 *  get(属性名)*/
public class Test {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
      Person per = new Person();
        Class cls1 = per.getClass();
        Class cls2 = Person.class;
        Class cls3 = Class.forName("com.bit.reflect.Student");
/*        Constructor[] constructors1 =cls2.getConstructors();
        for (Constructor i:constructors1){
            System.out.println(i);
        }
        System.out.println("----------");
        Constructor[] constructors2=cls3.getDeclaredConstructors();
        for (Constructor j:constructors2){
            System.out.println(j);
        }
        System.out.println("-------------");
        Constructor[] constructors3=cls1.getDeclaredConstructors();
        for(Constructor z:constructors3){
            System.out.println(z);}
        //System.out.println(cls1.newInstance());
        System.out.println(cls1.getPackage().getName());
        System.out.println(cls3.getSuperclass().getName());
        System.out.println(cls2.getInterfaces());
        Method[] method1=cls1.getDeclaredMethods();
        for (Method i:method1){
            System.out.println(i);
        }
        System.out.println("---------------------");
        Method[] method2=cls2.getMethods();
        for (Method j:method2){
            System.out.println(j);
        }
        System.out.println("----------------------");
        Method[] method3=cls3.getDeclaredMethods();
        for (Method z:method3){
            System.out.println(z);
        }
        System.out.println("******");
        Method[] method4=cls3.getMethods();
        for (Method l:method4){
            System.out.println(l);
        }
       Constructor constructor=cls1.getConstructor(String.class,Integer.class);
        Object obj=constructor.newInstance("haha",12);
        Method method=cls1.getMethod("getName");
        System.out.println(method.invoke(obj));
        Constructor constructor1=cls2.getConstructor(String.class,Integer.class);
        //System.out.println(constructor==constructor1);
        Object object=constructor1.newInstance("流",99);
        Field field=cls2.getDeclaredField("name");
        Field field1=cls2.getField("age");
        System.out.println(field+"  "+field1);
        field.setAccessible(true);
        field.set(object,"你好");
        field1.set(object,20);
        Method method1=cls2.getMethod("getName");
        System.out.println(method1.invoke(object));
        Method method2=cls2.getMethod("getAge");
        System.out.println(method2.invoke(object));
        System.out.println(field.getType().getName());
        System.out.println(field1.getType().getSimpleName());




        Field[] fields=cls3.getFields();
        for (Field i:fields){
            System.out.println(i);
        }
        System.out.println("------------");*/
        Object object=cls1.getConstructor(String.class,Integer.class).
                newInstance("hah",22);

        Field fields1=cls1.getDeclaredField("name");
        fields1.setAccessible(true);
        System.out.println(fields1.get(object));

    }
}

class Person {
    private String name;
    public Integer age;
    public   static Integer ID;


    public Person() {
    }

    public Person(String name) {
        this.name = name;
    }

    protected Person(Integer age) {
        this.age = age;
    }
    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
    public  static void print(){

    }
}


class Student extends Person{
    private String school;
    private  Student() {
    }

    public Student(String school) {
        this.school = school;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }
}


/*interface Fruit{
    void buy();
}
class Apple implements Fruit{

    @Override
    public void buy() {
        System.out.println("买苹果");
    }
}
class Banana implements Fruit{

    @Override
    public void buy() {
        System.out.println("买香蕉");
    }
}
class Factory{
    public static Fruit getInstance(String classNmae) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Fruit fruit=null;
        Class cls=Class.forName(classNmae);
        fruit= (Fruit) cls.newInstance();
        cls.getConstructors();
        return fruit;
    }
}
public class Test{
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Fruit fruit=Factory.getInstance("com.bit.reflect.Apple");
        fruit.buy();

    }
}*/