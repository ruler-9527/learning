import org.junit.Test;

import java.io.IOException;
import java.net.*;

/**
 * @Classname UDPtest
 * @Description TODO
 * @Date 2021/3/22 17:03
 * @Created by ruler
 */
public class UDPtest {
    @Test
    public void client() throws IOException {
        DatagramSocket socket = new DatagramSocket();

        String str ="通过UDP传输的信息";
        byte[] data = str.getBytes();
        InetAddress inet = InetAddress.getLocalHost();
        DatagramPacket packet = new DatagramPacket(data,0,data.length,inet,9090);

        socket.send(packet);
        socket.close();
    }

    @Test
    public void server() throws IOException{
        DatagramSocket socket = new DatagramSocket(9090);

        byte[] buffer = new byte[100];
        DatagramPacket packet = new DatagramPacket(buffer,0,buffer.length);

        socket.receive(packet);
        System.out.println(new String(packet.getData(),0,packet.getLength()));

        socket.close();

    }
}
