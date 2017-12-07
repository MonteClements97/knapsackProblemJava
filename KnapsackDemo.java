import java.io.*;
import java.util.Scanner;
import java.text.DecimalFormat;

/**
 * The demo class that we will run for testing
 * @author Christine Zarges
 * @version 1.0, 8th November 2017
 */

public class KnapsackDemo {

    /**
     * instance of the knapsack problem
     */
    private Knapsack knapsack;

    /**
     * for formatting number output
     */
    private DecimalFormat numberFormat;

    /**
     * creates an instance of the knapsack problem from a given file
     */
    private void createInstanceFromFile() {
        Scanner scanner = new Scanner(System.in);
        numberFormat = new DecimalFormat("#0.0");

        System.out.print("Enter filename: ");
        String filename = scanner.nextLine();

        try {
            // open selected file
            File file = new File(filename);
            BufferedReader buffer = new BufferedReader(new FileReader(file));

            // read file line by line
            String readLine = buffer.readLine();
            String[] entry = readLine.split("\\s");

            int n = Integer.parseInt(entry[0]);
            Item[] items = new Item[n];
            int capacity = Integer.parseInt(entry[1]);

            int num = 0;
            while ((readLine = buffer.readLine()) != null) {
                entry = readLine.split("\\s");
                items[num] = new Item(num, Integer.parseInt(entry[0]), Integer.parseInt(entry[1]));
                num++;
            }

            // create knapsack instance
            knapsack = new Knapsack(capacity, items);
        } catch (FileNotFoundException e) {
            System.out.println("File not found.");
            System.exit(1);
        } catch (IOException | NumberFormatException e) {
            System.out.println("Unable to read file.");
            System.exit(1);
        }
    }

    /**
     * prints the knapsack instance to be solved
     */
    private void printInstance(){
        System.out.println("Knapsack capacity = "+knapsack.getCapacity());
        Item[] items = knapsack.getItems();
        for(int i = 0; i < items.length-1; i++){
            System.out.print(items[i].getId()+":("+items[i].getValue()+", "+items[i].getWeight()+"), ");
        }
        int i = items.length-1;
        System.out.println(items[i].getId()+":("+items[i].getValue()+", "+items[i].getWeight()+")");
    }

    /**
     * determines the list of items selected by the algorithm by reading out the fraction values
     * @return a String representing the solution, i.e., the set of items selected
     */
    private String printSelection(){
        Item[] items = knapsack.getItems();
        boolean first = true;
        String selection = " (";
        for(int i = 0; i < items.length; i++){
            // item completely packed
            if (items[i].getFraction() == items[i].getWeight()){
                if (!first)
                    selection += ", ";
                selection += items[i].getId();
                first = false;
            }
            // only a fraction of the item packed
            else if (items[i].getFraction() > 0) {
                if (!first)
                    selection += ", ";
                selection += (items[i].getFraction()+" of "+items[i].getId());
                first = false;
            }
        }
        selection += ")";
        return selection;
    }

    /**
     * runs the different algorithms and prints the results
     */
    private void run(){
        createInstanceFromFile();
        printInstance();

        System.out.println("Fractional Greedy Weight: "
                +"     "+numberFormat.format(knapsack.greedyWeightFractional())
                +" "+printSelection());

        knapsack.resetSelection();
        System.out.println("Fractional Greedy Value: "
                +"      "+numberFormat.format(knapsack.greedyValueFractional())
                +" "+printSelection());

        knapsack.resetSelection();
        System.out.println("Fractional Greedy Efficiency: "
                +" "+numberFormat.format(knapsack.greedyEfficiencyFractional())
                +" "+printSelection());

        knapsack.resetSelection();
        System.out.println("(0/1) Greedy Weight: "
                +"          "+numberFormat.format(knapsack.greedyWeight())
                +" "+printSelection());

        knapsack.resetSelection();
        System.out.println("(0/1) Greedy Value: "
                +"           "+numberFormat.format(knapsack.greedyValue())
                +" "+printSelection());

        knapsack.resetSelection();
        System.out.println("(0/1) Greedy Efficiency: "
                +"      "+numberFormat.format(knapsack.greedyEfficiency())
                +" "+printSelection());

        knapsack.resetSelection();
        System.out.println("(0/1) Optimal value: "+"          "+knapsack.getOptimum());
    }

    public static void main(String args[]) {
        KnapsackDemo demo = new KnapsackDemo();
        demo.run();
    }

}