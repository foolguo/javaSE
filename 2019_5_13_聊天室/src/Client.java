import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/13 16:45
 * @Version 1.0
 */
/*客户端*/
//    1.客户端的创建规则：
//        1.首先要有一个读线程（用来读取服务器发送的数据）；
//        2.要有一个写线程，负责向服务器发送信息已经关闭客户端


class Read implements Runnable{
    private Socket socket;

    public Read(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        //1.取得服务器端的终端对象
        try {
            Scanner scanner=new Scanner(socket.getInputStream());
            String str=null;
            while(true){
                if(scanner.hasNext()){
                    str=scanner.nextLine();
                }
                System.out.println("发来信息"+str);
                if(socket.isClosed()){
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
class Write implements Runnable{
    private Socket socket;

    public Write(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        //获取输出流：
        try {
            PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
            Scanner scanner=new Scanner(System.in);
            String str=null;
            while(true){
                System.out.println("要发送的信息:");
                if(scanner.hasNext()){
                    str=scanner.nextLine();
                }
                printStream.println(str);
                if(str.contains("bye")){
                    printStream.close();
                    socket.close();
                    scanner.close();
                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
public class Client {
    public static void main(String[] args) throws IOException {
        Socket socket=new Socket("127.0.0.1",6666);
        Write write=new Write(socket);
        Read read=new Read(socket);
        new Thread(write).start();
        new Thread(read).start();

    }
}
