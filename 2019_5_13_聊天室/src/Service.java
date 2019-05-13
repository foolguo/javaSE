import jdk.nashorn.internal.runtime.regexp.joni.Matcher;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.security.KeyStore;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;




/**
 * @Author: yd
 * @Date: 2019/5/13 17:01
 * @Version 1.0
 */
public class Service {
    private static Map<String,Socket> map=new HashMap<>();
    static  class RealService implements Runnable{
        private Socket socket;
        public RealService(Socket socket) {
            this.socket = socket;
        }

        @Override
        public void run() {
            try {
                Scanner scanner=new Scanner(socket.getInputStream());
                String str=null;
                while(true) {
                    if (scanner.hasNext()) {
                        str = scanner.nextLine();
                    }
                    Pattern pattern=Pattern.compile("\r");
                    java.util.regex.Matcher matcher=pattern.matcher(str);
                    str=matcher.replaceAll(" ");
                    if(str.startsWith("userName")){
                        String userName=str.split("\\:")[0];
                        register(userName);
                        continue;
                    }else if(str.startsWith("G:")){
                        String values=str.split("\\:")[1];
                        continue;
                    }else if(str.startsWith("P:")){
                        String values=str.split("\\-")[1];
                        String userName=str.split("\\:")[1].split("\\-")[0];
                        privateSend(userName,values);
                        continue;
                    }
                    if(str.contains("bye")){
                        System.out.println("退出群聊");
                        socket.close();
                        scanner.close();
                        break;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public void register(String userName) throws IOException {
        PrintStream printStream=new PrintStream(socket.getOutputStream(),true,"UTF-8");
            if(!map.containsKey(userName)) {
                map.put(userName, socket);
                printStream.println("注册成功");
            }else{
                printStream.println("该用户名已存在");
            }
        }
        public void group(String values) throws IOException {
            Set<Map.Entry<String,Socket>> set=map.entrySet();
            for (Map.Entry<String,Socket> entry:set){
                Socket socket=entry.getValue();
                PrintStream out=
                        new PrintStream(socket.getOutputStream(),true,"Utf-8");
                out.println(values);
            }
        }
        public void privateSend(String userName,String values) throws IOException {

            if(map.containsKey(userName)) {
                Socket send = map.get(userName);
                PrintStream out=new PrintStream(send.getOutputStream(),true,"UTF-8");
                out.println(values);
            }else{
                PrintStream out=new PrintStream(socket.getOutputStream(),true,"Utf-8");
                out.println("该用户不存在");

            }
        }
    }
    public static void main(String[] args) throws IOException {
        ExecutorService executorService= Executors.newFixedThreadPool(20);
        ServerSocket serverSocket=new ServerSocket(6666);

        for (int i=0;i<20;i++){
            System.out.println("等待客户端连接");
            Socket socket=serverSocket.accept();
            System.out.println("客户端已连接 端口号为："+socket.getPort());
            executorService.submit(new RealService(socket));
        }
        executorService.shutdown();
        serverSocket.close();
        HashMap
    }
}
