import java.util.*;

class Item {
    private int weight;
    private int value;

    public Item(int v, int w) {
        weight = w;
        value = v;
    }

    public int getWeight() {
        return weight;
    }

    public int getValue() {
        return value;
    }

    public String toString() {
        return "weight: " + weight + ", value: " + value;
    }
}

public class KnapsackApp {
    public static int NUMBER_ITEMS = 4;
    // private static Random rand = new Random();
    private static Item[] items = new Item[NUMBER_ITEMS];

    public static int knapsackFiller(int capacity, Item[] items, int numberItems) {
        if (numberItems == 0) {
            return 0;
        } else if (items[numberItems - 1].getWeight() > capacity) {
            return knapsackFiller(capacity, items, numberItems - 1);
        } else {
            return Math.max(knapsackFiller(capacity, items, numberItems - 1), items[numberItems - 1].getValue()
                    + knapsackFiller(capacity - items[numberItems - 1].getWeight(), items, numberItems - 1));
        }
    }

    public static void main(String[] args) {
        int capacity = 10;

        // for (int i = 0; i < NUMBER_ITEMS; i++) {
        // int wt = rand.nextInt(9) + 1;
        // int val = rand.nextInt(100);
        // items[i] = new Item(wt, val);
        // }

        // for (Item i : items) {
        // System.out.println(i);
        // }

        items[0] = new Item(3, 5);
        items[1] = new Item(6, 7);
        items[2] = new Item(2, 4);
        items[3] = new Item(1, 1);

        System.out.println("Max value: " + knapsackFiller(capacity, items, items.length));
    }
}
