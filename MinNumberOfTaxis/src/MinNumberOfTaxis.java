/*
You work at a taxi central.
People contact you to order a taxi. They inform you of the time they want to be picked up and dropped off.

A taxi is available to handle a new customer 1 time unit after it has dropped off a previous customer.

What is the minimum number of taxis you need to service all requests?

Constraints:
Let N be the number of customer requests:
N is an integer in the range [1, 100k]
All times will be integers in range [1, 10k]
Let PU be the time of pickup and DO be the time of dropoff
Then for each request: PU < DO
The input list is NOT sorted.
 */
import java.util.*;
public class MinNumberOfTaxis {
    public static void main(String[] args) {

        int[][] reqs={{1, 4}, {2, 9}, {3, 6}, {5, 8}};

                PriorityQueue<Integer> taxis = new PriorityQueue<>();
                taxis.add(0);

                for (int[] req : reqs)
                {
                    if (taxis.peek() < req[0])
                    { taxis.poll(); }
                    taxis.add(req[1]);
                }

                System.out.println(taxis.size());

    }
}