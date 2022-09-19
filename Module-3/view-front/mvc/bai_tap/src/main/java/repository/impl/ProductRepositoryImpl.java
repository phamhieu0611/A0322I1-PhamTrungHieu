package repository.impl;

import bean.Product;
import repository.ProductRepository;

import java.util.*;

public class ProductRepositoryImpl implements ProductRepository {

    private static Map<String, Product> productMap;
    static {
        productMap = new LinkedHashMap<>();
        productMap.put("p001", new Product("p001", "product 1", 100000, "banh", "Hiue"));
        productMap.put("p002", new Product("p002", "product 2", 100000, "banh", "Hiue"));
        productMap.put("p003", new Product("p003", "product 3", 100000, "banh", "Hiue"));
        productMap.put("p004", new Product("p004", "product 4", 100000, "banh", "Hiue"));
        productMap.put("p005", new Product("p005", "product 5", 100000, "banh", "Hiue"));
    }
    @Override
    public List<Product> findAll() {
        return new ArrayList<>(productMap.values());
    }

    @Override
    public void create(Product product) throws Exception {
        if(productMap.containsKey(product.getId())){
            throw new Exception("Duplicate id");
        }else{
            productMap.put(product.getId(),product);
        }
    }

    @Override
    public void update(Product product) throws Exception {
        if(!productMap.containsKey(product.getId())){
            throw new Exception("Product not Found");
        }else{
            productMap.put(product.getId(),product);
        }
    }

    @Override
    public void delete(String id) throws Exception {
        if(productMap.containsKey(id)){
            productMap.remove(id);
        }else{
            throw new Exception("Product not Found");
        }
    }

    @Override
    public Product findById(String id) throws Exception {
        if(productMap.containsKey(id)){
            return productMap.get(id);
        }
        throw new Exception("Product not Found");
    }

    @Override
    public List<Product> findByName(String name) throws Exception {
        List<Product> result = new LinkedList<>();
        Set<String> sizeMap = productMap.keySet();
        for(String status: sizeMap){
            if(productMap.get(status).getName().matches(".*["+name+"].*")){
                result.add(productMap.get(status));
            }
        }
        if(result.size() != 0){
            return result;
        }
        throw new Exception("Product not Found");
    }
}