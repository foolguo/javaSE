import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/7 18:34
 * @Version 1.0
 */

















public class SingleThreadServer {
    public static void main(String[] args)throws Exception {
        //1.建立基站
        ServerSocket serverSocket=new ServerSocket(6666);
        //2.取得客户端连接
        System.out.println("等待客户端的连接");
        Socket socket=serverSocket.accept();
        //3.建立连接后，进行数据的输入和输出
        //建立输出
        PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("hello i am server");
        Scanner scanner=new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("客户端发来的消息是"+scanner.nextLine());
        }
        printStream.close();
        scanner.close();
        serverSocket.close();
    }
}
