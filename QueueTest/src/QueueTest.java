import java.util.LinkedList;
import java.util.Queue;

public class QueueTest {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        System.out.println(queue.isEmpty());
        queue.offer("Ana");
        queue.offer("Ion");
        queue.offer("Larisa");
        queue.offer("Maria");
        queue.offer("Vasile");

        System.out.println(queue.isEmpty());
        System.out.println(queue.size());

        System.out.println(queue.peek());
        System.out.println(queue);

        queue.poll();
        System.out.println(queue);
        queue.poll();
        queue.poll();
        System.out.println(queue);

        System.out.println(queue.contains("Vasile"));

        queue.clear();
        System.out.println(queue);

    }
}