import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class FilesAndFolders {
    public static void main(String[] args) {
        // afișarea folderelor rădăcină ale tuturor sistemelor de fișiere disponibile
        File[] roots = File.listRoots();
        for (File root : roots) {
            System.out.println(root);
        }

        //obținerea unei instanțe a clasei File
        File myFile = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders");

        //manipulăm fișierul pe care îl reprezintă o astfel de instanță
        System.out.println("Absolute path = " + myFile.getAbsolutePath());
        System.out.println("Name = " + myFile.getName());
        System.out.println("Parent = " + myFile.getParent());
        System.out.println("Path = " + myFile.getPath());
        System.out.println("Is absolute = " + myFile.isAbsolute());
        System.out.println("\n");

        //examinarea proprietăților unui fișier care este definit de o cale relativă:
        File fileRel = new File("tulip.jpg");
        System.out.println("Absolute path = " + fileRel.getAbsolutePath());
        System.out.println("Name = " + fileRel.getName());
        System.out.println("Parent = " + fileRel.getParent());
        System.out.println("Path = " + fileRel.getPath());
        System.out.println("Is absolute = " + fileRel.isAbsolute());
        System.out.println("\n");

        File file = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders");
        if (file.exists()) {
            System.out.println("Is file = " + file.isFile());
            System.out.println("Is directory = " + file.isDirectory());
            System.out.println("Lenght = " + file.length());

            Instant instant = Instant.ofEpochMilli(file.lastModified());
            LocalDateTime dateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
            DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd. MMMM yyyy. HH:mm:ss");

            System.out.println("Last modified = " + dateTime.format(dateTimeFormatter));

        } else {
            System.out.println("File/folder does not exist.");
        }
        System.out.println("\n");

        //Citirea conținutului unui folder - returnează un șir de valori String
        File path = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders");

        if (path.exists() && path.isDirectory()) {
            String[] strings = path.list();

            if (strings != null) {
                for (String string : strings) {
                    System.out.println(string);
                }
            }
        }
        System.out.println("\n");

        //Citirea conținutului unui folder - returnează un şir de obiecte de tip File.

        File path2 = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders");

        if (path2.exists() && path2.isDirectory()) {
            File[] files2 = path2.listFiles();

            if (files2 != null) {
                for (File file2 : files2) {
                    System.out.println(file2.getName());
                }
            }
        }

        System.out.println("\n");

        //Crearea unui folder
        File testFolder = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\test");

        if (!testFolder.exists()) {
            boolean success = testFolder.mkdir();

            if (success) {
                System.out.println("Folder created: " + testFolder.getName());
            } else {
                System.out.println("Folder is not created.");
            }

        } else {
            System.out.println("Folder " + testFolder.getName() + " already exists.");
        }

        System.out.println("\n");
        //Ştergerea fişierului/folderului
        File test2Folder = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\test");

        if (test2Folder.exists()) {
            boolean success = test2Folder.delete();
            System.out.println((success) ? "File successfully deleted!" : "Error while deleting the file!");
        } else {
            System.out.println("Cannot delete " + test2Folder.getName() + " because " + test2Folder.getName() + " does not exist.");
        }

        System.out.println("\n");
        //Schimbarea numelui fişierului/folderului
        File oldFile = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\tulip.jpg");
        File newFile = new File("C:\\Users\\Admin\\Desktop\\Learning\\Java\\FilesAndFolders\\flower.jpg");

        if (!oldFile.exists()) {
            System.out.println("File doesn't exist!");
            return;
        }
        if (newFile.exists()) {
            System.out.println("File with desired name already exists!");
            return;
        }
        if (oldFile.renameTo(newFile)) {
            System.out.println("Rename successful");
        } else {
            System.out.println("Rename failed");
        }

        System.out.println("\n");
    }
}