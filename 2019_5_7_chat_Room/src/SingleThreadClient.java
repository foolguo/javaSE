import java.io.PrintStream;
import java.net.Socket;
import java.util.Scanner;

/**
 * @Author: yd
 * @Date: 2019/5/7 18:40
 * @Version 1.0
 */
public class SingleThreadClient {
    public static void main(String[] args) throws  Exception{
        //1.创建一个客户端
        Socket socket=new Socket("127.0.0.1",6666);
        //2.进行客户端的输入和输出
        Scanner scanner=new Scanner(socket.getInputStream());
        if(scanner.hasNext()){
            System.out.println("从服务器发出的消息是"+scanner.nextLine());
        }
        PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
        printStream.println("i am a Client");
        printStream.close();
        scanner.close();
        socket.close();
    }
}
