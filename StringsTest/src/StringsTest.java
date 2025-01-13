import java.util.Arrays;

/*
În aplicaţie intră o secvenţă de stringuri. Dimensiunea permisă a acestor stringuri la ieşire
este de 25 de caractere, însă unele dintre ele sunt mai mari la ieşire. Creaţi un program care,
atunci când un string depăşeşte dimensiunea de 25 de caractere, va întrerupe stringul şi va introduce
trei puncte în locul ultimelor trei caractere. Stringurile astfel procesate trebuie afişate la ieşire.
 */
public class StringsTest {
    public static void main(String[] args) {
        String[] texts =
                {"Optimum pH of your water is between 6.0 and 7.0.  However Oscars are okay in a pH up to 8.0.",

                        "The Oscar fish is not a difficult fish to look after if you give it a suitable environment to live in. " +

                                "The Oscar has the potential to reach 18 inches. However in captivity Oscars normally grow to between 8 and 12 inches"};

        for (int i = 0; i < texts.length; i++) {
            if (texts[i].length() > 25) {
                String tempText = texts[i].substring(0, 22);
                System.out.println(tempText.concat("..."));
            }
        }


        /*
        Ex.2
        În aplicaţie intră o listă de fişiere sub forma unui şir.
        Folosind extensia, trebuie să recunoaşteţi doar fişierele de tip jpg, png sau gif,
        iar la ieşire să emiteţi un mesaj despre tipul lor:
        File: picture1.jpg of type jpg
         */
        String[] files = {"picture1.jpg", "text1.txt", "picture2.png", "text2.doc", "picture3.gif"};

        for (int i = 0; i < files.length; i++) {
            if (files[i].endsWith("jpg")) {
                System.out.println("File: " + files[i] + " of type jpg");
            } else if (files[i].endsWith("txt")) {
                System.out.println("File: " + files[i] + " of type txt");
            } else if (files[i].endsWith("gif")) {
                System.out.println("File: " + files[i] + " of type gif");
            }
        }

        /* Ex.3
        În aplicaţie intră datele prin următorul String:
        String users = "Name: John|Surname: Lord|Name: Ben|Surname: Torrance|Name: Tom|Surname: Ford";
        Trebuie formatate datele astfel încât ieşirea aplicaţiei să fie:
        First name is: John, last name is: Lord
         */

        String users = "Name: John|Surname: Lord|Name: Ben|Surname: Torrance|Name: Tom|Surname: Ford";
        String[] wordArray1 = users.split("\\|");

        for (int i = 0; i < wordArray1.length; i += 2) {
            String firstName = wordArray1[i].split(" ")[1];
            String lastName = wordArray1[i + 1].split(" ")[1];
            System.out.println("First name is:" + firstName + ", last name is:" + lastName);
        }


        //Ex4
        /*
        În aplicaţie intră datele prin următoarele două Stringuri:
        String[] forbidenChars = { "<",">","'" };
        String input = "<div>my 'div' tag</div>";

         Trebuie curăţat stringul astfel încât la ieşire să nu fie caractere specificate
         în lista de caractere care nu sunt permise.
         divmy div tag/div
         */


        String[] forbidenChars = {"<", ">", "'"};
        String input = "<div>my 'div' tag</div>";

        for (int i = 0; i < forbidenChars.length; i++) {
            input = input.replace(forbidenChars[i], "");
        }
        System.out.println(input);

    }
}
