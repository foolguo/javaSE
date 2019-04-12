import java.util.*;

/**
 * @Author: yd
 * @Date: 2019/4/12 17:45
 * @Version 1.0
 */
/*public class Test {
    public static void main(String[] args) {
        Map<Integer,String> map=new HashMap();
        map.put(1,"张三");
        map.put(2,"李四");
        map.put(3,"王五");
        Set<Map.Entry<Integer,String>> entrySet=map.entrySet();
        Iterator<Map.Entry<Integer,String>> iterator= entrySet.iterator();
        while(iterator.hasNext()){
            Map.Entry<Integer,String> entry=iterator.next();
            System.out.println(entry.getKey()+":"+entry.getValue());
        }
    }
}*/

/**
 * 类集：
 * Collection和Map
 * Collection下有两个接口
 * List和Set：
 * List下的方法：
 * add();
 * remove();
 * contains()
 * clear()
 * size()
 *
 * List的直接子类AbstractList
 * ArrayList和LinkedList和Vector
 * 这两个没有什么区别只不过在底层实现是  ArrayList是一个数组LinkedList是一个双向链表
 * 可以有重复元素，不能排序
 *List接口下的方法get   和  set
 * ArrayList的构造方法可以传入类集，直接添加
 * m默认大小10，会自动扩容
 * LinkedList   双向链表
 * 可以addFirst   addLast
 *
 * Set接口两个子类：
 * HashSet     TreeSet
 * 不能有重复元素，
 * TreeSet是排序的；
 *
 */
class Person implements Comparable{
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
    public int  hashCode() {
       return  Objects.hash(name,age);
    }
    public boolean equals(Object o ){
        if(!(o instanceof Person))return false;
        if(o==this){
            return true;
        }
        Person per= (Person) o;
        return Objects.equals(name, per.name) &&
                Objects.equals(age, per.age);
    }

    put
    get
            keyset
    valus
                    entrYset
    public String getName() {
        return name;
    }

    public Integer getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        Person per= (Person) o;
        return (this.age-per.age)*(-1);
    }
    /*@Override
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
    }*/
}
public  class Test{
    public static void main(String[] args) {
     /*   Set<Integer> hashSet = new HashSet<>();
        hashSet.add(1);
        hashSet.add(2);
        hashSet.add(3);
        Iterator<Integer> iterator=hashSet.iterator();
        while(iterator.hasNext()) {
            System.out.println(iterator.next());
        }*/
       /* Set<Person> hashSet = new HashSet<>();
        hashSet.add(new Person("人生",24));
        hashSet.add(new Person("人生",12));
        hashSet.add(new Person("狗逼",3));
        hashSet.add(new Person("go out",67));
        Iterator<Person> iterator = hashSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }*/
  /*     Set<String> treeSet = new TreeSet<>();
       treeSet.add("C");
       treeSet.add("a");
       treeSet.add("A");
       Iterator<String> iterator= treeSet.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());
       }*/
        /*Set<Person> treeSet= new TreeSet<>(new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return (o1.getAge()-o2.getAge())*(-1);
            }
        });*/
        Set<Person> treeSet= new TreeSet<>();
        treeSet.add(new Person("人生",24));
        treeSet.add(new Person("人生",12));
        treeSet.add(new Person("狗逼",3));
        treeSet.add(new Person("go out",67));
        Iterator<Person> iterator =treeSet.iterator();
        while(iterator.hasNext()){
            System.out.println(iterator.next());
        }

        /*LinkedList<Person> linkedList = new LinkedList<>();
        linkedList.add(new Person("oliva",12));
        linkedList.add(new Person("Jack",22));
        linkedList.add(new Person("Rose",18));
        linkedList.addLast(new Person("hahah",13));
        System.out.println(linkedList.toString());
        ListIterator<Person> listIterator = linkedList.listIterator();
        while(listIterator.hasNext()){
            System.out.println(listIterator.next());
        }
        System.out.println();
        while(listIterator.hasPrevious()){
            System.out.println(listIterator.previous());
        }
        List<Integer> al=new ArrayList<>();
        al.add(12);
        al.add(13);
       List<Integer> arrayList=new ArrayList<>(al);
       arrayList.add(1);
       arrayList.add(2);
       arrayList.add(3);
       Iterator<Integer> iterator=arrayList.iterator();
       while(iterator.hasNext()){
           System.out.println(iterator.next());*/
       }
    }
