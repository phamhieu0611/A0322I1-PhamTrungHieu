package java_collection_framework.bai_tap.array_list;

import java.util.Comparator;

public class SortUp implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.getPrice() - o2.getPrice();
    }
}
