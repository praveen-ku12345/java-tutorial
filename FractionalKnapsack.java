//Fractional knapsack
import java.util.Arrays;
import java.util.Comparator;

class Item {
    double weight;
    double value;

    public Item(double weight, double value) {
        this.weight = weight;
        this.value = value;
    }
}

public class FractionalKnapsack {
    public static double fractionalKnapsack(Item[] items, double capacity) {
        Arrays.sort(items, Comparator.comparingDouble(item -> item.value / item.weight));
        double totalValue = 0;

        for (int i = items.length - 1; i >= 0; i--) {
            if (capacity == 0) {
                break;
            }

            double fraction = Math.min(1, capacity / items[i].weight);
            totalValue += fraction * items[i].value;
            capacity -= fraction * items[i].weight;
        }

        return totalValue;
    }

    public static void main(String[] args) {
        Item[] items = {
            new Item(2, 10),
            new Item(3, 5),
            new Item(5, 15),
            new Item(7, 7),
            new Item(1, 6)
        };

        double capacity = 15;

        double maxValue = fractionalKnapsack(items, capacity);
        System.out.println("Maximum value in the knapsack: " + maxValue);
    }
}
