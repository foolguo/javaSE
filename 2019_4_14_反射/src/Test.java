import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.MessageFormat;
import java.util.Map;

/**
 * @Author: yd
 * @Date: 2019/4/14 19:23
 * @Version 1.0
 */
class Person{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    public Person() {
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
    private String dept;

    public Student(String name, String dept) {
    }

    public Student() {
        super();
    }

    public String getSchool() {
        return school;
    }


    public void setSchool(String school) {
        this.school = school;
    }
}
/*public class Test {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException, NoSuchFieldException {
        Class cls1=Class.forName("Person");
        Class cls2=Class.forName("Student");
       *//* System.out.println(cls3.getName());
        System.out.println(cls1.getSuperclass().getName());
        System.out.println(cls3.getPackage());*//*
        *//*
            取得构造：

         *//*
       *//* Constructor[] constructor1=cls1.getConstructors();
        for (Constructor i:constructor1){
            System.out.print("【"+i.getName()+"】");
        }
        System.out.println();
        Constructor[] constructors2 = cls3.getDeclaredConstructors();
        for (Constructor i:constructors2){
            System.out.print("【"+i+"】");
        }*//*
      *//*  Constructor constructor = cls1.getDeclaredConstructor();
       Constructor constructor1=cls1.getConstructor();
       System.out.println(constructor1);*//*
  *//*    Constructor constructor=cls2.getConstructor();
        Student student= (Student) constructor.newInstance();
        Method method=cls2.getMethod("setSchool",String.class);
        method.invoke(student,"先工程大");
        System.out.println(student.getSchool());*//*
       *//* Constructor constructor=cls1.getConstructor();
        Person person= (Person) constructor.newInstance();
        Field field=cls1.getDeclaredField("name");
        field.setAccessible(true);
        field.set(person,"新之助");
        System.out.println(field.get(person));*//*

    }
}*/
/*
反射工程模式
 */
class
public class Test{
    public static void main(String[] args) {

    }
}