import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.io.*;

public class HTTPTest {
    //Server
    public static void main(String[] args) {
        while (true) {
            System.out.println("listening...");
            try (ServerSocket serverSocket = new ServerSocket(1080);
                 Socket cn = serverSocket.accept();
                 BufferedReader bis = new BufferedReader(new InputStreamReader(cn.getInputStream()));
                 BufferedOutputStream bos = new BufferedOutputStream(cn.getOutputStream())) {

                String req = bis.readLine();
                String reqPage = req.split(" ")[1].replace("/", "");
                FileType fType = getFileType(reqPage);

                File f = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\HTTPTest\\src",reqPage);
                if (f.exists()) {
                    bos.write(createHeader(200, fType).getBytes());
                    FileInputStream fs = new FileInputStream(reqPage);
                    int readByte;

                    while ((readByte = fs.read()) != -1)
                        bos.write((byte) readByte);

                    fs.close();

                } else {
                    bos.write(createHeader(404, fType).getBytes());
                    bos.write("Page doesn't exist.".getBytes());
                }

            } catch (IOException exc) {
                System.out.println(exc.getMessage());
            }

        }
    }

    static FileType getFileType(String file) {
        FileType type = FileType.UNKNOWN;
        if (file.endsWith(".html")) {
            type = FileType.HTML;
        }
        if (file.endsWith(".txt")) {
            type = FileType.TXT;
        }
        if (file.endsWith(".jpg")) {
            type = FileType.JPG;
        }
        if (file.endsWith(".jpeg")) {
            type = FileType.JPEG;
        }
        if (file.endsWith(".gif")) {
            type = FileType.GIF;
        }
        if (file.endsWith(".png")) {
            type = FileType.PNG;
        }
        if (file.endsWith(".pdf")) {
            type = FileType.PDF;
        }
        if (file.endsWith(".zip")) {
            type = FileType.ZIP;
        }
        return type;
    }


    static Map<Integer, String> errorCodes = new HashMap<>() {
        {
            put(200, "200 OK");
            put(404, "404 Not found");
            put(500, "500 Internal Server Error");
        }
    };
    static Map<FileType, String> fileTypes = new HashMap<>() {
        {
            put(FileType.HTML, "Content-Type: text/html\r\n");
            put(FileType.TXT, "Content-Type: text/plain\r\n");
            put(FileType.JPG, "Content-Type: image/jpeg\r\n");
            put(FileType.JPEG, "Content-Type: image/jpeg\r\n");
            put(FileType.GIF, "Content-Type: image/gif\r\n");
            put(FileType.PNG, "Content-Type: image/png\r\n");
            put(FileType.PDF, "Content-Type: application/pdf\r\n");
            put(FileType.ZIP, "Content-Type: application/zip\r\n");
        }
    };

    static String createHeader(Integer errorCode, FileType fileType) {
        return "HTTP/1.1 " + errorCodes.get(errorCode) + "\r\n" +
                fileTypes.get(fileType) + "\r\n";
    }

}

