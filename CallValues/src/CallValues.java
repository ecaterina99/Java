/*
This kata is about static method that should return different values.
On the first call it must be 1, on the second and others - it must be a double from previous value.
 */

public class CallValues {

    public static double input = 0.5;

    public static int getNumber() {
        input = input * 2;
        return (int) input;
    }
}
