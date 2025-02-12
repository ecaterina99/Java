
import java.io.*;
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

            //regulile protocolului HTTP
            byte[] message = "Hello from java TCP Server!".getBytes();
            bos.write("HTTP/1.1 200 OK\r\n".getBytes());
            bos.write("Content-Type: text/plain\r\n".getBytes());
            bos.write(("Content-Length: " + message.length + "\r\n").getBytes());
            bos.write("\r\n".getBytes()); // empty line between HTTP header and HTTP content
            bos.write(message);

        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}