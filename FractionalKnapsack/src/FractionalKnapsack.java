import java.util.Arrays;
import java.util.Comparator;

public class FractionalKnapsack {
    public static void main(String[] args) {
        final Item item1 = new Item(4, 20);
        final Item item2 = new Item(3, 18);
        final Item item3 = new Item(2, 14);

        final Item[] items = {item1, item2, item3};

        // Sorts the items in descending order based on their value-to-weight ratio.
        // Time complexity: O(n log n), where n is the number of items.
        Arrays.sort(items, Comparator.comparingDouble(Item::valuePerWeight).reversed());
        System.out.println(Arrays.toString(items));

        // The maximum weight the knapsack can carry.
        final int knapsackWeight = 7;

        int weightSoFar = 0;
        double valueSoFar = 0;
        int currentItem = 0;

        // Loops through the items until the knapsack is full or all items are processed.
        while (currentItem < items.length && weightSoFar != knapsackWeight) {
            if (weightSoFar + items[currentItem].getWeight() < knapsackWeight) {


                // If the entire item can fit, add its full value and weight.
                valueSoFar += items[currentItem].getValue();
                weightSoFar += items[currentItem].getWeight();

            } else {
                // If only part of the item can fit, add the proportional value.
                valueSoFar += ((knapsackWeight - weightSoFar) / (double) items[currentItem].getWeight()) *
                        items[currentItem].getValue();
                weightSoFar = knapsackWeight;
            }
            currentItem++;
        }
        System.out.println("The best possible value for the knapsack: " + valueSoFar);

    }
}

class Item {
    private int weight;
    private int value;

    public Item(int weight, int value) {
        this.weight = weight;
        this.value = value;

    }
    public double valuePerWeight() {
        return value / (double) weight;
    }

    public int getValue() {
        return value;
    }

    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "value: " + value + ": weight" + weight + " valuePerWeight: " + valuePerWeight();
    }
}
