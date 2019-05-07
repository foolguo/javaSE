import java.io.IOException;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yd
 * @Date: 2019/5/7 20:47
 * @Version 1.0
 */

/*
* 服务器有三个功能：
* 1.注册
* 2.群聊
* 3.私聊
*
* */
public class MultiThreadServer {
    private static Map<String,Socket> clientMap=new ConcurrentHashMap<>();
    private static class ExecuteClient implements Runnable{
        private Socket socket;

        public ExecuteClient(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                Scanner in=new Scanner(socket.getInputStream());
                String msg;
                while(true){
                    if(in.hasNext()){
                        msg=in.nextLine();
                        Pattern pattern=Pattern.compile("\r");
                        java.util.regex.Matcher matcher=pattern.matcher(msg);
                        msg=matcher.replaceAll(" ");
                        if(msg.startsWith("userName")){
                            String userName=msg.split("\\:")[0];
                            register(userName,socket);
                        }else if(msg.startsWith("G")){
                           //取得群发内容
                            String clientMsg=msg.split("\\:")[1];
                            sendGroup(clientMsg);
                        }else if(msg.startsWith("P")){
                            //P:userName-Msg
                            String userName=msg.split("\\:")[1].split("-")[0];
                            String clientMsg=msg.split("-")[1];
                            sendPrivate(userName,clientMsg);
                        }
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        /*
        * 注册方法：
        * 1.判断该用户是否已注册
        * 2.如果未注册，则直接入队；
        * */
        private void register(String userName,Socket socket) throws IOException {
            PrintStream out=new PrintStream(socket.getOutputStream(),true,"UTF-8");
           if (!clientMap.containsKey(userName)) {
               System.out.println("用户姓名为"+userName);
               System.out.println("用户"+userName+"上线了");
               System.out.println("当前群聊人数为"+clientMap.size());
                clientMap.put(userName, socket);
                //给用户发送信息
           } else {
               out.println("用户已存在，请改用新的userName");
           }
           out.close();
        }
        private void sendGroup(String msg){
            Set<Map.Entry<String,Socket>> set= clientMap.entrySet();
            for (Map.Entry<String,Socket> i:set){
                Socket socket=i.getValue();
                try {
                    PrintStream out=new PrintStream(socket.getOutputStream(),true,"UTF-8");
                    out.println("群聊信息"+msg);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        private void sendPrivate(String userName,String msg){
            Socket socket=clientMap.get(userName);
            try {
                PrintStream out=new PrintStream(socket.getOutputStream(),true,"UTF-8");
                out.println(msg);
            } catch (Exception e) {
                e.printStackTrace();
            }

        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        //创建服务器
        ServerSocket serverSocket=new ServerSocket(6666);
        for(int i=0;i<20;i++){
            System.out.println("等待客户端连接....");
            Socket socket=serverSocket.accept();
            System.out.println("有新的客户端连接，端口号是"+socket.getPort());
            executorService.submit(new ExecuteClient(socket));
        }
        executorService.shutdown();
        serverSocket.close();
    }

}
