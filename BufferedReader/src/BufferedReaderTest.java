import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class BufferedReaderTest {
    public static void main(String[] args) {

        String text = "this is my text";
        try (BufferedReader br = new BufferedReader(new FileReader("src/new_file.txt"))) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
            }

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}