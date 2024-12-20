/*
You will need a rental car in order for you to get around in your vacation.
The manager of the car rental makes you some good offers.

Every day you rent the car costs $40. If you rent the car for 7 or more days,
you get $50 off your total. Alternatively, if you rent the car for 3 or more days,
you get $20 off your total.

Write a code that gives out the total amount for different days(d).
 */

public class RentalCarCost {
    public static int rentalCarCost(int d) {
        int rentalCarCost = 0;

        if (d < 3) {
            rentalCarCost = 40 * d;
        } else if (d >= 3 && d < 7) {
            rentalCarCost = 40 * d - 20;
        } else {
            rentalCarCost = 40 * d - 50;
        }
        return rentalCarCost;
    }
}
