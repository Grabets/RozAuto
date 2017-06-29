package Core;

import java.util.Comparator;

/**
 * Created by bogdan on 6/29/2017.
 */
public enum SortTypes {
    PRICE_FROM_LOWER_TO_BIGGER("//a[contains(@class, 'sort-view-l-i-link') and contains(text(), 'от дешевых к дорогим')]", new AscendingComparator()),
    PRICE_FROM_BIGGER_TO_LOWER("//a[contains(@class, 'sort-view-l-i-link') and contains(text(), 'от дорогих к дешевым')]", new DescendingComparator()),
    RELEVANS("//a[contains(@class, 'sort-view-l-i-link') and contains(text(), 'по релевантности')]", null);

    private String locator;
    private Comparator typeOfComparator;

    SortTypes(String locator, Comparator comparator) {
        this.locator = locator;
        this.typeOfComparator = comparator;
    }

    public String getLocator() {
        return locator;
    }

    public Comparator getTypeOfComparator() {
        return typeOfComparator;
    }
}
