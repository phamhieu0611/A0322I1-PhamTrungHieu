package java_collection_framework.bai_tap.linked_list;

import java.util.Collections;
import java.util.LinkedList;
import java.util.Scanner;

public class ProductManager{
    private LinkedList<Product> linkedList = new LinkedList<>();

    public static void managementProduct(){
        ProductManager manager = new ProductManager();
        Scanner scanner = new Scanner(System.in);
        int select = 0;
        do {
            System.out.println("-------MENU-------");
            System.out.println("1. Display list product.");
            System.out.println("2. Add new product.");
            System.out.println("3. Edit product.");
            System.out.println("4. Remove product.");
            System.out.println("5. Find by produt name.");
            System.out.println("6. Sort ascending.");
            System.out.println("7. Sort decrease.");
            System.out.println("8. Exit.");
            select = Integer.parseInt(scanner.nextLine());

            switch (select){
                case 1:
                    manager.displayProduct();
                    break;
                case 2:
                    System.out.println("Input ID: ");
                    int id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input product name: ");
                    String name = scanner.nextLine();
                    System.out.println("Input product price:");
                    int price = Integer.parseInt(scanner.nextLine());
                    manager.addProduct(new Product(id, name, price));
                    break;
                case 3:
                    System.out.println("Input ID: ");
                    id = Integer.parseInt(scanner.nextLine());
                    System.out.println("Input product name: ");
                    name = scanner.nextLine();
                    System.out.println("Input product price:");
                    price = Integer.parseInt(scanner.nextLine());
                    manager.editProduct(id, name, price);
                    break;
                case 4:
                    System.out.println("Input ID: ");
                    id = Integer.parseInt(scanner.nextLine());
                    manager.removeProduct(id);
                    break;
                case 5:
                    System.out.println("Input product name:");
                    name = scanner.nextLine();
                    manager.findByName(name);
                    break;
                case 6:
                    manager.sortUpper();
                    break;
                case 7:
                    manager.sortdowner();
                    break;
                case 8:
                    System.exit(0);
            }
        }while (true);
    }

    public ProductManager(Product product){
        addProduct(product);
    }

    public ProductManager() {

    }

    public void addProduct(Product product) {
        linkedList.add(product);
    }

    public void removeProduct(int id){
        int index = -1;
        for (Product product1 : this.linkedList){
            if (product1.getIdProduct() == id){
                index+=1;
                break;
            }
        }if (index == -1){
            System.out.println("This product not found!");
        }else {
            linkedList.remove(index);
        }
    }

    public void displayProduct(){
        for (Product product1 : this.linkedList){
            System.out.println(product1.toString());
        }
    }

    public void editProduct(int id, String nameProduct, int price){
        Product product = null;
        for (Product product1 : this.linkedList){
            if (product1.getIdProduct() == id){
                product = product1;
                break;
            }
        }if (product == null){
            System.out.println("Product not found!");
        }else {
            product.setNameProduct(nameProduct);
            product.setPrice(price);
        }
    }

    public void findByName(String nameInput){
        Product product = null;
        for (Product product1 : this.linkedList){
            if (product1.getNameProduct().equals(nameInput)) {
                product = product1;
                System.out.println("Product name " + nameInput + " " + product1.toString());
            }
        }if (product == null)
            System.out.println("Product not found!");
    }

    public void sortUpper(){
        SortUp sortUp = new SortUp();
        Collections.sort(this.linkedList, sortUp);
    }
    public void sortdowner(){
        SortDown sortDown = new SortDown();
        Collections.sort(linkedList, sortDown);
    }

    public static void main(String[] args) {
        managementProduct();
    }
}
