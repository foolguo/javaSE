import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.concurrent.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @Author: yd
 * @Date: 2019/5/8 15:02
 * @Version 1.0
 */
public class MultiThreadServer {
    private static Map<String,Socket> map=new ConcurrentHashMap();
    private static class Server implements Runnable {
        private Socket socket;

        public Server(Socket socket) {
            this.socket = socket;
        }
        @Override
        public void run() {
            try {
                Scanner scanner=new Scanner(socket.getInputStream());
                String str=null;
                while(true){
                    if(scanner.hasNext()) {
                        str = scanner.nextLine();
                    }
                    Pattern pattern=Pattern.compile("\r");
                    Matcher matcher=pattern.matcher(str);
                    str=matcher.replaceAll(" ");
                    if(str.startsWith("userName")){
                        String userName=str.split(":")[1];
                        register(userName);
                        continue;
                    }else if(str.startsWith("G")){
                        String msg=str.split("\\:")[1];
                        sendGroup(msg);
                        continue;
                    }else if(str.startsWith("P")){
                        //P：userNam-
                        String userName=str.split(":")[1].split("\\-")[0];
                        String msg=str.split("\\-")[1];
                        sendPrivate(userName,msg);
                    }
                    if(str.contains("bye")){
                        String userName=null;
                        for (String i:map.keySet()){
                            if(map.get(i).equals(socket)){
                                userName=i;
                            }
                        }
                        System.out.println("用户"+userName+"退出群聊");
                        map.remove(userName);
                        scanner.close();
                        socket.close();
                        continue;
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        private void register(String userName) throws IOException {
            PrintStream out=new PrintStream(socket.getOutputStream(),true,"UTF-8");
            if(!map.containsKey(userName)){
                map.put(userName,socket);
                System.out.println("用户姓名为"+userName);
                System.out.println("当前聊天室"+map.size()+"人");
                out.println("注册成功当前聊天室:"+map.size()+"人");
            }else {
                out.println("用户名以存在，请重新输入");
            }
        }
        private void sendGroup(String msg) throws IOException {
            //在map中取得所有socket
            Set<Map.Entry<String,Socket>> set=map.entrySet();
            for (Map.Entry<String,Socket> i : set){
                Socket socket=i.getValue();
                PrintStream out=new PrintStream(socket.getOutputStream(),true,"Utf-8");
                out.println("群聊"+msg);
            }
        }
        private void sendPrivate(String userName,String msg) throws IOException {
            Socket privateSocket=map.get(userName);
            PrintStream out=new PrintStream(privateSocket.getOutputStream(),true,"Utf-8");
            out.println(userName+"："+msg);
        }
    }

    public static void main(String[] args) throws IOException {
        ExecutorService executor= Executors.newFixedThreadPool(20);
        ServerSocket serverSocket=new ServerSocket(6666);
        for(int i=0;i<20;i++) {
            System.out.println("等待客户端连接");
            Socket socket=serverSocket.accept();
            System.out.println("有新的客户端连接，端口号是"+socket.getPort());
            executor.submit(new Server(socket));
        }
        /*executor.shutdown();
        serverSocket.close();*/
        ExecutorService executorService=new ThreadPoolExecutor()
    }
}
