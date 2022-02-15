package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".col-md-6 > input")
    private WebElement emailInput;

    @FindBy(css = ".input-group > input")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement submitLoginBtn;

    @FindBy(css = ".page-footer")
    private WebElement signOutLinkText;

    @FindBy(css = ".no-account > a")
    private WebElement createAccountLinkText;

    public WebElement getSignOutLinkText() {
        return signOutLinkText;
    }

    public void logIn(User user) {
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        submitLoginBtn.click();
    }

    public void enterCreateAccount() {
        createAccountLinkText.click();
    }
}