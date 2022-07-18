package Model1;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName TestServer.java
 * @createTime 2022年07月18日
 */
public class TestServer {
    public static void main(String[] args) {
        int port = 12345;
        ServerSocket server =null;
        Socket client =null;
        DataInputStream dis =null;
        DataOutputStream dos =null;

        try {
            server = new ServerSocket(port);

            while(true){
                System.out.println("等待客户端连接");
                server.accept(); //监听指定的端口号（如果没有连接，会一直堵塞）
                client = server.accept(); //如果游客户端连接到达，那么会返回一个Socker对象，表示当前建立连接

                dis = new DataInputStream(client.getInputStream());
                String message = dis.readUTF();
                System.out.println("接收到的客户端消息："+message);

                //将结果响应给客户端
                dos = new DataOutputStream(client.getOutputStream());
                dos.writeUTF("响应给客户端的结果是：");
                dos.flush();
            }

        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try{
                if(dos != null){
                    dos.close();
                }
                if(dis != null){
                    dis.close();
                }
                if(client != null){
                    client.close();
                }

            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
