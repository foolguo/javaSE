/*
import java.io.*;

*/

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/4/13 10:51
 * @Version 1.0
 *//*

class Teacher implements Serializable{
    private  String name;
    private transient String job;


    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
class  Student implements Serializable{
    private  String name;
    private  Integer age;
    private Teacher teacher;
    public Student(String name, Integer age,Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher=teacher;
    }

    public Student cloneObject() throws Exception  {
        //
        ByteArrayOutputStream  bos=new ByteArrayOutputStream();
        ByteArrayInputStream bis=new ByteArrayInputStream(this.toString().getBytes());

        ObjectOutputStream oss=new ObjectOutputStream(bos);
        oss.writeObject(this);
        ObjectInputStream ois= new ObjectInputStream(bis);
        return (Student) ois.readObject();
    }

    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
public class Test {
    public static void main(String[] args) throws CloneNotSupportedException {
        Teacher teacher=new Teacher("lala","Java Teacher");
        Student student1=new Student("Jack",22,teacher);

        Student student2= (Student) student1.clone();
        System.out.println(student1);
        System.out.println(student2);
        System.out.println(student1==student2);
        System.out.println("=================");
        System.out.println(student2.getName());
        System.out.println(student2.getAge());
        System.out.println(student2.getTeacher().getName());
        System.out.println(student2.getTeacher().getJob());
        System.out.println("====================");
        System.out.println(teacher==student2.getTeacher());
        System.out.println(student1.getAge()==student2.getAge());
    }
}

public class  Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher tea = new Teacher("鬼灯","辅佐官");
        Student stu=new Student("阎魔大人",10000000,tea);
        File file=new File("D:\\Test.text");
        OutputStream outputStream=new FileOutputStream(file);
        ObjectOutputStream oss= new ObjectOutputStream(outputStream);
        oss.writeObject(stu);
        oss.close();
        outputStream.close();
        InputStream inputStream=new FileInputStream(file);
        ObjectInputStream iss=new ObjectInputStream(inputStream);
        Student stu1= (Student) iss.readObject();
        System.out.println(stu1.toString());
        System.out.println(tea==stu1.getTeacher());
    }
}
*/
   /* class OOMTest {
        private  int length=1;
        public void stack(){
            length++;
            this.stack();
        }

    public int getLength() {
        return length;
    }
}
public  class  Test{
    public static void main(String[] args) {
        OOMTest oomTest=new OOMTest();
        try {
            oomTest.stack();
            }catch (Throwable e){
            e.printStackTrace();
            System.out.println(oomTest.getLength());
        }

    }
}*/

   /*
   深浅拷贝：进行深浅拷贝必须要进行 Cloneable接口的实现
   浅拷贝：对象拷贝一份新的但是里面的内容不会进行拷贝
   问题，只要一个引用对对象值进行修改，那么全部就改了
   牵一发而动全身
   深拷贝：对对象进行拷贝，并且对对象里的对象也进行拷贝
   1.同过继承Cloneable接口对其进行拷贝，一种递归的拷贝，如果对象内的对象还有对象 那么要不断进行拷贝
   2.通过序列化进行拷贝，
   顺带一提Serializable和Cloneable接口内都没有实际的方法，只是一个标志接口
    */
/*   class Teacher implements Serializable {
    private String name;
    private String job;

    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
class Student implements Serializable{
    private String name;
    private int age;
    private  Teacher teacher;

    public Student(String name, int age, Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher = teacher;
    }
    public  Student cloneObject() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ByteArrayInputStream bis=new ByteArrayInputStream(this.toString().getBytes());
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(bos);

        objectOutputStream.writeObject(this);
        ObjectInputStream objectInputStream=new ObjectInputStream(bis);
        return (Student) objectInputStream.readObject();
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }

    public Teacher getTeacher() {
        return teacher;
    }
}

public class Test{
    public static void main(String[] args) throws Exception {
        Teacher teacher=new Teacher("鬼灯大人","辅佐官");
        Student student=new Student("阎魔大人",10000,teacher);
        Student studentClone = student.cloneObject();
        Student stu1= (Student) student.cloneObject();
        System.out.println(stu1.toString());

        //取得内存流；
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ByteArrayInputStream bis=new ByteArrayInputStream(student.toString().getBytes());
        //创建序列化对象
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(bos);
        ObjectInputStream objectInputStream=new ObjectInputStream(bis);
        objectOutputStream.writeObject(student);
        System.out.println(objectInputStream.readObject().toString());



    }
}*/
class Teacher implements Serializable{
    private  String name;
    private String job;


    public Teacher(String name, String job) {
        this.name = name;
        this.job = job;
    }

    public String getName() {
        return name;
    }

    public String getJob() {
        return job;
    }


    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }
}
class  Student implements Serializable{
    private  String name;
    private  Integer age;
    private Teacher teacher;
    public Student(String name, Integer age,Teacher teacher) {
        this.name = name;
        this.age = age;
        this.teacher=teacher;
    }
    public Student cloneObject() throws Exception  {
        ByteArrayOutputStream  bos=new ByteArrayOutputStream();
        ByteArrayInputStream bis=new ByteArrayInputStream(this.toString().getBytes());

        ObjectOutputStream oss=new ObjectOutputStream(bos);
        oss.writeObject(this);
        ObjectInputStream ois= new ObjectInputStream(bis);
        return (Student) ois.readObject();
    }
    public String getName() {
        return name;
    }
    public Integer getAge() {
        return age;
    }
    public Teacher getTeacher() {
        return teacher;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", teacher=" + teacher +
                '}';
    }
}
public class  Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher tea = new Teacher("鬼灯","辅佐官");
        Student stu=new Student("阎魔大人",10000000,tea);
        File file=new File("E:\\ Test.txt");
        OutputStream outputStream=new FileOutputStream(file);
        ObjectOutputStream oss=new ObjectOutputStream(outputStream);
        oss.writeObject(stu);
        outputStream.close();
        InputStream inputStream=new FileInputStream(file);
        ObjectInputStream oii=new ObjectInputStream(inputStream);
        System.out.println(oii.readObject().toString());



        /*//File file=new File("D:\\Test.text");
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ByteArrayInputStream bis=new ByteArrayInputStream(stu.toString().toByteArray());
        ObjectOutputStream oss= new ObjectOutputStream(bos);
        ObjectInputStream objectInputStream=new ObjectInputStream(bis);
        System.out.println(objectInputStream.readObject());
        bos.close();
        bis.close();
        objectInputStream.close();
        objectInputStream.close();*/

    }
}
