/**
 * @Author: yd
 * @Date: 2019/3/17 20:28
 * @Version 1.0
 */
class Person <T>{
    private T Name;


    public Person(T name) {
        Name = name;

    }
    public T getName() {
        return Name;
    }

    public void setName(T name) {
        Name = name;
    }
}
public class Test {
    public static void main(String[] args) {
        Person<String> per1 = new Person<>("1");
        print(per1);
        Person<Integer> per2 =new Person<>(2);

    }
    public static void print(Person<? super String> per){
        per.setName("abc");
        System.out.println(per.getName()+" "+);
    }

}

