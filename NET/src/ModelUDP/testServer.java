package ModelUDP;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 * @author 孟凡喜
 * @version 1.0.0
 * @ClassName testServer.java
 * @createTime 2022年07月18日
 * 使用UDP输出客户端发送的数据，并响应客户端一个OK字符串
 */
public class testServer {
    public static void main(String[] args) {
        DatagramSocket ds = null; //UDP连接对象，主要用于端到端的通信类
        DatagramPacket sendDP = null;  //发送数据包对象
        DatagramPacket receiveDP = null;  //接收数据包

        int port = 10000;
        try {
            ds = new DatagramSocket(port);
            System.out.println("服务器端已启动。。。");

            //初始化接受数据
            byte [] b = new byte[1024];
            receiveDP = new DatagramPacket(b,b.length);
            ds.receive(receiveDP);  //接受客户端的数据

            InetAddress clientIP = receiveDP.getAddress();
            int clientPort = receiveDP.getPort();
            byte [] data = receiveDP.getData();
            int len = receiveDP.getLength();
            System.out.println("客户端IP："+clientIP.getHostAddress());
            System.out.println("端口号："+clientPort);
            System.out.println("接收到的数据："+new String(data,0,len));
            String response = "Ok ,已接收到数据";
            byte[] arrDate = response.getBytes();
            sendDP = new DatagramPacket(arrDate,arrDate.length,clientIP,clientPort);
            ds.send(sendDP);

        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if(ds != null){
                ds.close();
            }

        }


    }

}
