package pages.basket;

import models.Basket;
import models.Product;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
        return Float.valueOf(this.productsTotalPrice.get(index).getText().substring(1).replace(",", ""));
    }

    public Float returnTotalOrderPrice() {
        return Float.valueOf(this.totalOrderPrice.getText().substring(1).replace(",", ""));
    }


    public void isBasketDisplayingCorrectDetails(Basket expected, Basket actual) {
        IntStream.range(0, actual.getBasket().size()).forEach(i -> {
            expected.addProduct(new Product(returnProductsName(i), returnProductsPrice(i), returnProductsQuantity(i), returnProductsTotalPrice(i)));
        });
        assertThat(actual).usingRecursiveComparison().isEqualTo(expected);
        Assert.assertEquals(actual.getBasketTotalPrice(), returnTotalOrderPrice());
    }
}