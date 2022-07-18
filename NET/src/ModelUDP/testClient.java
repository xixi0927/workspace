package ModelUDP;

import java.io.IOException;
import java.net.*;
import java.nio.charset.StandardCharsets;
import java.util.Date;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName testClient.java
 * @createTime 2022年07月18日
 * UDP客户端：向UDP服务器端发送系统时间
 */
public class testClient {
    public static void main(String[] args) {
        DatagramSocket ds = null;
        DatagramPacket sendDP = null;
        DatagramPacket receiveDP = null;
        String serverIP ="127.0.0.1";
        int port =10000;


        try {
            ds = new DatagramSocket();

            Date d = new Date();
            String content = d.toString();

            byte[] data = content.getBytes();
            try {
                InetAddress address = InetAddress.getByName(serverIP);
                sendDP =new DatagramPacket(data,data.length,address,port);
                ds.send(sendDP);

                //接受数据
                byte [] b =new byte[1024];
                receiveDP = new DatagramPacket(b,b.length);
                ds.receive(receiveDP);


                //读取响应内容
                byte [] response = receiveDP.getData();
                int len = receiveDP.getLength();
                String str = new String(response,0,len);
                System.out.println("服务器端响应："+str);

            } catch (UnknownHostException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                ds.close();
            }


        } catch (SocketException e) {
            e.printStackTrace();
        }



    }
}
