package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class HeaderPageObject extends BasePage {

    public HeaderPageObject(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//header//span[.='Sign in']")
    private WebElement signInBtn;

    @FindBy(css = ".logout")
    private WebElement signOutBtn;

    @FindBy(css = ".account")
    private WebElement myAccoutnBtn;

    @FindBy(css = ".logo")
    private WebElement logo;

    @FindBy(css = ".header i")
    private WebElement basket;

    public WebElement getBasket() {
        return basket;
    }

    public WebElement getLogo() {
        return logo;
    }

    public WebElement getSignInBtn() {
        return signInBtn;
    }

    public WebElement getSignOutBtn() {
        return signOutBtn;
    }

    public WebElement getMyAccoutnBtn() {
        return myAccoutnBtn;
    }

    public void returnToMainPage(){
        getLogo().click();
    }

    public void signOut() {
        getSignOutBtn().click();
    }

    public void enterMyAccount() {
        getMyAccoutnBtn().click();
    }

    public void enterBasket(){
        getBasket().click();
    }

    public String getMyAccountName() {
        return getMyAccoutnBtn().getText();
    }

    public void enterSignIn() {
        getSignInBtn().click();
    }
}