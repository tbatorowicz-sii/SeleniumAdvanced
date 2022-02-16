package models;

import org.apache.commons.math3.util.Precision;

public class Product {

    private final String name;
    private final float price;
    private int quantity;
    private float totalPrice;

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
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
        this.totalPrice = Precision.round(totalPrice, 2);
    }

    public Product(String name, float price, int quantity) {
        this.name = name;
        this.price = Precision.round(price, 2);
        this.quantity = quantity;
        totalPrice = Precision.round(price * quantity, 2);
    }

    public Product(String name, float price, int quantity, float totalPrice) {
        this.name = name;
        this.price = Precision.round(price, 2);
        this.quantity = quantity;
        this.totalPrice = Precision.round(totalPrice, 2);
    }

}