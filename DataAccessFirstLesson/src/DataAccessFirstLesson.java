import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class DataAccessFirstLesson {
    public static void main(String[] args) throws IOException {
        /*Person person = new Person("John Deen", 55, "313/AB");
        FileWriter fw = new FileWriter("myFile.txt");
        fw.write(person.toString() + "\n");
        fw.close();
    }
         */
        Person person = null;

        FileReader fr = new FileReader("myFile.txt");
        StringBuilder stringBuilder = new StringBuilder();

        int ch;
        while ((ch = fr.read()) != -1) {
            stringBuilder.append((char) ch);
        }

        String userData = stringBuilder.toString();
        String[] userProps = userData.split("\n");

        if (userProps.length == 3) {
            person = new Person(userProps[0], Integer.valueOf(userProps[1]), userProps[2]);
        }

        System.out.println(person);
    }

}