import java.util.*;

/**
 * @Author: yd
 * @Date: 2019/5/7 9:31
 * @Version 1.0
 */
/*public class Test {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<>();
        list.add("1");
        list.add("3");
        list.add("6");
        list.add("2");
        Iterator<String> iterator=list.iterator();
        while(iterator.hasNext()){
            String i=iterator.next();
            if(i.equals("6")){
                list.remove("6");
                continue;
            }
            System.out.println(i);
        }

    }
}*/

/*
class Person {
    private String name;
    private int age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    @Override
    public int hashCode(){
        return super.hashCode();
    }


    @Override

    public boolean equals(Object o){
        if(this==o)return true;
        if(o==null&&getClass()!=o.getClass())return false;
        Person person=(Person) o;
        return  Objects.equals(name,person.name)&&Objects.equals(age,person.age);
    }

  */
/*  @Override
    public int compareTo(Object o) {
        return age-((Person) o).age;
    }
*//*

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public int getAge() {
        return age;
    }
}
public class Test{
    public static void main(String[] args) {
        TreeSet<Person> treeSet = new TreeSet(new Comparator() {
            @Override
            public int compare(Object o1, Object o2) {
                Person per1=(Person) o1;
                Person per2=(Person) o2;
                return per2.getAge()-per1.getAge();
            }
        });
        treeSet.add(new Person("jack",12));
        treeSet.add(new Person("jack",12));
        treeSet.add(new Person("rose",10));
        treeSet.add(new Person("ahha",9));
        System.out.println(treeSet);

    }
}*/

public class Test{
    public static void main(String[] args) {
        HashMap
    }
}