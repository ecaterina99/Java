import java.util.regex.Matcher;
import java.util.regex.Pattern;
/*
You need to write regex that will validate a password to make sure it meets the following criteria:
At least six characters long
contains a lowercase letter
contains an uppercase letter
contains a digit
only contains alphanumeric characters (note that '_' is not alphanumeric)
 */

public class Main {
    public static void main(String[] args) {
        String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[A-Za-z\\d]{6,}$";
        String password = "AaBb12_3";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(password);
        System.out.println(matcher.matches());
    }
}