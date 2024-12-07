public class Switch {
    public static void main(String[] args) {
        //switch
        int x = 1;
        switch (x) {
            case 0:
                System.out.println("zero");
                break;
            case 1:
                System.out.println("one");
                break;
            default:
                System.out.println("unknown value");
                break;
        }
        //enhanced switch
        int z = 0;

        switch (z) {
            case 0 -> System.out.println("zero");
            case 1 -> System.out.println("one");
            default -> System.out.println("unknown value");
        }
    }
}
