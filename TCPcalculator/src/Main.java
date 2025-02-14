import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Main {
    public static void main(String[] args) {
        System.out.println("Server started");

        try (ServerSocket serverSocket = new ServerSocket(1080);
             Socket cn = serverSocket.accept();
             DataInputStream dis = new DataInputStream(cn.getInputStream());
             DataOutputStream dos = new DataOutputStream(cn.getOutputStream())) {

            int num1 = dis.readInt();
            int num2 = dis.readInt();
            int sum = num1 + num2;
            dos.writeInt(sum);
            System.out.println(sum);

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        System.out.println("Server is shutting down...");

    }
}