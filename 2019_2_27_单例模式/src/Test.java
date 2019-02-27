/*
class Sun{
    public static Sun sun=new Sun();
    private Sun(){

    }
    public static Sun getInface(){
        return sun;
    }
    public void print(){
        System.out.println("我是太阳");
    }

}
public class Test {
    public static void main(String[] args) {
        Sun.getInface().print();
    }
}
*/


/*
public class Test{
    public static void main(String[] args) {
        String str="hahaha";
        StringBuffer sb=new StringBuffer(str);

    }
}*/

//对象比较
/*class Person{
    private String name;
    private int age;
    public Person(String name,int age)
    {
        this.name=name;
        this.age=age;
    }
    public boolean equals(Object per){
        if(per==null){
            return false;
        }
        if(per==this){
            return true;
        }
        if(!(per instanceof Person)){
            return false;
        }
        per =(Person)per;
        return this.name.equals(((Person) per).name)&&this.age==((Person) per).age;

    }
}
public class Test{
    public static void main(String[] args) {
        Person per1=new Person("1",2);
        Person per2=new Person("1",2);
        if(per1.equals(per2)){
            System.out.println("正确");
        }

    }
}*/

public class Test{
    public static void main(String[] args) {
        Integer a1=100;
        Integer a2=100;
        System.out.println(a1+a2);
        System.out.println(a1==a2);
        String str1=String.valueOf(a1);
        String str2=String.valueOf(a2);
        System.out.println(str1+str2);
        int num=Integer.parseInt(str1);
        System.out.println(num+1);


    }
}