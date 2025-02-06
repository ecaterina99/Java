import java.io.*;

public class InputAndOutputStreams {
    public static void main(String[] args) throws FileNotFoundException {

        //crearea fisierului;

        /*
        String text = "Hello, World2!";
        try (FileOutputStream fos = new FileOutputStream("my_file.txt")){
            fos.write(text.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }

        //citirea fisierului;
        try(FileInputStream fis = new FileInputStream("my_file.txt")){
            int content = fis.read();
            while(content != -1){
                System.out.print((char)content);
                content = fis.read();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
*/

        String myText = "Hello World 3";

        try (FileReader fr = new FileReader("my_file.txt")) {
            int c;
            while ((c = fr.read()) != -1) {
                System.out.print((char) c);
            }
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}