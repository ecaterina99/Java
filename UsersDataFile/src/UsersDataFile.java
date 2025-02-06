/*
Se dă un fişier users.txt,  cu următorul conţinut:

id:01|firstName:Tom|lastName:Williams|uid:1234567890123
id:02|firstName:Ben|lastName:Smith|uid:1234567890124
id:03|firstName:Sem|lastName:Davies|uid:1234567890125

Creați un program care să citească fișierul și să emită conținutul lui în următorul format:

User Id: 01
First name: Tom
Last name: Williams
Uid: 1234567890123

------------------------------------

User Id: 02
First name: Ben
Last name: Smith
Uid: 1234567890124
 */

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class UsersDataFile {
    public static void main(String[] args) {
        String userData = """
                id:01|firstName:Tom|lastName:Williams|uid:1234567890123
                id:02|firstName:Ben|lastName:Smith|uid:1234567890124
                id:03|firstName:Sem|lastName:Davies|uid:1234567890125
                """;
        try (BufferedReader br = new BufferedReader(new FileReader("src/user_data"))) {
            String line;

            while ((line = br.readLine()) != null) {
                String[] parts = line.split("\\|");
                for (String part : parts) {
                    System.out.println(part);
                }
                System.out.println("------------------------------------");
            }
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}