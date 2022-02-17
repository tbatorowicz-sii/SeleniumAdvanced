package pages.common;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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
    private WebElement currentCategory;

    @FindBy(xpath = "//*[contains(@class, 'category current ')]//li[@class='category']")
    private List<WebElement> currentSubcategories;

    public int getCategoriesSize() {
        return categories.size();
    }

    public int getCurrentSubcategoriesSize() {
        return currentSubcategories.size();
    }

    public String getCurrentCategoryName() {
        return currentCategory.getText();
    }

    public void enterCategory(int i) {
        categories.get(i).click();
    }

    public void enterSubcategory(int i, int j) {
        if (j != 0) enterCategory(i);
        actions.moveToElement(categories.get(i)).perform();
        currentSubcategories.get(j).click();
        actions.moveToElement(categories.get(i)).perform();
    }

    public void enterBasketPage() {
        basket.click();
    }

    public void enterYourAccountPage() {
        myAccountBtn.click();
    }

    public void enterSignInPage() {
        signInBtn.click();
    }

    public String getMyAccountName() {
        return myAccountBtn.getText();
    }

    public void returnToMainPage() {
        logo.click();
    }

    public void signOut() {
        signOutBtn.click();
    }

    public void assertIfLoggedIn(User user) {
        assertThat(getMyAccountName()).isEqualTo(user.getFirstName() + " " + user.getLastName());
    }

}