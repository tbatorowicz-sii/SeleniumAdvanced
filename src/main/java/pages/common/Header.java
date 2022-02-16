package pages.common;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.testng.Assert;
import pages.base.BasePage;

import java.util.List;

public class Header extends BasePage {

    public Header(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".header i")
    private WebElement basket;

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(css = ".account")
    private WebElement myAccountBtn;

    @FindBy(css = ".user-info span")
    private WebElement signInBtn;

    @FindBy(css = ".logout")
    private WebElement signOutBtn;

    @FindBy(css = "#top-menu > .category")
    private List<WebElement> categories;

    @FindBy(xpath = "//*[contains(@class, 'category current ')]")
    private WebElement categoryCurrent;

    @FindBy(xpath = "//*[contains(@class, 'category current ')]//li[@class='category']")
    private List<WebElement> subcategoryCurrent;


    public List<WebElement> getSubcategoryCurrent() {
        return subcategoryCurrent;
    }

    public WebElement getCategoryCurrent() {
        return categoryCurrent;
    }

    public String returnCategoryName(int index) {
        return this.categories.get(index).getText();
    }

    public int returnCategorySize() {
        return this.categories.size();
    }

    public void enterCategory(int index) {
        this.categories.get(index).click();
    }

    public void enterSubcategory(int i, int j, String categoryName) {
        if (!categoryName.equals(returnCategoryName(i))) enterCategory(i);
        actions.moveToElement(this.categories.get(i)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(this.subcategoryCurrent.get(j)));
        this.subcategoryCurrent.get(j).click();
        actions.moveToElement(this.categories.get(i)).perform();
        wait.until(ExpectedConditions.elementToBeClickable(getCategoryCurrent()));
    }


    public void enterBasketPage() {
        this.basket.click();
    }

    public void enterMyAccountPage() {
        this.myAccountBtn.click();
    }

    public void enterSignInPage() {
        this.signInBtn.click();
    }

    public String getMyAccountName() {
        return this.myAccountBtn.getText();
    }

    public void returnToMainPage() {
        this.logo.click();
    }

    public void signOut() {
        this.signOutBtn.click();
    }

    public void assertIfLoggedIn(User user) {
        Assert.assertEquals(getMyAccountName(), user.getFirstName() + " " + user.getLastName());
    }

}