import java.io.*;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/4/28 17:02
 * @Version 1.0
 */
/*
public class Test {
    public static void main(String[] args) throws IOException {
      */
/*  File file=new File("D:\\Test.txt");
        if(file.exists()&&file.isFile()){
            file.delete();
        }else{
            file.createNewFile();
        }*//*

      File file=new File("C:\\Users\\admin\\Desktop");
        System.out.println(Thread.currentThread().getName()+"开始");
        new Thread(new Runnable(){

            @Override
            public void run() {
                AllListFiles(file);
            }
        }).start();
        System.out.println(Thread.currentThread().getName()+"结束");

    }
    public static void AllListFiles(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            if(file.exists()&&file.isDirectory()){
                File[] file1=file.listFiles();
                for (File i:file1){
                    AllListFiles(i);
                }
            }
        }

    }

}
*/

/*
public class Test{
    public static void main(String[] args) throws IOException {
//        File file=new File("D:\\hello\\world\\Test.txt");
//        if (file.exists()&&file.isFile()){
//            System.out.println(file);
//        }else{
//            file.getParentFile().mkdirs();
//            file.createNewFile();
//        }
//        FileOutputStream fileOutputStream=new FileOutputStream(file);

*/
/*       File file=new File("D:\\Test.txt");
       InputStream inputStream=new FileInputStream(file);
       //byte[] data=new byte[1024];
       int len=0;
       while((len=inputStream.read())!=-1){
           System.out.println();
       }
       inputStream.close();
       Writer writer=new FileWriter(file);
       Reader reader=new FileReader(file);
       Writer writer1=new OutputStreamWriter(new FileOutputStream(file));
        Reader reader1=new InputStreamReader(new FileInputStream(file));
        ByteArrayInputStream*//*

        InputStream inputStream=new ByteArrayInputStream("String".getBytes());
        OutputStream outputStream=new ByteArrayOutputStream();
        int len=0;
        while(true){
             len=inputStream.read();
             if(len==-1){
                 break;
             }
             outputStream.write(Character.toUpperCase(len));
        }
        System.out.println(outputStream);
        inputStream.close();
        outputStream.close();
    }
    public static void AllListFiles(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            if(file.exists()&&file.isDirectory()){
                File[] files=file.listFiles();
                for(File i:files){
                    AllListFiles(file);
                }
            }
        }
    }
}*/
/*

public class Test{
    public static void main(String[] args) throws IOException {
     */
/*   InputStream byteArrayInputStream=new ByteArrayInputStream("hello world".getBytes());
        OutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        int len=0;
        while((len=byteArrayInputStream.read())!=-1){
            byteArrayOutputStream.write(Character.toUpperCase(len));
        }
        System.out.println(byteArrayOutputStream);
        byteArrayInputStream.close();
        byteArrayOutputStream.close();*//*



    }
}*/

/*
* 文件拷贝：
* */

/*
public class Test{
    public static void main(String[] args) throws IOException {
        File file1=new File("C:\\Users\\admin\\Desktop\\IDEA激活码.txt");
        File file2=new File("C:\\Users\\admin\\Desktop\\IDEA激活码1.txt");
        InputStream inputStream=new FileInputStream(file1);
        OutputStream outputStream=new FileOutputStream(file2);

        int len=0;
        while((len=inputStream.read())!=-1){
            outputStream.write(len);
        }
        inputStream.close();
        outputStream.close();
    }
}*/

/*
* 1.打印流：
* 解决问题：
* 字节流只可以输出字符所以有了打印流来输出各种类型
* */
/*
class PrintUtil{
    OutputStream outputStream;
    public PrintUtil(OutputStream outputStream) {
        this.outputStream = outputStream;
    }
    public void print(String str) throws IOException {
        outputStream.write(str.getBytes());
    }
    public void println(String str) throws IOException {
        print(str+"\r\n");
    }
    public void print(int num) throws IOException {
        print(String.valueOf(num));
    }
    public void println(int num) throws IOException {
        println(String.valueOf(num));
    }
}
public class Test{
    public static void main(String[] args) throws IOException {
        File file=new File("C:\\Users\\admin\\Desktop\\Test.txt");
        OutputStream outputStream=new FileOutputStream(file,true);
        PrintStream printUtil=new PrintStream(outputStream);
        printUtil.println("hehe");
        printUtil.println(1909);
        printUtil.print("你好");
        outputStream.close();
    }
}*/

/*

系统输出：System.out实际上是一个PrintStream实例对象
out是System中的final static 对象 所以
out.可以调用print输出
还有System.in//它是InputStream实例对象
System.error

System相当于拿到终端对象（显示器，键盘）

* 系统输入：
* 三种方式
* 1.取得终端对象
* 2.创建一个数组
* 3.使用终端对象.read()读取数据
* //但这样做有局限，有可能数组数据不够，所以有另一种方式
*   BufferedReader是一个 buff对象，要传入一个字符输入流，所以要用转换流将其装换
*   还有，它只能入字符串
*     他是java.util包的数据
*   所以有Scanner输入数据
*
*
* */

/*
public class Test{
    public static void main(String[] args) throws IOException {
        InputStream inputStream=System.in;
        ByteArrayOutputStream byteArrayOutputStream=new ByteArrayOutputStream();
        byte[] data=new byte[10];
        int len=0;
        System.out.println("请输入数据");
        while((len=inputStream.read(data))!=-1){
            byteArrayOutputStream.write(data,0,len);
            if(len<data.length){
                break;
            }
        }
        System.out.println(new String(byteArrayOutputStream.toByteArray()));
        inputStream.close();
        byteArrayOutputStream.close();
    }
}*/

/*
public class Test{
    public static void main(String[] args) throws IOException {
      */
/*  BufferedReader buff=new BufferedReader(new InputStreamReader(System.in));
        String str=buff.readLine();
        System.out.println("输入信息"+str);*//*

      Scanner scanner=new Scanner(System.in);
        String str = null;
        System.out.println("请输入内容");
      if(scanner.hasNext()){

          str = scanner.next();
      }
        System.out.println(str);
    }
}*/

/*
* 序列化：
* ObjectOutputStream
* ObjectInputStream
* */
/*class Person{}
public class Test{
    public static void main(String[] args) throws IOException {
        ObjectOutputStream oos=new ObjectOutputStream(new FileOutputStream(new File("C:\\Users\\admin\\Desktop\\Text.txt")));
        oos.writeObject(new Person());

    }
}*/



/*public class Test{
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                File file=new File("D:\\Test.txt");
                ListAllFiles(file);

            }
        }).start();
    }
    public static void ListAllFiles(File file){
        if(file.isFile()){
            System.out.println(file);
        }else{
            if(file.exists()&&file.isDirectory()){
                File[] files=file.listFiles();
                for(File i:files){
                    ListAllFiles(i);
                }
            }
        }
    }
}*/


public class Test{
    public static void main(String[] args) throws FileNotFoundException {
        /*PrintStream printStream=new PrintStream(new FileOutputStream(new File("D:\\Test.txt")));
        printStream.println("haha");
        printStream.print(100);
        printStream.print(10.1010);*/


    }
}