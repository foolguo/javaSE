package com.bit.jpc;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @Author: yd
 * @Date: 2019/4/7 19:30
 * @Version 1.0
 */

/**
 * ArrayList实现了List接口，而List接口继承了Collection
 * 类集：类集是一个动态数组，实际上累计就是数据结构的java语言实现
 * 类集下有两个接口，Collection和Map
 * List（保存单个元素）实现了Collection接口，而ArrayList也不是直接实现List接口，而是实现了一个子接口
 * 1.ArrayList保存单个元素
 * 2.set保对存的是键值
 *3.ArrayList数据可以重复（看）
 * LinkedList内部是一个双向链表，方法和那啥一样
 * 还有一个Vector基本不用
 * 和Array区别：前者角度看1.0版本  后者角度看1.2
 * 前者同步操作，线程安全，但性能低，后者异步操作，线程不安全但是性能高
 * 输出形式  ：Iterator，EnumIterator  foreach ListIterator 后者没有EnumIterator
 * 因为Enum是为了Vector实现的
 *
 * Set()实现了Collect接口
 * 有两个类：HashSet  HashTree(没有扩充的方法)
 * 1.不允许有重复对象，对基本类型可以搞定，但对自定义类型比如Person如果不覆写hashCode和
 * equals不能去重
 * 2.后者有序，但是同样的 对于自定义类型 不能进行排序，要指定才可以排序（1.继承Comparable
 *          2 .传入比较器）
 *
 * Map（可以输出多个元素）（Key-Value）
 * 方法：1.put 设置元素 （key不能重复，value可以重复，但是对于自定义类型，要用Compartor）
 * 2.get  取得指定索引的值
 * 3 .keySet  取得所有key
 * 3.values  取得所有value
 * 4.entrySet  将map变成set
 *
 * Map实际上是桶结构， 桶组成为数组和链表  当数组长度大于64并且链表长度大于8，则
 *变成数组和红黑数，
 * 并且会有一个Hash方法自动判断插入的位置，效率高  HashMap内部还有一个负载因子，当实际数组的大小
 * 大于当前数组容量*负载因子，就会自动扩容   这时为了避免hash碰撞
 *
 */
class Person implements Comparable<Person>{
    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
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

    @Override
    public int compareTo(Person o) {

        return o.getAge().compareTo(this.getAge());
    }
}
public class TestArrayList {
    public static void main(String[] args) {
        HashMap<Integer,String> hashMap=new HashMap<>();
        hashMap.put(null,"hsh");
        hashMap.put(5,"gun");
        hashMap.put(null,"null");
        hashMap.put(1,"java");
        hashMap.put(2,"c++");
        System.out.println(hashMap);
        ConcurrentHashMap<Integer,String> hashMap1=

       /*        Set<String> set=new HashSet<>();
        set.add("a");
        set.add("b");
        set.add("c");
        set.add("d");
        set.add("d");//元素不可重复
        System.out.println(set);
        Set<String> setTree= new TreeSet<>(new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return o1.compareTo(o2)*(-1);
            }
        });
        setTree.add("a");
        setTree.add("b");
        setTree.add("c");
        setTree.add("d");
        System.out.println(setTree);
*/
/*       Set<Person> set=new TreeSet<>(new Comparator<Person>() {
           @Override
           public int compare(Person o1, Person o2) {
               return o1.getAge().compareTo(o2.getAge());
           }
       });
       set.add(new Person("jjd",11));
       //不可重复
        set.add(new Person("jjd",90));
        set.add(new Person("jjd",15));
        set.add(new Person("jjd",21));
        System.out.println(set);
        Iterator<Person> iterator=set.iterator();
        while(iterator.hasNext()){
                Person per=iterator.next();

            System.out.println(iterator.next());
        }*/



     /*   List<Person>   list=new ArrayList<>();//无参  默认为10，指定大小，传入一个类集
        list.add(new Person("jack",22));
        list.add(new Person("rose",18));
        list.add(new Person("Tonny",19));
        list.add(new Person("rose",18));

        Iterator<Person> iterable=list.iterator();
       while(iterable.hasNext()){
           System.out.println(iterable.next());
       }*/
  /*      list.add(4);
        list.add(1);
        list.add(2);
        list.add(2);
        List<Integer> list1=new ArrayList<>(list);
        list.add(10);
        list.add(9);
        list.add(8);
        System.out.println(list);

        list.remove(1);
        System.out.println(list);
        System.out.println("是否包含元素"+list.contains(9));*/

       /* List<Integer> list=new LinkedList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.set(1,10);
        System.out.println(list);*/




    }
}
