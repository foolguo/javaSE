/**
 * @Author: yd
 * @Date: 2019/3/20 20:38
 * @Version 1.0
 */
//interface ISubject{
//    void test();
//}
////interface ISubject1<P,R>{
////    /*int add(int r1,int r2);*/
////    R switchPara(P p);
////}
////public class Test {
////    public static void main(String[] args) {
////        //方法引用 静态方法
////        ISubject1<Integer,String> stringISubject1=
////                String::valueOf;
////        System.out.println(stringISubject1.switchPara(10)+10);
////    }
////}
//interface ISubject1<R,PI,PS>{
//    /*int add(int r1,int r2);*/
//    R switchPara(PI name,PS age);
//}
//class Person{
//    private String name;
//    private Integer age;
//
//    public Person(String name, Integer age) {
//        this.name = name;
//        this.age = age;
//    }
//    public  String toString(){
//        return "Person{"+"age="+age+",name="+name+'}';
//    }
//}
//public class Test {
//    public static void main(String[] args) {
//        //方法引用 静态方法
//        /*ISubject1<Integer,String> stringISubject1=
//                String::valueOf;
//        System.out.println(stringISubject1.switchPara(10)+10);
//        */
//        /*ISubject1<Integer,String> subject=String::compareTo;
//        System.out.println(subject.switchPara("郭","方"));*/
//        ISubject1<Person,String,Integer> subject1=Person::new;
//        Person per1=subject1.switchPara("guo ",21);
//        System.out.println(per1);
//    }
//}
/*    @FunctionalInterface
interface ISubject<R,P,A>{
    R creatPerson(P name,A age);
}
class Person{
        private String name;
        private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return name+" "+age;
    }
}
public class Test{
    public static void main(String[] args) {
        ISubject<Person ,String,Integer> subject=Person::new;
        Person per=subject.creatPerson("haha",20);
        System.out.println(per);
    }
}*/

@FunctionalInterface
interface ISubject{
    int add(int r1,int r2);
}
public class Test{
    public static void main(String[] args) {
        ISubject subject=(r1,r2)->{
            r1=r1+10;
            r2=r2+10;
            return r1+r2;
        };
        System.out.println(subject.add(10,20));
    }
}