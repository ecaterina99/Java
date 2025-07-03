public class Main {
    public static void main(String[] args) {

        Object[] haystack = {"junk", "more", "junk", "needle", "gadget" };
       int length = haystack.length;
        int pos = 0;
        for (int i = 0; i < length; i++) {
            if (haystack[i].equals("needle")) {
                pos = i;
            }
        }

        System.out.println("found the needle at position " + pos);
    }
}
