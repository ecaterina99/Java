import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class CopyingFile {
    public static void main(String[] args) {
        //Copierea fişierului
        File aFile = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\flower.jpg");
        File bFile = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\tulip\\flower.jpg");

        try (FileInputStream inStream = new FileInputStream(aFile);
             FileOutputStream outStream = new FileOutputStream(bFile)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
            System.out.println("File is copied successfully!");
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}
        /*Path source = Paths.get("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\flower.jpg");
        Path destination = Paths.get("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\tulip");
        try {
            if (!Files.exists(source)) {
                System.out.println("File doesn't exist!");
                return;
            }
            if (!Files.exists(destination.getParent())) {
                System.out.println("Location doesn't exist!");
                return;
            }
            if (Files.exists(destination)) {
                System.out.println("File already exists on the location!");
                return;
            }
            Files.copy(source, destination);
            System.out.println("File " + source.getFileName() + " is copied!");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }*/