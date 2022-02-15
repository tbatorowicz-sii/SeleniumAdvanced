package models;

import org.apache.commons.math3.util.Precision;

import java.util.ArrayList;

public class Basket {
    private ArrayList<Product> basket;
    private float basketTotalPrice;
    private int totalQuantity;

    public Basket() {
        basket = new ArrayList<>();
        basketTotalPrice = 0;
        totalQuantity = 0;
    }

    public ArrayList<Product> getBasket() {
        return basket;
    }

    public void setBasket(ArrayList<Product> basket) {
        this.basket = basket;
    }

    public float getBasketTotalPrice() {
        return basketTotalPrice;
    }

    public void setBasketTotalPrice(float basketTotalPrice) {
        this.basketTotalPrice = basketTotalPrice;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }


    public void addProduct(Product product) {
        boolean alreadyInBasket = false;
        for (Product p : getBasket()) {
            if (p.getName().equals(product.getName())) {
                alreadyInBasket = true;
                p.setQuantity(p.getQuantity() + product.getQuantity());
                p.setTotalPrice(p.getQuantity() * p.getPrice());
                p.setTotalPrice(Precision.round(p.getTotalPrice(), 2));
                setTotalQuantity(getTotalQuantity() + product.getQuantity());
                setBasketTotalPrice(getBasketTotalPrice() + product.getTotalPrice());
                setBasketTotalPrice(Precision.round(getBasketTotalPrice(), 2));
                break;
            }
        }
        if (!alreadyInBasket) {
            getBasket().add(product);
            setTotalQuantity(getTotalQuantity() + product.getQuantity());
            setBasketTotalPrice(getBasketTotalPrice() + product.getTotalPrice());
            setBasketTotalPrice(Precision.round(getBasketTotalPrice(), 2));
        }
    }


    @Override
    public String toString() {
        return "Basket{" +
               "basket=" + basket +
               ", basketTotalPrice=" + basketTotalPrice +
               '}';
    }
}