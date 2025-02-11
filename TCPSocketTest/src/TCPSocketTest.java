
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest {

    public static void main(String[] args) throws IOException {

        //Crearea unui server TCP
        System.out.println("listening...");
        try (ServerSocket serverSocket = new ServerSocket(1080);
             Socket cn = serverSocket.accept();
             BufferedReader bis = new BufferedReader(new InputStreamReader(cn.getInputStream()));
             BufferedOutputStream bos = new BufferedOutputStream(cn.getOutputStream())) {

            System.out.println("Client connected!");
            System.out.println("Client message:");

            String line = bis.readLine();
            while (line != null && !line.equals("")) {
                System.out.println(line);
                line = bis.readLine();
            }

            bos.write("Hello from java tcp server".getBytes());

        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}