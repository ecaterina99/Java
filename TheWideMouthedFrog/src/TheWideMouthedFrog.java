public class TheWideMouthedFrog {
    public static String mouthSize(String animal) {
        {
            String result;
            animal = animal.toLowerCase();
            if (animal.equals("alligator")) {
                result = "small";
            } else {
                result = "wide";
            }
            return result;
        }
    }
}