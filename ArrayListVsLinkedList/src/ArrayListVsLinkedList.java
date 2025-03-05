import java.util.ArrayList;
import java.util.LinkedList;

public class ArrayListVsLinkedList {
    public static void main(String[] args) {
        LinkedList<Integer> linkedList = new LinkedList<>();
        ArrayList<Integer> arrayList = new ArrayList<>();

        long startTime;
        long endTime;
        long elapsedTime;

        for (int i = 0; i < 1000000; i++) {
            linkedList.add(i);
            arrayList.add(i);
        }

        //************LinkedList************
        startTime = System.nanoTime();
        // linkedList.get(1);
        //linkedList.get(999999);
        // linkedList.remove(0);
        linkedList.remove(999999);
        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Linked list\t: " + elapsedTime);

        //************ArrayList************
        startTime = System.nanoTime();
        //arrayList.get(1);
        //arrayList.get(999999);
        //arrayList.remove(0);
        arrayList.remove(999999);

        endTime = System.nanoTime();
        elapsedTime = endTime - startTime;

        System.out.println("Array list\t: " + elapsedTime);
    }

}