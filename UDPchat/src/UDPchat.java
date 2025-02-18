import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.util.Scanner;

public class UDPchat {

    public static void main(String[] args) {

        while (true) {

            try (DatagramSocket datagramSocket = new DatagramSocket(1081)) {

                Scanner scanner = new Scanner(System.in);

                byte[] buffer = new byte[256];

                DatagramPacket datagramPacket = new DatagramPacket(buffer, buffer.length);
                System.out.println("Waiting for response");
                datagramSocket.receive(datagramPacket);

                System.out.print("Response: ");
                System.out.print(new String(datagramPacket.getData(), 0, datagramPacket.getLength()));
                System.out.println("\nEnter message: ");
                String message = scanner.nextLine();
                buffer = message.getBytes();
                datagramPacket = new DatagramPacket(buffer, buffer.length, datagramPacket.getAddress(), datagramPacket.getPort());
                datagramSocket.send(datagramPacket);
                System.out.println("Message sent");
            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }
        }

    }

}