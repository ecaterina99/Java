import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {

        while (true) {

            try (DatagramSocket sock = new DatagramSocket()) {

                Scanner scanner = new Scanner(System.in);

                System.out.println("\nEnter message: ");
                String message = scanner.nextLine();

                InetAddress ia = InetAddress.getByName("localhost");
                byte[] buff = message.getBytes();
                DatagramPacket p = new DatagramPacket(buff, buff.length, ia, 1081);

                sock.send(p);

                System.out.println("Message sent");

                buff = new byte[256];
                p = new DatagramPacket(buff, buff.length, ia, 1000); // 1081
                System.out.println("Waiting for response");
                sock.receive(p);

                System.out.print("Response: ");
                System.out.print(new String(p.getData(), 0, p.getLength()));

            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }
    }
}