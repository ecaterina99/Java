/*
Este necesar să scrieți codul prin care, în cadrul String-ului prezentat,
se vor detecta toate tagurile HTML de deschidere.
 */

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexTest {
    public static void main(String[] args) {
        String str = """
                <html>
                <head>
                    <title>My HTML Document</title>
                </head>
                <body>
                    <p>Hello from my paragraph</p>
                </body>
                </html>""";

        String regex = "<[a-zA-Z]+>";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found:" + count + " " + matcher.group() + " " + matcher.start() + " - " + matcher.end());
        }

        /*
        Este necesar să creaţi expresia regulată care verifică validitatea numărului de telefon introdus.
        Formatul valid al numărului de telefon trebuie să fie: 000/123-456
        */

        Scanner scanner = new Scanner(System.in);
        System.out.println("Please enter your phone number");
        String phone = scanner.nextLine();
        boolean match = phone.matches("[0-9]{3}/[0-9]{3}-[0-9]{3}");
        if (match) {
            System.out.println("Your phone number is valid");
        }
        else {
            System.out.println("Your phone number is not valid");
        }


        

    }
}