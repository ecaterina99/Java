
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketTest {

    public static void main(String[] args)  {

        //Crearea unui server TCP
       System.out.println("listening...");
        //Crearea serverului
        try (ServerSocket serverSocket = new ServerSocket(1080);
             //accept-operatiunea de blocare
             Socket cn = serverSocket.accept();
             //buffered input stream
             BufferedReader bis = new BufferedReader(new InputStreamReader(cn.getInputStream()));
             //buffered output stream
             BufferedOutputStream bos = new BufferedOutputStream(cn.getOutputStream())) {

            System.out.println("Client connected!");
            System.out.println("Client message:");

            //citirea mesajului
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