/**
 * Created by moc17 on 17/11/2017.
 */
import java.util.Comparator;

public class CompEfficiency implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2){
        double barryScott = o1.getEfficiency() - o2.getEfficiency();
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