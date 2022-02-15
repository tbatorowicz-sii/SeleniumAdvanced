package pages;

import models.Product;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;


public class ProductDetailsPage extends BasePage{

    public ProductDetailsPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#quantity_wanted")
    private WebElement quantity;

    public WebElement getQuantity() {
        return quantity;
    }

    @FindBy(css = "button.btn-primary")
    private WebElement addProductBtn;

    public WebElement getAddProductBtn() {
        return addProductBtn;
    }

    @FindBy(css = ".h1")
    private WebElement productName;

    public WebElement getProductName() {
        return productName;
    }

    @FindBy(xpath = "//span[@itemprop='price']")
    private WebElement productPrice;

    public WebElement getProductPrice() {
        return productPrice;
    }

    @FindBy(css = "p.cart-products-count")
    private WebElement productAmountInfo;

    public WebElement getProductAmountInfo() {
        return productAmountInfo;
    }

    @FindBy(css = "h6.h6")
    private WebElement popupProductName;

    public WebElement getPopupProductName() {
        return popupProductName;
    }

    @FindBy(xpath = "//i[.='close']")
    private WebElement closePopupBtn;

    public WebElement getClosePopupBtn() {
        return closePopupBtn;
    }

    public void closePopup(){
        getClosePopupBtn().click();
        wait.until(ExpectedConditions.invisibilityOf(getClosePopupBtn()));
    }

    public String returnPopupProductName() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h6.h6")));
        return getPopupProductName().getText();
    }

    public String returnProductAmountInfo(){
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("p.cart-products-count")));
        return getProductAmountInfo().getText();
    }

    public float returnProductPrice(){
        return Float.parseFloat(getProductPrice().getAttribute("content"));
    }

    public String returnProductName(){
        return getProductName().getText();
    }

    public int returnProductQuantity(){
        return Integer.parseInt(getQuantity().getAttribute("value"));
    }

    public void setRandomQuantity(){
        getQuantity().clear();
        getQuantity().sendKeys(String.valueOf(rand.nextInt(1,6)));
    }

    public void addProductToBasket(){
        basket.addProduct(new Product(returnProductName(),returnProductPrice(),returnProductQuantity()));
        getAddProductBtn().click();
        //System.out.println(basket.toString());
        //basket.showBasket();
    }

    public void isPopupTextDisplayedCorrect(){
        if(basket.getTotalQuantity()==1){
            Assert.assertEquals(returnProductAmountInfo(), "There is " + basket.getTotalQuantity() + " items in your cart.");
        } else{
            Assert.assertEquals(returnProductAmountInfo(), "There are " + basket.getTotalQuantity() + " items in your cart.");
        }
    }
}
