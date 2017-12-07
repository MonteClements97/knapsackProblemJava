/**
 * A basic class for an item in the fractional and the 0/1 knapsack problem.
 * @author Christine Zarges
 * @version 1.0, 8th November 2017
 */
public class Item{
    /**
     * id of the item; used for printing; cannot be changed after initialisation
     */
    private final int id;

    /**
     * the value of the item; cannot be changed after initialisation
     */
    private final int value;

    /**
     * the weight of the item; cannot be changed after initialisation
     */
    private final int weight;

    /**
     * the weight that is actually packed
     * fractional knapsack problem: value between 0 and weight (inclusive)
     * 0/1 knapsack problem: either 0 or weight
     */
    private int fraction;

    /**
     * value per weight unit (value/weight); cannot be changed after initialisation
     */
    private final double efficiency;

    /**
     * Constructor setting id, value and weight. Efficiency is initialised based value and weight provided.
     * Only the fraction can be change afterwards.
     * @param id the id of the item
     * @param value the value of the item
     * @param weight the weight of the item
     */
    public Item(int id, int value, int weight) {
        this.id = id;
        this.value = value;
        this.weight = weight;
        this.fraction = 0;
        this.efficiency = (double)value/(double)weight;
    }

    /**
     * getter for member variable id
     * @return the id of the item
     */
    public int getId() {
        return id;
    }

    /**
     * getter for member variable value
     * @return the value of the item
     */
    public int getValue() {
        return value;
    }

    /**
     * getter for member variable weight
     * @return the weight of the item
     */
    public int getWeight() {
        return weight;
    }

    /**
     * getter for member variable fraction
     * @return the weight of the item that is actually packed
     */
    public int getFraction() {
        return fraction;
    }

    /**
     * setter for the member variable fraction
     * @param fraction the weight of the item that is actually packed
     */
    public void setFraction(int fraction) {
        this.fraction = fraction;
    }

    /**
     * getter for the member variable efficiency
     * @return the efficiency of the item
     */
    public double getEfficiency() {
        return efficiency;
    }
}