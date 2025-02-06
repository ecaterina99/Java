import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

public class WriteToFile {
    public static void main(String[] args) throws FileNotFoundException {

        File file = new File("src/testFile");
        PrintWriter writer = new PrintWriter(file);
        writer.println("Hello World!");
        writer.println("You are welcome!");
        writer.close();
    }
}