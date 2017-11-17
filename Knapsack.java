import java.util.Comparator;
import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * A basic class for the fractional and the 0/1 knapsack problem.
 * @author Christine Zarges
 * @version 1.0, 8th November 2017
 */
public class Knapsack {
    private PriorityQueue<Item> hiImBarryScott_NothingBeatsABitOfTurboPower;
    /**
     * capacity of the knapsack; cannot be changed after initialisation
     */
    private final int capacity;

    /**
     * an array with all available items
     */
    private Item[] items;

    /**
     * Constructor setting capacity and items. The capacity cannot be changed afterwards,
     * but items can to allow for ordering.
     * @param capacity the capacity of the knapsack
     * @param items an array with all available items
     */
    public Knapsack(int capacity, Item[] items) {
        this.capacity = capacity;
        this.items = items;
    }

    /**
     * getter for member variable capacity
     * @return the capacity of the knapsack
     */
    public int getCapacity() {
        return capacity;
    }

    /**
     * getter for the member variable items
     * @return an array with all the available items
     */
    public Item[] getItems() {
        return items;
    }

    /**
     * setter for the member variable items
     * @param items an array with all the available items
     */
    public void setItems(Item[] items) {
        this.items = items;
    }

    /**
     * resets the fraction to be packed to zero
     */
    public void resetSelection() {
        for(int i = 0; i < items.length; i++){
            items[i].setFraction(0);
        }
    }

    /**
     * A utility function that returns maximum of two integers
     * @param a first integer
     * @param b second integer
     * @return the maximum of the two integers
     */
    private int max(int a, int b) { return (a > b)? a : b; }

    /**
     * Returns the maximum value that can be put in the knapsack in the 0/1 knapsack problem variant
     * @return the maximal value that can be reached
     */
    public int getOptimum()
    {
        try {
            int table[][] = new int[items.length + 1][capacity + 1];

            // Build table in bottom up manner
            for (int i = 0; i <= items.length; i++) {
                for (int w = 0; w <= capacity; w++) {
                    if (i == 0 || w == 0)
                        table[i][w] = 0;
                    else if (items[i - 1].getWeight() <= w)
                        table[i][w] = max(items[i - 1].getValue()
                                + table[i - 1][w - items[i - 1].getWeight()], table[i - 1][w]);
                    else
                        table[i][w] = table[i - 1][w];
                }
            }

            return table[items.length][capacity];
        } catch (OutOfMemoryError e){
            System.out.println("Computation of optimal solution does not work for very large capacities.");
            e.printStackTrace();
            System.exit(1);
        }
        return 0;
    }

    /**
     * Greedy strategy that always packs the item with the smallest weight
     * in the fractional knapsack problem.
     * @return the total value of all packed items
     */
    public double greedyWeightFractional() {
        int knapCap = this.capacity;
        double totalValue = 0;
        Comparator<Item> compWeight = new CompWeight();
        this.hiImBarryScott_NothingBeatsABitOfTurboPower = new PriorityQueue<>(compWeight);
        for(Item i: items){
            this.hiImBarryScott_NothingBeatsABitOfTurboPower.add(i);
        }
        while(knapCap > 0 || this.hiImBarryScott_NothingBeatsABitOfTurboPower.peek() == null){
            Item currentItem = this.hiImBarryScott_NothingBeatsABitOfTurboPower.poll();
            if (knapCap - currentItem.getWeight() >= 0){
                totalValue += currentItem.getValue();
                knapCap -= currentItem.getWeight();
            }
            else {
                totalValue += (double)(currentItem.getValue() / knapCap);
                return totalValue;
            }
        }
        return totalValue;
    }

    /**
     * Greedy strategy that always packs the item with the largest value
     * in the fractional knapsack problem.
     * @return the total value of all packed items
     */
    public double greedyValueFractional() {
        //TODO: Add your code here!
        return 0.0;
    }

    /**
     * Greedy strategy that always packs the item with the highest efficiency
     * in the fractional knapsack problem.
     * @return the total value of all packed items
     */
    public double greedyEfficiencyFractional() {
        //TODO: Add your code here!
        return 0.0;
    }

    /**
     * Greedy strategy that always packs the item with the smallest weight
     * in the 0/1 knapsack problem.
     * @return the total value of all packed items
     */
    public double greedyWeight() {
        //TODO: Add your code here!
        return 0.0;
    }

    /**
     * Greedy strategy that always packs the item with the largest value
     * in the 0/1 knapsack problem.
     * @return the total value of all packed items
     */
    public double greedyValue() {
        //TODO: Add your code here!
        return 0.0;
    }

    /**
     * Greedy strategy that always packs the item with the highest efficiency
     * in the 0/1 knapsack problem.
     * @return the total value of all packed items
     */
    public double greedyEfficiency() {
        //TODO: Add your code here!
        return 0.0;
    }
}
