package models;

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

    public Basket(ArrayList<Product> basket) {
        this.basket = basket;
        basketTotalPrice = 0;
    }


    public void addProduct(Product product) {
        boolean alreadyInBasket = false;
        for (Product p : basket) {
            if (p.getName().equals(product.getName())) {
                alreadyInBasket = true;
                p.setQuantity(p.getQuantity() + product.getQuantity());
                p.setTotalPrice(p.getQuantity()*p.getPrice());
                break;
            }
        }
        if (!alreadyInBasket) {
            basket.add(product);
        }
        totalQuantity += product.getQuantity();
        basketTotalPrice += product.getTotalPrice();
    }

    public void showBasket() {
        for (Product p : basket) {
            System.out.println(p.toString());
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