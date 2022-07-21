package iO_binary_file.bai_tap.save_binary_file;

import java.io.Serializable;

public class Product implements Serializable {
    private int idProduct;
    private String nameProduct, brandProduct, description;
    private double priceProduct;

    public Product() {
    }

    public Product(int idProduct, String nameProduct, String brandProduct, String description, double priceProduct) {
        this.idProduct = idProduct;
        this.nameProduct = nameProduct;
        this.brandProduct = brandProduct;
        this.description = description;
        this.priceProduct = priceProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public String getBrandProduct() {
        return brandProduct;
    }

    public void setBrandProduct(String brandProduct) {
        this.brandProduct = brandProduct;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(double priceProduct) {
        this.priceProduct = priceProduct;
    }

    @Override
    public String toString() {
        return "Product{" +
                "idProduct=" + idProduct +
                ", nameProduct='" + nameProduct + '\'' +
                ", brandProduct='" + brandProduct + '\'' +
                ", description='" + description + '\'' +
                ", priceProduct=" + priceProduct +
                '}';
    }
}
