import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/8 14:36
 * @Version 1.0
 */

/*
* 要同步的读和写，所以
* 1.创建一个读线程，来实时接收信息
* 2.创建一个写线程，来实时发送信息
*
*
* */
class ReadThread implements Runnable{
    private Socket socket;

    public ReadThread(Socket socket) {
        this.socket = socket;
    }
    /*
    * 在run里进行读逻辑的判断
    * */
    @Override
    public void run() {
        try {
            Scanner scanner=new Scanner(socket.getInputStream());
            String msg = null;
            while(true){
                if(scanner.hasNext()){
                    msg=scanner.nextLine();
                    System.out.println(msg);
                }

                if(socket.isClosed()){
                    System.out.println("客户端已关闭");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class WriterThread implements Runnable{
    private  Socket socket;

    public WriterThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            PrintStream out=new PrintStream(socket.getOutputStream(),true,"UTF-8");
            Scanner in=new Scanner(System.in);
            String msg=null;
            while(true){
                System.out.println("请输入要发送的信息");
                if(in.hasNext()){
                    msg=in.nextLine();
                }
                out.println(msg);
                if(msg.contains("bye")){
                    out.close();
                    in.close();
                    socket.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class MultiThreadClient {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("127.0.0.1",6666);
        Thread read=new Thread(new ReadThread(socket));
        Thread write=new Thread(new WriterThread(socket));
        read.start();
        write.start();
    }
}
