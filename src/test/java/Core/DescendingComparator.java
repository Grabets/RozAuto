package Core;

import java.util.Comparator;

/**
 * Created by bogdan on 6/29/2017.
 */
public class DescendingComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        return (Integer) o1 - (Integer) o2;
    }
}
