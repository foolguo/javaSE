/*

public class A {
    private static String staticStr = getStaticStr();
    static {
        System.out.println("A的静态块");
    }

    private String str = getStr();
    {
        System.out.println("A的实例块");
    }
    public A() {
        System.out.println("A的构造方法");
    }
    private static String getStaticStr() {
        System.out.println("A的静态属性初始化");
        return null;
    }
    private String getStr() {
        System.out.println("A的实例属性初始化");
        return null;
    }
    public static void main(String[] args) {
        new B();
        new B();
    }

}
class B extends A{

    static {
        System.out.println("B的静态块");
    }
    private static String staticStr = getStaticStr();
    {
        System.out.println("B的实例块");
    }
    public B() {
        System.out.println("B的构造方法");
    }
    private String str = getStr();
    private static String getStaticStr() {
        System.out.println("B的静态属性初始化");
        return null;
    }
    private String getStr() {
        System.out.println("B的实例属性初始化");
        return null;
    }
}*/
