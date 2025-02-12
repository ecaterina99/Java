import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;

public class Client {
    public static void main(String[] args) {
        try (DatagramSocket datagramSocket = new DatagramSocket()) {
            byte[] message = "Hello from UDP client".getBytes();
            InetSocketAddress ep = new InetSocketAddress("127.0.0.1", 1080);
            DatagramPacket p = new DatagramPacket(message, message.length, ep);
            datagramSocket.send(p);
            message = new byte[256];
            p = new DatagramPacket(message, message.length, ep);
            datagramSocket.receive(p);
            System.out.println(new String(p.getData(), 0, p.getLength()));
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
