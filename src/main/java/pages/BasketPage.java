package pages;


import models.Basket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

import java.util.List;
import java.util.stream.IntStream;

public class BasketPage extends BasePage {

    public BasketPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "li.cart-item a.label")
    private List<WebElement> productsName;

    @FindBy(css = "li.cart-item span.price")
    private List<WebElement> productsPrice;

    @FindBy(css = "li.cart-item input.form-control")
    private List<WebElement> productsQuantity;

    @FindBy(css = "li.cart-item span.product-price")
    private List<WebElement> productsTotalPrice;

    @FindBy(css = "div#cart-subtotal-products span.value")
    private WebElement totalOrderPrice;

    public List<WebElement> getProductsName() {
        return productsName;
    }

    public List<WebElement> getProductsPrice() {
        return productsPrice;
    }

    public List<WebElement> getProductsQuantity() {
        return productsQuantity;
    }

    public List<WebElement> getProductsTotalPrice() {
        return productsTotalPrice;
    }

    public WebElement getTotalOrderPrice() {
        return totalOrderPrice;
    }

    public String returnProductsName(int index) {
        return getProductsName().get(index).getText();
    }

    public Float returnProductsPrice(int index) {
        return Float.valueOf(getProductsPrice().get(index).getText().substring(1));
    }

    public int returnProductsQuantity(int index) {
        return Integer.parseInt(getProductsQuantity().get(index).getAttribute("value"));
    }

    public Float returnProductsTotalPrice(int index) {
        return Float.valueOf(getProductsTotalPrice().get(index).getText().substring(1));
    }

    public Float returnTotalOrderPrice() {
        return Float.valueOf(getTotalOrderPrice().getText().substring(1).replace(",", ""));
    }


    public void isBasketDisplayingCorrectDetails(Basket basket) {
        SoftAssert softAssert = new SoftAssert();
        IntStream.range(0, basket.getBasket().size() - 1).forEach(i -> {
            softAssert.assertEquals(basket.getBasket().get(i).getName(), returnProductsName(i));
            softAssert.assertEquals(basket.getBasket().get(i).getPrice(), returnProductsPrice(i));
            softAssert.assertEquals(basket.getBasket().get(i).getQuantity(), returnProductsQuantity(i));
            softAssert.assertEquals(basket.getBasket().get(i).getTotalPrice(), returnProductsTotalPrice(i));
        });
        softAssert.assertEquals(basket.getBasketTotalPrice(), returnTotalOrderPrice());
        softAssert.assertAll();
    }
}