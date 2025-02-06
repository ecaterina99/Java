import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadingFromFile {
    public static void main(String[] args) throws FileNotFoundException {
        String separator = File.separator;
        String path = "C:" + separator + "Users" + separator + "Admin" + separator + "Desktop" + separator + "Learning" + separator + "Java" + separator + "test.txt";
        File file = new File(path);
        Scanner scanner = new Scanner(file);
        while (scanner.hasNextLine()) {
            System.out.println(scanner.nextLine());
        }
        scanner.close();


        String path2 = "C:" + separator + "Users" + separator + "Admin" + separator + "Desktop" + separator + "Learning" + separator + "Java" + separator + "test2.txt";
        File file2 = new File(path2);
        Scanner scanner2 = new Scanner(file2);
        String line = scanner2.nextLine();
        String[] numbersString = line.split(" ");
        int[] numbers = new int[numbersString.length];
        int cnt = 0;
        for (String number : numbersString) {
            numbers[cnt++] = Integer.parseInt(number);
        }
        System.out.println(Arrays.toString(numbers));
        scanner2.close();


        File file3 = new File("src/test3");
        Scanner scanner3 = new Scanner(file3);
        while (scanner3.hasNextLine()) {
            System.out.println(scanner3.nextLine());
        }
        scanner3.close();
    }
}


