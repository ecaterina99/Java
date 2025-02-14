import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) {

        try (Socket socket = new Socket("localhost", 1080);
             DataInputStream in = new DataInputStream(socket.getInputStream());
             DataOutputStream out = new DataOutputStream(socket.getOutputStream());
             Scanner scanner = new Scanner(System.in)) {

            System.out.println("Enter first number ");
            int num1 = scanner.nextInt();
            System.out.println("Enter second number : ");
            int num2 = scanner.nextInt();

            out.writeInt(num1);
            out.writeInt(num2);

            int sum = in.readInt();
            System.out.println("Response from server. The sum is: " + sum);

        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
