package pages.basket;

import models.Basket;
import models.Product;
import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import pages.base.BasePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;


public class ProductDetailsPage extends BasePage {

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "button.btn-primary")
    private WebElement addProductBtn;

    @FindBy(xpath = "//i[.='close']")
    private WebElement closePopupBtn;

    @FindBy(css = "p.cart-products-count")
    private WebElement productAmountInfo;

    @FindBy(css = ".h1")
    private WebElement productName;

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement productPrice;

    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;


    public float returnProductPrice() {
        return Precision.round(Float.parseFloat(productPrice.getAttribute("content")), 2);
    }

    public int returnProductQuantity() {
        return Integer.parseInt(quantity.getAttribute("value"));
    }

    public void addProductToBasket() {
        quantity.clear();
        quantity.sendKeys(String.valueOf(rand.nextInt(5)+1));
        basket.addProduct(new Product(productName.getText(), returnProductPrice(), returnProductQuantity()));
        addProductBtn.click();
        wait.until(ExpectedConditions.textToBePresentInElement(productAmountInfo, "There"));
        assertThat(productAmountInfo.getText()).isEqualTo(basket.getTotalQuantity() == 1
                ? "There is " + basket.getTotalQuantity() + " item in your cart." : "There are " + basket.getTotalQuantity() + " items in your cart.");
        closePopupBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(closePopupBtn));
    }

    public Basket getBasket() {
        return basket;
    }
}