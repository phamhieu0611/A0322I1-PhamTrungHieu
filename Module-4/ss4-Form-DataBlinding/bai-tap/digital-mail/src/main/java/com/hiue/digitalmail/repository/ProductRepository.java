package com.hiue.digitalmail.repository;

import com.hiue.digitalmail.model.Product;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class ProductRepository implements IRepository{
    private static List<Product> products;
    static {
        products = new ArrayList<>();
        products.add(new Product(1, 1, 5, "English", "King, Asgard"));
        products.add(new Product(2, 0, 10, "English", "King, Asgard"));
        products.add(new Product(3, 1, 15, "English", "King, Asgard"));
        products.add(new Product(4, 1, 25, "English", "King, Asgard"));
    }
    @Override
    public List<Product> findAll() {
        return products;
    }

}
