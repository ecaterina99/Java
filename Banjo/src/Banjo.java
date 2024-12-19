public class Banjo {
    public static String areYouPlayingBanjo(String name) {

        char firstChar = name.charAt(0);

        if (firstChar == 'r' || firstChar == 'R') {
            return name + " plays banjo";
        } else {
            return name + " does not play banjo";
        }
    }
}