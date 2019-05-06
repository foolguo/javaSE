import java.io.*;

/**
 * @Author: yd
 * @Date: 2019/5/6 8:10
 * @Version 1.0
 */
/*
* 新特性：
* 1.可变参数，（计算多个数相加）
* 2.for-each循环
* 3.静态导入  格式   import static 包名.类名.*;  不推荐这样就不知道是哪个类引用的了
* */
/*import  com.bit.MyClass;
public class Test {
    public static void main(String[] args) {
        add(1,2,4,3,5);
        MyClass.delete();
    }
    public static void add(int... a){
        int sum=0;
        for (int i=0;i<a.length;i++){
            sum+=a[i];
        }
        System.out.println(sum);
    }

}*/
/*
        * JDK 1.5
        * 泛型：为了解决 错误的向下转型带来的 ClassCastException，在使用时在定义类型  T一定是包装类型
        * 1.泛型类<>用diamond表达式修饰    class A<T>{}  类型参数
        * 2.泛型方法<>  泛型方法可自定义类型，并且以自己定义的类型为主   class B<T>{}
* 3.泛型接口 ，子类实现其 可指定类型，也可 不指定类型。
        * 解决了向下转型的问题，还有一个问题，就是参数统一化的问题，由于泛型没有事先定义好类型
        * 所以引入了一种通配符，
        * 1.<?>定义在方法中，接收任意类型
        * 2.<?extend T> 定义在方法和类中，接收T及其子类
        * 3.<?super T>定义在方法中，接收T及其父类
        *
        * 类型擦除：泛型只存在于编译阶段，在进入JVM后会自动查出类型，如果设置了上限，就擦除成上限的
        * 类型，否则为Object。
        *
        *
        * 枚举
        *  注解
        *  @Override
        *  @Deprecated
        *  @SuppressWarning
        * 接口定义加强:新增了静态方法和普通方法   普通方法用default
        * 目的是接口越来越大，但功能不够，如果直接加功能，已经实现其的类就要全部修改，这是个不安全的操作
        * 如果引入普通类就会解决这个问题
        * lamda表达式:函数式编程：实现一个接口，并且这个接口只有一个抽象方法，
        * */
/*
enum Color{
    Red("红"),Blue("蓝"),Green("绿");
    private String title;
    private Color(String title){
        this.title=title;
    }

    @Override
    public String toString() {
        return "Color{" +
                "title='" + title + '\'' +
                '}';
    }
}
public class Test{
    public static void main(String[] args){
        Color red=Color.Red;
        Color blue=Color.Blue;
        Color green=Color.Green;
        System.out.println(red);
    }
}
*/
/*
interface A{
    int print(Integer num);
    public  default  void println(){

    }
    public static void go(){

    }

}
*/

/*
class Color{
    private static  Color Red=new Color("red");
    private static  Color Green=new Color("green");
    private static  Color Blue=new Color("blue");
    private String name;

    private Color(String name) {
        this.name = name;
    }

    public static Color getInstance(String str){
        if("Red".equals(str)){
            return Color.Red;
        }else if("Green".equals(str)){
            return Color.Green;
        }else if("Blue".equals(str)) {
            return Blue;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Color{" +
                "name='" + name + '\'' +
                '}';
    }
}
public class Test{
    public static void main(String[] args) {
        Color red=Color.getInstance("Red");
        System.out.println(red);
    }
}*/
/*public class Test {
    public static void main(String[] args){
       // A a=e-> System.out.println("hello"+" "+e);
        A a=e->{
            e=e+10;
            System.out.println(e);
            return e+12;

        };
        System.out.println(a.print(13));

    }
}*/



/*
class A<T,E>{
    T name;
    E age;

    public A(T name, E age) {
        this.name = name;
        this.age = age;
    }

    public <K> void print(K k){
        System.out.println("这是一个"+k);
    }

    public T getName() {
        return name;
    }

    public E getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "A{" +
                "name=" + name +
                ", age=" + age +
                '}';
    }
}
class Person<T>{
    private T name;

    public Person(T name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                '}';
    }
}
class Test{
    public static void main(String[] args) {
        A<String,Integer> a = new A<>("haha",12);
        System.out.println(a);
        //a.print(a);
        //println(a);
        Person<Integer> person=new Person<>(11);
        println1(person);
    }
    public static void  println1(Person<? extends Number> per){
        System.out.println(per);
    }
    public static void println( A<?,?> e){
        System.out.println(e);

    }
}*/

/*
* IO
* File
* createNewFile
* delete
* lastModify
* mkdirs
* getParent
*File.seprator
*
*                   OutputStream
* 子类：FileOutputStream     ByteArrayOutputStream
*       PrintStream
*                   InputStream
* 子类：FileInputStream     ByteArrayInputStream
*
*                        Writer
* 子类： OutputStreamWriter         CharArrayWriter
*           FileWriter
*
* */

public class Test{
    public static void main(String[] args) throws IOException {
        File file=new File("C:"+File.separator+"Users\\admin\\Desktop\\Test.txt");
        /*if(file.exists()){
            file.createNewFile();
        }else{
            file.delete();
        }*/
       //AllListFile(file);
    /*    OutputStream outputStream=new FileOutputStream(file,true);
        outputStream.write("hahahha".getBytes());
        outputStream.write("hello".getBytes());
        outputStream.close();
        PrintStream outputStream1=new PrintStream(file);
        outputStream1.print(1);
        outputStream1.println('a');
        outputStream1.print(12234);*/
        InputStream inputStream=System.in;
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        byte[] bytes=new byte[20];
        int len=0;
        while((len=inputStream.read(bytes))!=-1){
            bos.write(bytes);
            if(len<bytes.length){
                break;
            }

        }
        System.out.println(bos);


    }




    public static void AllListFile(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            if(file.exists()&&file.isDirectory()){
                File[] files=file.listFiles();
                for (File i:files) {
                    AllListFile(i);
                }
            }
        }
    }
}
