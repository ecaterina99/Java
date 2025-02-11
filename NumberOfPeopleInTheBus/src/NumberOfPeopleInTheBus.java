/*
There is a bus moving in the city which takes and drops some people at each bus stop.
You are provided with a list (or array) of integer pairs.
Elements of each pair represent the number of people that get on the bus (the first item)
and the number of people that get off the bus (the second item) at a bus stop.

Your task is to return the number of people who are still on the bus after the last bus stop
(after the last array). Even though it is the last bus stop, the bus might not be empty.

The number of people in the bus is always >= 0. So the returned integer can't be negative.
The second value in the first pair in the array is 0, since the bus is empty in the first bus stop.
 */


import java.util.ArrayList;

public class NumberOfPeopleInTheBus {
    public static void main(String[] args) {

        int stop = 0;
        int cntPeople = 0;
        ArrayList<int[]> PassengersInBus = new ArrayList<>();
        PassengersInBus.add(new int[]{10, 0});
        PassengersInBus.add(new int[]{3, 5});
        PassengersInBus.add(new int[]{2, 5});

        for (int i = 0; i < PassengersInBus.size(); i++) {
            cntPeople += PassengersInBus.get(i)[0] - PassengersInBus.get(i)[1];
        }
        System.out.println(cntPeople);
    }
}
