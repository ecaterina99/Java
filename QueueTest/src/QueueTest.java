import java.util.*;

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


        Queue<String> priorityQueue = new PriorityQueue<>();
        priorityQueue.offer("Vasile");
        priorityQueue.offer("Ion");
        priorityQueue.offer("Larisa");
        priorityQueue.offer("Maria");
        priorityQueue.offer("Ana");

        System.out.println(priorityQueue);

        Queue<String> riverseOrder = new PriorityQueue<>(Collections.reverseOrder());
        riverseOrder.offer("Vasile");
        riverseOrder.offer("Ion");
        riverseOrder.offer("Larisa");
        riverseOrder.offer("Maria");
        riverseOrder.offer("Ana");

        System.out.println(riverseOrder);

        Queue<Integer> priorityNumbersQueue = new PriorityQueue<>();
        priorityNumbersQueue.offer(1);
        priorityNumbersQueue.offer(5);
        priorityNumbersQueue.offer(9);
        priorityNumbersQueue.offer(3);
        priorityNumbersQueue.offer(2);

        while (!priorityNumbersQueue.isEmpty()) {
            System.out.println(priorityNumbersQueue.poll());
        }
    }
}