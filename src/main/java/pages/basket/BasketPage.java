package pages.basket;


import models.Basket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import pages.base.BasePage;

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


    public String returnProductsName(int index) {
        return this.productsName.get(index).getText();
    }

    public Float returnProductsPrice(int index) {
        return Float.valueOf(this.productsPrice.get(index).getText().substring(1));
    }

    public int returnProductsQuantity(int index) {
        return Integer.parseInt(this.productsQuantity.get(index).getAttribute("value"));
    }

    public Float returnProductsTotalPrice(int index) {
        return Float.valueOf(this.productsTotalPrice.get(index).getText().substring(1));
    }

    public Float returnTotalOrderPrice() {
        return Float.valueOf(this.totalOrderPrice.getText().substring(1).replace(",", ""));
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