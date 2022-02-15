package models;

import org.apache.commons.math3.util.Precision;

public class Product {

    private String name;
    private float price;
    private int quantity;
    private float totalPrice;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = Precision.round(price, 2);
        this.quantity = quantity;
        totalPrice = Precision.round(price * quantity, 2);
    }

    @Override
    public String toString() {
        return "Product{" +
               "name='" + name + '\'' +
               ", price=" + price +
               ", quantity=" + quantity +
               ", totalPrice=" + totalPrice +
               '}';
    }
}
