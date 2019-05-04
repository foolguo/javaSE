import java.io.*;
import java.util.Properties;

/**
 * @Author: yd
 * @Date: 2019/5/4 19:23
 * @Version 1.0
 */

/*
* 深浅拷贝（克隆）
两种方式，第一种继承Cloneable
每个父类也要覆写clone的方法
* */

/*class Teacher implements Cloneable{
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

    public Object clone() throws CloneNotSupportedException {
        Teacher teacher=null;
        teacher= (Teacher) super.clone();
        return teacher;
    }
}
class  Student implements Cloneable{
    private String name;
    private String dept;
    private Teacher teacher;
    public Student(String name, String job, Teacher teacher) {
        this.name = name;
        this.dept = dept;
        this.teacher=teacher;
    }

    public Object clone() throws CloneNotSupportedException {
        Student student=null;
        student=(Student) super.clone();
        student.teacher= (Teacher) teacher.clone();
        return student;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", teacher=" + teacher +
                '}';
    }
}
public class Test {
    public static void main(String[] args) {
        Teacher teacher=new Teacher("章子怡","演电影");
        Student student=new Student("彭昱畅","hah",teacher);
        System.out.println(student);
    }
}*/

/*class Teacher implements Serializable {
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
    private String dept;
    private  Teacher teacher;

    public Student(String name, String dept, Teacher teacher) {
        this.name = name;
        this.dept = dept;
        this.teacher = teacher;
    }
    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", dept='" + dept + '\'' +
                ", teacher=" + teacher +
                '}';
    }
    public Student cloneObject() throws IOException, ClassNotFoundException {
        ByteArrayOutputStream bos=new ByteArrayOutputStream();
        ObjectOutputStream oos=new ObjectOutputStream(bos);
        oos.writeObject(this);
        ByteArrayInputStream bis=new ByteArrayInputStream(bos.toByteArray());
        ObjectInputStream ois = new ObjectInputStream(bis);
        Student stu = (Student) ois.readObject();
        return stu;
    }
}
public class Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher=new Teacher("章子怡","演电影");
        Student student=new Student("彭昱畅","hah",teacher);
        Student student1=student.cloneObject();
        System.out.println(student1);
    }
}*/
/*
* 1.序列化和反序列化：
*
* */
/*class Teacher implements  Serializable{
    private String name;
    private int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
public class Test{
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Teacher teacher=new Teacher("haha",12);
        OutputStream outputStream=new FileOutputStream(new File("D:\\Test.java"));
        ObjectOutputStream objectOutputStream=new ObjectOutputStream(outputStream);
        objectOutputStream.writeObject(teacher);
        outputStream.close();
        objectOutputStream.close();
        InputStream inputStream=new FileInputStream(new File("D:\\Test.java") );
        ObjectInputStream objectInputStream=new ObjectInputStream(inputStream);
        Teacher teacher1= (Teacher) objectInputStream.readObject();
        System.out.println(teacher1);
    }
}*/


/*public class Test{
    public static void main(String[] args) throws IOException {

        Properties properties=new Properties();
        properties.setProperty("1","女神");
        Writer outputStream=new FileWriter(new File("D:\\Test.txt"));
        properties.store(outputStream,"人才");
        outputStream.close();
    }
}*/

public class Test{
    public static void main(String[] args) {
        int[] data=new int[]{3,4,1,2,7,5,6};
        quickSort(data);
        for (int i:data){
            System.out.println(i+" ");
        }
    }
    public static void quickSort(int[] data){
        int len=data.length;
        if(len==1){
            return;
        }else{
            quickSortInternal(data,0,len-1);
        }
    }
    public static void quickSortInternal(int[] data,int left,int right){
        if (left>=right){
            return;
        }
        int q= partition3(data,left,right);
        quickSortInternal(data,left,q);
        quickSortInternal(data,q+1,right);
    }
public static int partition1(int[] data,int left,int right){
        int j=left;
    int value=data[left];
        for (int i=left+1;i<=right;i++){
        if(data[i]<value){
            swap(data,i,j+1);
            j++;
        }
    }
    swap(data,left,j);
        return j;
}

public static int partition2(int[] data,int left,int right){
        int i=left+1,j=right;
        int value=data[left];
        while(true){
            while(i<=right&&value>data[i])i++;
            while(j>=left+1&&value<data[j]) j--;
            if(i>j){
                break;
            }
            swap(data,i,j);
            i++;
            j--;
        }
        swap(data,j,left);
        return j;
}
public static int partition3(int[] data,int left,int rigth){
        int i=left+1,lt=left,gt=rigth+1;
        int value=data[left];
        while(i<gt){
            if(data[i]<value){
                swap(data,i,lt+1);
                lt++;
                i++;
            }else if (data[i]>value){
                swap(data,i,gt-1);
                gt--;
            }else{
                i++;
            }
        }
        swap(data,lt,left);
         return lt;
}










/*    public static int partition1(int[] data,int left,int right){
        int j=left;
        int value=data[left];
        for(int i=left+1;i<=right;i++){
            if(data[i]<value){
                swap(data,i,j+1);
                j++;
            }
        }
        swap(data,left,j);
        return j;}*/
    public static  void swap(int[] data,int i,int j){
        int temp=data[i];
        data[i]=data[j];
        data[j]=temp;
    }
}