package pages.common;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

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

}