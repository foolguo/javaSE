import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/7 20:30
 * @Version 1.0
 */
class ReadFromServer implements Runnable{
    private Socket socket;
    public ReadFromServer(Socket socket) {
        this.socket = socket;
    }

    /*
    * 1.从服务器端读取数据，首先要获取socket的输入对象
    * 2.并且要不断读
    * */
    @Override
    public void run() {
        try {
            Scanner scanner = new Scanner(socket.getInputStream());
            while(true){
                if(scanner.hasNext()){
                    System.out.println("从服务器输出的内容是"+scanner.nextLine());
                }
                if(socket.isClosed()) {
                    System.out.println("客户端退出");
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
/*
* 写操作：
* */
class WriterFromServer implements Runnable{
    private Socket socket;

    public WriterFromServer(Socket socket) {
        this.socket = socket;
    }
    /*
    * 向外输出  所以要获取打印流
    *
    * */
    @Override
    public void run() {
        try {
            PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
            Scanner scanner=new Scanner(System.in);
            while(true){
                System.out.println("请输入要发送的信息");
                if(scanner.hasNext()){
                    String msg=scanner.next();
                    printStream.println(msg);
                    if(msg.contains("byebye")){
                        System.out.println("关闭客户端");
                        printStream.close();
                        scanner.close();
                        socket.close();
                        break;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class MutiThreadClient {
    public static void main(String[] args) throws Exception{
        Socket socket=new Socket("127.0.0.1",6666);
        ReadFromServer read=new ReadFromServer(socket);
        WriterFromServer writer=new WriterFromServer(socket);
        new Thread(read).start();
        new Thread(writer).start();
    }
}
