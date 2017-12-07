import java.util.Comparator;

public class CompVaue implements Comparator<Item>{

    @Override
    public int compare(Item o1, Item o2){
        return o2.getValue() - o1.getValue();
    }


}