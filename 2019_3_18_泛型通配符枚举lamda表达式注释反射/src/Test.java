import java.lang.reflect.Constructor;
import java.util.Date;

/**
 * @Author: yd
 * @Date: 2019/3/18 18:39
 * @Version 1.0
 */
/*class Person<T,E>{
    private T name;
    private E age;
    public Person(T name, E age) {
        this.name = name;
        this.age = age;
    }

    public T getName() {
        return name;
    }

    public E getAge() {
        return age;
    }
    public <S> S print(S s){
        System.out.println(s);
        return s;
    }

    public void setName(T name) {
        this.name = name;
    }

    public void setAge(E age) {
        this.age = age;
    }
    public String toString(){
        return "name="+this.name+"age="+age;
    }
}
class Student<T>{
    private T  student;

    public void setStudent(T student) {
        this.student = student;
    }

    public T getStudent() {
        return student;
    }
}

class I{
    public static int point(){
        return 10;
    }
}
interface ISubject<T>{

}
class IMessage implements ISubject<String>{

}
class IMessage1<T> implements ISubject<T>{

}
interface MyLamda{
    Person print(String name,Integer age);
}
public class Test {
    public static void main(String[] args) {
        *//*Person<String,Integer> per = new Person<>("String",20);
        System.out.println(per.getName()+" "+per.getAge());
        per.print("hahaha");
        Student<String> stu = new Student<>();
        motify(stu);*//*
        //MyLamda my = "hello"::toLowerCase;
        //System.out.println(my.print());
        //类中普通方法的引用
        *//*MyLamda my1=String::compareTo;
        System.out.println(my1.print("刘","或"));*//*
        Person<String,Integer> per=new Person<>("郭佳玥",21);
        MyLamda iu=Person::new;
        System.out.println(iu.print("guogo",10));

    }


    public static void motify(Student<? super String> per){
        //per.setStudent("HAH");
       // System.out.println(per.getStudent());
//        MyLamda my=()-> {
//         System.out.println("我是最棒的");
//         System.out.println("我一点也不累");
//        };
//        my.print();
        //方法引用  静态方法的引用
//        MyLamda my=String::valueOf;
//        String str=my.print(1);
//        System.out.println(str+"1");
        //对象方法的引用  对象名::方法名


    }
}*/

//反射 工厂模式

/*
interface Computer{
    void buy();
}
class Apple implements Computer{
    @Override
    public void buy() {
        System.out.println("买苹果电脑");
    }
}
class Surface implements Computer{
    @Override
    public void buy() {
        System.out.println("买微软电脑");
    }
}
class Factory{
    public static Computer getInstance(String className){
        try {
            Class<?> com=Class.forName(className);
            try {
                Computer p=(Computer) com.newInstance();
                return p;
            } catch (InstantiationException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
         return null;

    }

}
public class Test{
    public static void main(String[] args) {
        Factory.getInstance("Apple").buy();
    }
}*/
class Person{
    private String name;
    public Person(){}
    private Person(String name){}
}
public class Test{
    public static void main(String[] args) throws NoSuchMethodException {
        Class<?> cls=Date.class;
        System.out.println(cls.getPackage());
        Class<?> cls2=Person.class;
//        System.out.println(cls2.getDeclaredConstructor());

        Constructor<?>[] constructors=cls2.getDeclaredConstructors();
        for(Constructor i:constructors){
            System.out.println(i);
        }
        System.out.println();

    }
}
