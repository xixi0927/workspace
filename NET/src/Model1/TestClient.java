package Model1;

import java.io.*;
import java.net.Socket;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName TestClient.java
 * @createTime 2022年07月18日
 * 客户端
 */
public class TestClient {
    public static void main(String[] args) {
        String host = "127.0.0.1";
        int port = 12345;
        Socket socket = null;
        OutputStream os = null;
        DataOutputStream dos = null;

        InputStream is = null;
        DataInputStream dis = null;

        try {
            socket = new Socket(host,port);
            os = socket.getOutputStream();
            dos=new DataOutputStream(os);

            dos.writeUTF("这是客户端向服务器发送的消息");
            dos.flush();

            is = socket.getInputStream();
            dis = new DataInputStream(is);
            String receive = dis.readUTF();
            System.out.println("这是服务器的响应信息");


        } catch (IOException e) {
            e.printStackTrace();
        }finally {

            try{
                if (dos != null){
                        dos.close();
                    }
                if(os != null){
                    os.close();
                }
                if(dis != null){
                    dis.close();
                }
                if(is != null){
                    is.close();
                }
                }catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
