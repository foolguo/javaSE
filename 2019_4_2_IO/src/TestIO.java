/**
 * @Author: yd
 * @Date: 2019/4/2 11:39
 * @Version 1.0
 *//*
 */
/*


import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

*//*

 */
/**
 * 首先IO是对文件的操作  全在 java.io的类
 * 五个方面：1.File类，普通类，用于获取文件对象，里面常用的方法
 *              有一个常量 File.separator 来表示常量
 *                  createNewFile()创建一个新文件
 *                    exists()  判断file对象是否存在
 *                    getFileParent()  获取文件的父目录对象
 *                    getParent()  获取文件名
 *                    mkdirs()  创建多级父目录
 *                    mkdir（）  创建单级父目录
 *                    isFile()  该文件是否是一个文件
 *                    isDirectory()  该文件是否是一个目录
 *                   length()  取得文件大小
 *                   lastModified()  文件最后一次修改日期
 *                   listFiles()   获取路径全部目录
 *
 *            2.OutputStream（抽象类）  文件输出字节输出流
 *            主要用于视频图片，等输入输出（通常所说的流媒体就是说的是这些）
 *
 *                  取得文件的输出流  OutputStream out = new FileOutputStream(file)
 *                  或者   Output out = new OutputStream(file,true);  不覆盖追加
 *
 *                   里面有一个方法 :及其重载
 *                                    write（byte[]  bytes）  输出字节数组的全部内容
 *                                    write(byte[] bytes ,int off,int len )  输出字节数组的步伐内容
 *                                    write(int b); //一次一个字节处处字节数组的内容
 *                     关闭流  close()
 *             3.InputStream(抽象类)     文件输入终端
 *                         取得文件的输入字节流
 *                         InputStream in=new FileInputStream(file)
 *                          int read(byte[] data);//里面的byte数组相当于一个缓冲区，
 *                          read方法的返回值有三种，
 *                          1.data.length  这时的缓存区小于文件的长度
 *                          2.返回文件剩余长度  这时缓存区大于文件长度
 *                          3.返回-1，这时文件读取完成
 *
 *                          就是一次可以读取多少个字节
 *              关闭流   close()
 *             4.Writer(抽象类)   字符输出流  (对中文友好，不是原生操作，中间有一个OutputS)
 *                  Write write = new FileWriter(file);
 *                  字符输入流有一个方法  void write(String str)
 *                  write.close()    如果不关闭的话进行强制刷新  write.flush()
 *             5.Reader(抽象类)   字符输入流
 *                    Read read = new FileRead(file);
 *                    int read(char[] data)
 *                    read.close()
 *                    和上面一样
 *
 *//*
 */
/*

public class TestIO {
    public static void main(String[] args) throws IOException {
       *//*

 */
/* File file = new File("C:"+File.separator+"Users"+File.separator+"admin"
                +File.separator+"Desktop"+File.separator+"www"+File.separator+"hahaha"+
                File.separator+"Fight.java");
        *//*
 */
/*
 *//*

 */
/*if(!file.getParentFile().exists()){
            file.getParentFile().createNewFile();
        }*//*
 */
/*
 *//*

 */
/*
        OutputStream out= new FileOutputStream(file);
        out.write("我是一个粉刷匠".getBytes());
        out.close();

        if(file.exists()&&file.isFile()){
            System.out.println(file.lastModified());
            System.out.println(file.length());
        }*//*
 */
/*

        File file1=new File("C:\\Users\\admin\\Desktop");
        allFile(file1);
    }
    public static void allFile(File file) throws  IOException{
        if(file.isFile()){
            System.out.println(file);
        }else {
            if (file.exists() && file.isDirectory()) {
                File[] list = file.listFiles();
                for (File i : list) {
                    allFile(i);
                }
            }
        }
    }

}
*//*


import java.io.*;

*/
/**
 * OutputStream  输出字节流
 *//*

 */
/*
public class TestIO {
    public static void main(String[] args) throws IOException {
*//*

        //1.取得终端对象
        //File file = new File("C:\\Users\\admin\\Desktop\\Test.txt");
        //2.创建输出流，
        */
/*OutputStream out = new FileOutputStream(file);//字节输出流会自动创建不存在的文件
        //3.输出到终端
        out.write("hello world".getBytes());
        //4.关闭字节流
        out.close();

        //创建输入流，
        InputStream in = new FileInputStream("C:\\Users\\admin\\Desktop\\Test.txt");*//*

 */
/*
        read的三种重载    read(byte[] bytes)  从一次读取一个缓冲区的数据
                           read(byte[] bytes,int off,int length)
                           read()  一次读取一个字节
         *//*

 */
/* byte[] bytes=new byte[1024];//读取缓冲区
        int len=in.read(bytes);
        String str=new String(bytes,0,len);
        System.out.println(str);
        in.close();*//*

 */
/**
 * Writer  字符输出流,对于中文
 *//*

        //追加
       */
