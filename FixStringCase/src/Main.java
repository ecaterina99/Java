//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {

        String str = "HeLLoo";
        String str2 = "Hello";
        String str3 = "HELLo";
        String result = "";

        int uppercase = 0;
        int lowercase = 0;

        for (int i = 0; i < str3.length(); i++) {
            if (Character.isUpperCase(str3.charAt(i))) {
                uppercase++;
            } else {
                lowercase++;
            }
        }

        if (uppercase > lowercase) {
            result = str3.toUpperCase();
        } else {
            result = str3.toLowerCase();
        }

        System.out.println(result);
    }
}