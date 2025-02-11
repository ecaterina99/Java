import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

//Crearea unui client TCP
public class clientTCPSocket {
    public static void main(String[] args) {
        try (
                Socket socket = new Socket("www.google.com", 80);
                BufferedReader bis = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                BufferedOutputStream bos = new BufferedOutputStream(socket.getOutputStream())) {

            bos.write("GET /search?q=java HTTP/1.1\r\n\r\n".getBytes());
            bos.flush();

            String line = bis.readLine();
            while (line != null) {
                System.out.println(line);
                line = bis.readLine();
            }


        } catch (
                IOException exception) {
            System.out.println(exception.getMessage());
        }
    }
}