/* Writer out=new FileWriter("C:\\Users\\admin\\Desktop\\Test.txt",true);
        out.write("你好_CRT_SECURE_NO_WARNINGS ");
        out.flush();//字符输出流没有关闭流会报错，不关闭必须进行强制刷新，因为它不是原生操作*//*

 */
/**
 *
 *//*

 */
/*Reader in = new FileReader("C:\\Users\\admin\\Desktop\\Test.txt");
        char[] data=new char[1024];
        int len=in.read(data);
        String str=new String(data,0,len);
        System.out.println(str);
        in.close();*//*


 */
/**
 * 进行拷贝
 *//*

        //Copy("C:\\Users\\admin\\Desktop\\匹配.PNG","C:\\Users\\admin\\Desktop\\匹配1.PNG");

        */

import java.io.*;
import java.util.Scanner;

/**
 * 通过内存流进行大小写的转换
 * ByteArrayInputStream(byte[] buff)     将字节数组的内容放到内存中
 * ByteArrayOutputStream      将将内存中的内容输出
 *
 *//*

 */
/* InputStream in=new ByteArrayInputStream("hello world".getBytes());
        OutputStream out=new ByteArrayOutputStream();//内存只有一个，不用穿对象
        int temp=0;
        while((temp=in.read())!=-1){
            out.write(Character.toUpperCase(temp));
        }
        System.out.println(out);
        in.close();
        out.close();

    }
    public static void Copy(String source,String dest) throws IOException{
        //1.获取要拷贝的终端对象
        File file=new File(source);
        File file1=new File(dest);
        //2.获取源文件的输入流
        InputStream  in=new FileInputStream(file);
        OutputStream out=new FileOutputStream(file1);
        int len=0;//没有任何参数说明一次只读取一个字节
        byte[] data=new byte[1024];
        Long start=System.currentTimeMillis();
        while((len=in.read(data))!=-1){
            out.write(data);
        }
        Long end=System.currentTimeMillis();
        System.out.println("供耗时"+(end-start)+"ms");
        in.close();
        out.close();
    }*//*

 */
/*
}*//*



 */
/*    }
}*//*

 */
/*
打印流：打印流是输出流的一个强化版本
通常  OutputStream只可以输出字节数组 ，这样很不方便，比如，要将一个字符输出到终端，先有将他转换成字符串再转化成字节，所以我们想到一中
装饰类来转化成字节
 *//*


class UtilPrint {
    private OutputStream out;

    public UtilPrint(OutputStream out) {
        this.out = out;
    }

    public void print(String str) throws IOException {
        out.write(str.getBytes());
    }

    public void println(String str) throws IOException {
        this.print(str+"\r\n");
    }

    public void print(int data)throws IOException {
            this.print(String.valueOf(data));
    }
    public void println(int data) throws IOException {
        this.println(String.valueOf(data));
    }
    public void print(double data) throws IOException{
        this.print(String.valueOf(data));
    }
    public void println(double data) throws IOException {
        this.println(String.valueOf(data));
    }
    public void close()throws IOException{
        this.out.close();
    }
}
public class TestIO{
    public static void main(String[] args) throws IOException{
        File file=new File("C:\\Users\\admin\\Desktop\\Test1.txt");
       // PrintStream out=new PrintStream(new FileOutputStream(file));
        UtilPrint out=new UtilPrint(new FileOutputStream(file));
        out.print("你好吗？");
        out.println("我很好");
        System.out.println();
        out.print(1234567);
        out.println(98765);
        System.out.println();
        out.println(3.14);
        out.print(234.566);
        out.close();
    }
}
*/
    /*
    java的标准化输出，System.out其实是一个对象，out实际上是一个PrintStream  System是一个类
    1.系统输出
    System.in;
    System.err;//是红的
    2.系统输入
    System.in//

   首先对于输出，有一个格式化的格式,JAVA在打印流提供了一个类似于C语言的格式
PrintStream的子类，的方法   print.format()
但是目前用的最多的还是      System.out.println();

java的输入原生，java的输入非常复杂
因为System.in其实是 PrintStream的对象
还要有一个读取缓冲区，

后来，引入了BufferReader类，最大的缺点是只能用 \n换行
而且结构过于冗杂

在java.util.Scanner包下有一有一个类进行输入

首先可以指定结束 标志   useDelimiter()
判断输入类型是否为指定类型hasNext
取得指定类型
     */

public class TestIO{
public static void main(String[]args){
    /*PrintStream print=System.out;
    print.format("%s,%d","hahaha",12);

    InputStream in=System.in;
    byte[] data=new byte[1024];
    System.out.println("请输入信息");
    try {
        int temp=in.read(data);
        System.out.println("输出内容为"+new String(data,0,temp));
    } catch (IOException e) {
        e.printStackTrace();
    }*/

    Scanner scanner = new Scanner(System.in);
    scanner.useDelimiter("--");
    if(scanner.hasNextInt()){
        int str=scanner.nextInt();
        System.out.println(str);
    }
    scanner.close();
    //指定特定的输入符号



}
}
