package java_collection_framework.bai_tap.linked_list;

import java.util.Comparator;

public class SortDown implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o2.getPrice() - o1.getPrice();
    }
}
