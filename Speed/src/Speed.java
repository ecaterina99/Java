public class Speed {
    public static void main(String[] args) {
        int speed = 50;
        if (speed < 10) {
            System.out.println("Too slow...");
        } else if (speed <= 80) {
            System.out.println("Regular speed.");
        } else if (speed < 100) {
            System.out.println("Too fast!");
        } else {
            System.out.println("Incorrect value");
        }
    }
}

