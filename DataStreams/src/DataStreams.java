import java.io.*;

public class DataStreams {
    public static void main(String[] args) {
        //write
        int variableA = 13;
        double variableB = 13.13;
        String variableC = "Hello!";

        try (DataOutputStream out = new DataOutputStream(new FileOutputStream("src/myFile.txt"))) {
            out.writeInt(variableA);
            out.writeDouble(variableB);
            out.writeUTF(variableC);
        } catch (IOException exc) {
            System.out.println(exc.getMessage());
        }


        //read
        try (DataInputStream in = new DataInputStream(new FileInputStream("src/myFile.txt"))) {
            System.out.println(in.readInt());
            System.out.println(in.readDouble());
            System.out.println(in.readUTF());
        } catch (IOException exc) {
            System.out.println(exc.getMessage());

        }
    }
}