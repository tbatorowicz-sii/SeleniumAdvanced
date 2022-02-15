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

    @FindBy(css = ".no-account > a")
    private WebElement createAccountLinkText;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    public WebElement getSubmitLoginBtn() {
        return submitLoginBtn;
    }

    public WebElement getCreateAccountLinkText() {
        return createAccountLinkText;
    }

    public void logIn(User user) {
        getEmailInput().sendKeys(user.getEmail());
        getPasswordInput().sendKeys(user.getPassword());
        getSubmitLoginBtn().click();
    }

    public void enterCreateAccountPage() {
        getCreateAccountLinkText().click();
    }
}