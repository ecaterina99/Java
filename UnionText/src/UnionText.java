import java.io.*;

/*
Creați un program care să combine conținutul a două fișiere într-un întreg.
Numele fișierelor sunt first.txt şi second.txt. Este necesar să compilați conținutul
acestor două fișiere și să le plasați într-un fișier denumit union.txt.
 */

public class UnionText {
    public static void main(String[] args) {
        String tmpLine;

        try (BufferedReader br1 = new BufferedReader(new FileReader("src/first.txt"));
             BufferedReader br2 = new BufferedReader(new FileReader("src/second.txt"));
             BufferedWriter bw = new BufferedWriter(new FileWriter("src/union.txt"))) {
            while ((tmpLine = br1.readLine()) != null)
                bw.write(tmpLine + "\n");

            while ((tmpLine = br2.readLine()) != null)
                bw.write(tmpLine + "\n");
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }
    }
}