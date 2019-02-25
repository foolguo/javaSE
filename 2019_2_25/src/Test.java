
//基本数据类型的赋值
/*public class Test {
    public static void main(String[] args) {
        int a=Integer.MAX_VALUE;
        long b=0;
        b=a+1L;
        System.out.println(b);
        byte c=10;
        short d=10;
        System.out.println(c);
        System.out.println(d);
        float e=Float.MAX_VALUE;
        double g=e+1.2F;
        System.out.println(g);
        char f='A';
        char h='A'+32;
        System.out.println(f);
        System.out.println(h);
    }
}*/

//数组：1.静态初始化，2.动态初始化，3.匿名数组
/*import java.util.Arrays;
public class Test{
    public static void main(String[] args) {
        int[] data1=new int[3];
        for(int i=0;i<data1.length;i++){
            data1[i]=i-3;
        }
        int[] data2=new int[]{1,2,3,4,5,6};
        for (int i:data2
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(new int[]{1,2,3,4,5}.length);
        //数组的几种方法
        Arrays.sort(data1);
        for (int i:data1
             ) {
            System.out.print(i+" ");
        }
        System.out.println();
        //数组部分拷贝
        System.arraycopy(data1,0,data2,2,3);
        for (int i:data2){
            System.out.print(i+" ");
        }
        System.out.println();
        //数组全拷贝，可以对数组进行扩容
        int[] result=new int[]{1,2,3};
        result=Arrays.copyOf(result,10);
        for(int i:result){
            System.out.print(i+" ");
        }
        System.out.println();
        System.out.println(result.length);
    }
}*/

/*
class School{
    private String name;
    private int numTeacher;
    private int numStudent;
    //this()，必须放在构造方法的第一行
    public School(String name){
        this.name=name;
    }
    public School(String name,int numTeacher){//构造方法的重载
        this(name);
        this.numTeacher=numTeacher;
    }
    public School(String name,int numTeacher,int numStudent){
        this(name,numTeacher);
        this.numStudent=numStudent;

        System.out.println(name);
    }
    public void print(){
        System.out.println(this.name);

    }
}
public class Test{
    public static void main(String[] args) {
        School sch=new School("xian",12,23);
        sch.print();
    }
}*/

class Person{
    static {
        System.out.println("per静态块");
    }
    {
        System.out.println("per构造块");
    }
    public Person(){
        System.out.println("per构造方法");
    }
}
class Student extends Person{
    private Person per1=new Person();
    private Person per2=new Person();
    static {
        System.out.println("stu静态块");
    }
    {
        System.out.println("stu构造块");
    }
    public Student(){
        System.out.println("stu构造方法");

    }
    public static void main(String[] args) {
        System.out.println("--start--");
        Student stu1=new Student();
        Student stu2=new Student();
        System.out.println("-- end --");

    }
}