//内部类:
/*
1.什么是内部类：内部类就是在类中嵌套其他类的的结构
        2.为什么存在内部类：
        1.内部类可以直接访问外部类的成员变量
        2.内部类对于包中其他类完全隐藏
        3.内部类弥补了Java中单继承的缺点；
        3.内部类和外部类的关系：
        1.对于非静态内部类而言，内部类的创建是依赖外部类的
        2.和外部类不是is-a 关系
        3.直接访问外部类*/


/*
class Outter{
    private String name="haha";
    class Inner{
        private String age="10";
        public void print(){
            System.out.println(name);
        }
    }
    public void print(){
        Inner in=new Inner();
        in.print();
    }
}
public class Test{
    public static void main(String[] args) {
        Outter out=new Outter();
        out.print();
    }
}*/

/*
class Outter{
    private static String name="haha";
    static class Inner{
        private String age="10";
        public void print(){
            System.out.println(name);
        }
    }
    public void print(){
        Inner in=new Inner();
        in.print();
    }
}
public class Test {
    public static void main(String[] args) {
        */
/*Outter out=new Outter();
        out.print();*//*

        Outter.Inner in=new Outter.Inner();
        in.print();
    }
}*/

//final

/*
public class Test{
    public static void main(String[] args) {
        final byte a1=10,b1=20,c1=30;
        byte a2=10,b2,c3;
        b2=b1+c1;
        c3=a1+a2;

    }
}*/

/*
abstract class  A{
    public A(){
        this.print();
    }
    abstract public void print();
}
class B extends A{
    private int num=100;
    public B(int num){
        this.num=num;
    }
    @Override
    public void print() {
        System.out.println(this.num);
    }
}
public class Test{
    public static void main(String[] args) {
        B b=new B(30);
        b.print();
    }
}*/

import java.util.Scanner;

abstract class Drink{
    public void boil(){
        System.out.println("烧水");
    }
    public void pour(){
        System.out.println("将饮料倒入杯子中");
    }
    abstract public void brew();
    abstract public void add();
    final public void prepare(){
        boil();
        brew();
        pour();
        add();
    }
}
class Tea extends Drink{
    public void brew(){
        System.out.println("泡茶");
    }
    public void add(){
        System.out.println("加入柠檬");
    }
}
class Coffee extends Drink{
    public void brew(){
        System.out.println("冲咖啡");
    }
    public void add() {
        if (ifadd()) {
            System.out.println("加糖");
        }
    }
    public boolean ifadd(){
        String str=getAnswer();
        if("y".equals(str)){
            return true;
        }
        return false;
    }
    private String getAnswer(){
        String answer=null;
        System.out.println("是否加糖y/n");
        Scanner scanner=new Scanner(System.in);
        answer=scanner.nextLine();
        return answer;
    }


}
public class Test{
    public static void main(String[] args) {
        Drink tea = new Tea();
        tea.prepare();
        Drink coffee = new Coffee();
        coffee.prepare();
    }
}