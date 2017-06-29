package Core;

import java.util.Comparator;

/**
 * Created by bogdan on 6/29/2017.
 */
public class AscendingComparator implements Comparator {

    public int compare(Object o1, Object o2) {
        return (Integer) o2 - (Integer) o1;
    }
}
