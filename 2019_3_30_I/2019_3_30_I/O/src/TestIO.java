import java.io.*;
import java.util.Date;

/**
 * @Author: yd
 * @Date: 2019/3/30 18:06
 * @Version 1.0
 */
public class TestIO {
    public static void main(String[] args) throws IOException{
  /*      //1.取得File对象
        File file=new File("C:\\Users\\admin\\Desktop\\2019.java");
        //2.如果不存在创建，否则删除
        if(!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            file.delete();
        }*/
        //3.但是在Linux和Windows下，文件路径的表达方式不同   前者是/   后者是  \
        //所以有了一种常量   File.separator 来代替  /  和  \
        /*File file=new File("C:"+File.separator+"Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"2019.java");
        if(!file.exists()){
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else{
            file.delete();
        }*/

        /*
        目录操作：1.取得父路径；   public String getParent()
                  2.取得父路径对象 :  public File getParent();
                  3. public boolean mkdirs();  (一次性创建不存在的父路径路径，但是必须和获取父路径
                  对象搭配使用，否则会将要创建的文件直接当做一个文件夹)

         */

        /*File  file = new File("C:"+File.separator+"Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"www"+File.separator
                +"com"+File.separator+"IO"+File.separator+"2019.java");
        if(!file.getParentFile().exists()){
            //file.mkdirs();  一定是不能到自己这层，而是父路径层否则会将自己的文件当
            // 一个父路径
            file.getParentFile().mkdirs();
            //file.mkdir();
        }
        if(file.exists()){
            file.delete();
        }else{
            file.createNewFile();
        }*/

        //文件信息

       /*
       1.判断一个路径是否为文件  isFile();
       2,.判断一个路径是否为目录，isDirector()
       3.取得文件大小   length()
       4.文件最后一次修改日期   lastModified()
        */
        //标准写法
       /* File  file = new File("C:"+File.separator+"Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"2019.java");
        if(file.exists()&&file.isFile()){
            System.out.println("文件大小"+file.length()/1024/1024+"MB");
            System.out.println("文件最后一次修改日期"+new Date(file.lastModified()));
        }else{
            file.createNewFile();
        }*/
       //取得所有文件信息的方法 public File[] listFile()
     /*   File  file = new File("C:"+File.separator+"Users"+File.separator+
                "admin"+File.separator+"Desktop");
        isFillFire(file);*/
        //System.out.println(file);

        /*
        1.字节流  InputStream  OutputStream
        2.字符流  Reader   Witter

         字节流 方法  在使用字节流操作后一定要关闭字节流操作，
         1.获取终端对象  file()
         2.在终端对象取得输入输出流    output= file.OutputStreamFile()
         3.根据输入输出流进行数据的读取和操作 output.write(msg.getBytes())
         如果输出的对象是字符先要转换成字节；
         4.关闭流  output.close()
         */

      /*  File file=new File("C:"+File.separator+"Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"2019.java");
        if(!file.exists()&&file.isFile()){
            file.createNewFile();
        }
        OutputStream outputStream=new FileOutputStream("C:"+File.separator+
                "Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"2019.java");
        String msg="hello world";
        outputStream.write(msg.getBytes());
        outputStream.write(msg.getBytes(),6,5);
        outputStream.write(msg.getBytes()[6]);
        outputStream.close();*/
        /*
        输入输出流：OutputStream
        1.获取终端对象；
        2.创建输入输出流；
        3.根据输入输出流进行数据的读取和写入
        4.关闭输入输出流
         */
        //1.输出流  主要方法  write()1.因为是面向字节流的 所以  参数1.字节数组，2.字节数组起始偏移量，3.单个字符
       /* File file=new File("C:"+File.separator+"Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"2019.java");
        if(!file.exists()&&file.isFile()){
            file.createNewFile();
        }
        OutputStream outputStream = new FileOutputStream(file,true);//不写true会覆盖原来的
        String str="hello word";
        outputStream.write(str.getBytes());
        outputStream.close();*/

       /*
        输入流   主要方法  read()  read()1.面向字节流传入Byte进行输入，
        */
       File file = new File("C:"+File.separator+"Users"+File.separator+
               "admin"+File.separator+"Desktop"+File.separator+"2019.java");
       if(!file.exists()&&file.isFile()){
           file.createNewFile();
       }
       InputStream inputStream = new FileInputStream(file);//创建入流
        byte[] bytes = new byte[1024];
        inputStream.read(bytes);
        String str = new String(bytes);
        System.out.println(str);
        inputStream.close();
    }
    //输出目录全是文件
    public static void isFillFire(File file){
        if(file.isFile()){
            System.out.println(file);
        }
        if(file.exists()&&file.isDirectory()){
            File[] data=file.listFiles();
            for (File i:data){
                isFillFire(i);
            }
        }
        /*
            InputStream :
            方法  ：read  返回值 读取数据的个数  1.文件的开辟的字节数组的大小大于读取缓冲区（文件）的大小返回文件大小
            2.如果开辟字节数的大小小于文件大小  返回开辟数组的长度
            3.没有字符 返回-1
         */
        //获取终端对象（要读取的文件对象）
       /* File file = new File("C:"+File.separator+
                "Users"+File.separator+
                "admin"+File.separator+"Desktop"+File.separator+"2019.java");
        //创建输入字节流
        InputStream inputStream = new FileInputStream(file);
        byte[] bytes=new byte[1024];
        int len=inputStream.read(bytes);
        String str=new String(bytes,0,len);
        System.out.println(str);
        inputStream.close();*/

    }
    public static void isFillFile(File file){
        if(file.isFile()){
            System.out.println(file);
        }
        if(file.exists()&&file.isDirectory()){
            File[] fire2=file.listFiles();
            for(File i: fire2){
                isFillFile(i);
            }
        }
    }
}
