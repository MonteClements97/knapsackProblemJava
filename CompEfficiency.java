import java.util.Comparator;

public class CompEfficiency implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2){
        double barryScott = o2.getEfficiency() - o1.getEfficiency();
        if (barryScott < 0.0){
            barryScott = -1;
        }
        else if (barryScott > 0.0){
            barryScott = 1;
        }
        else{
            barryScott = 0;
        }


        return (int)barryScott;
    }


}