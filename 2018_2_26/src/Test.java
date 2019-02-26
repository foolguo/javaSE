/*
public class Test{
        public static void main(String[] args) {
            new B();
            new B();
        }

}
class A {
    static {
        System.out.println("A的静态块");
    }
    private static String staticStr = getStaticStr();
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


}
class B extends A{
    private static String staticStr = getStaticStr();
    static {
        System.out.println("B的静态块");
    }
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
}
*/

/*
public class Test{
    static {
        System.out.println("Test的静态块");
    }
    private static Test t1=new Test();
    private static Test t2=new Test();

    {
        System.out.println("Test构造块");
    }
    public Test(){
        System.out.println("Test构造方法");
    }
    public static void main(String[] args) {
        Test t3=new Test();
    }
}*/


public class Test{
    private static Test t1=new Test();
    private static Test t2=new Test();

    static {
        System.out.println("Test的静态块");
    }

    {
        System.out.println("Test构造块");
    }
    public Test(){
        System.out.println("Test构造方法");
    }
    public static void main(String[] args) {
        Test t3=new Test();
    }
}