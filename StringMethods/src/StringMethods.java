import java.time.LocalDate;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Stream;

public class StringMethods {

    public static void main(String[] args) {
        String str = "first line \nsecond line \nthird line \nfourth line";
        Stream<String> lines = str.lines();
        lines.forEach(System.out::println);

        String str1 = "first line \nsecond line \nthird line \nfourth line";
        String indentedString = str1.indent(6);
        System.out.println(indentedString);

        String str3 = "Hello World";
        System.out.println((str3+" ").repeat(3));

        String text = """
    Acesta este un text
    formatat pe mai multe linii,
    scris într-un mod clar și curat.
    """;
        System.out.println(text);


        String myString = """
        Lorem ipsum dolor sit amet, \
        consectetur adipiscing elit. \
        Nam vitae mollis arcu, vel sodales \
        tortor. Nam sit amet diam ex. Integer \
        fermentum, in mattis libero ornare. Nam \
        elementum dui nec urna sodales, \
        non tempor quam semper.""";
        System.out.println(myString);


        String str4 = "This is a sentence.  This is a question, right?  Yes!  It is.";
        String[] wordArray = str4.split("[ .,?!]+");

        System.out.println("Return Value: ");
        for (String s : wordArray) {
            System.out.println(s);
        }


        String str5 = "This is some text, that will be searched for occurrences of word: some";

        String regex = "some";

        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(str5);

        int count = 0;
        while (matcher.find()) {
            count++;
            System.out.println("found: " + count + " : "
                    + matcher.start() + " - " + matcher.end());
        }

        System.out.println(LocalDate.now());

        LocalDate localDate = LocalDate.of(2000, 06, 30);
        System.out.println(localDate.minusDays(1).getDayOfMonth());
    }
}
