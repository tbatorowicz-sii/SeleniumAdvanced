package pages.basket;

import models.Basket;
import models.Product;
import org.apache.commons.math3.util.Precision;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;


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
        return Precision.round(Float.parseFloat(this.productPrice.getAttribute("content")), 2);
    }

    public int returnProductQuantity() {
        return Integer.parseInt(this.quantity.getAttribute("value"));
    }

    public void setRandomQuantityAndAddProductToBasket() {
        this.quantity.clear();
        this.quantity.sendKeys(String.valueOf(rand.nextInt(1, 6)));
        basket.addProduct(new Product(this.productName.getText(), returnProductPrice(), returnProductQuantity()));
        this.addProductBtn.click();
    }

    public void assertIfPopupTextDisplayedCorrect() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.cart-products-count")));
        wait.until(ExpectedConditions.textToBePresentInElement(this.productAmountInfo, "There"));
        if (basket.getTotalQuantity() == 1)
            Assert.assertEquals(this.productAmountInfo.getText(), "There is " + basket.getTotalQuantity() + " item in your cart.");
        else
            Assert.assertEquals(this.productAmountInfo.getText(), "There are " + basket.getTotalQuantity() + " items in your cart.");
        this.closePopupBtn.click();
        wait.until(ExpectedConditions.invisibilityOf(this.closePopupBtn));
    }

    public Basket getBasket() {
        return basket;
    }
}