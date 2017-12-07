
/**
 * Created by moc17 on 17/11/2017.
 */
import java.util.Comparator;

public class CompWeight implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2){
        return o1.getWeight() - o2.getWeight();
    }


}