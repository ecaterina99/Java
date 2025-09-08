import java.util.Collections;
import java.util.PriorityQueue;

//There is a queue for the self-checkout tills at the supermarket.
// Your task is write a function to calculate the total time required for all the customers to check out!

public class Main {
    public static void main(String[] args) {

        int[] customers = {10, 2, 3, 3, 4, 4};
        int n = 2;

        PriorityQueue<Integer> q = new PriorityQueue<>();
        for (int i = 0; i < n; i++)
            q.add(0);
        for (int t : customers)
            q.add(q.remove() + t);
        System.out.println(Collections.max(q));
    }
}



