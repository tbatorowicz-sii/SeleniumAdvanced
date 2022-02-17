package models;

import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;

public class Basket {
    private final ArrayList<Product> basket;
    private int totalQuantity;
    private float basketTotalPrice;


    public ArrayList<Product> getBasket() {
        return basket;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public float getBasketTotalPrice() {
        return basketTotalPrice;
    }

    public void setBasketTotalPrice(float basketTotalPrice) {
        this.basketTotalPrice = Precision.round(basketTotalPrice, 2);
    }


    public Basket() {
        basket = new ArrayList<>();
        totalQuantity = 0;
        basketTotalPrice = 0;
    }


    public void addProduct(Product product) {
        boolean alreadyInBasket = false;
        for (Product p : basket) {
            if (p.getName().equals(product.getName())) {
                alreadyInBasket = true;
                p.setQuantity(p.getQuantity() + product.getQuantity());
                p.setTotalPrice(p.getQuantity() * p.getPrice());
                break;
            }
        }
        if (!alreadyInBasket) basket.add(product);
        totalQuantity += product.getQuantity();
        setBasketTotalPrice(getBasketTotalPrice() + product.getTotalPrice());
    }

}