public class cylinderVolume {
    public static void main(String[] args) {
        final float PI = 3.14F;
        int r = 10;
        int h = 50;
        // Calculating the volume of the cylinder
        double v = PI * (r * r) * h;
        // Displaying the result
        System.out.printf("The volume of the cylinder is: %.2f%n", v);
    }
}