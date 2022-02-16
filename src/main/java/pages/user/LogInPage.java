package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class LogInPage extends BasePage {

    public LogInPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".no-account > a")
    private WebElement createAccountLinkText;

    @FindBy(css = ".col-md-6 > input")
    private WebElement emailInput;

    @FindBy(css = ".input-group > input")
    private WebElement passwordInput;

    @FindBy(css = "#submit-login")
    private WebElement submitLoginBtn;


    public void enterCreateAccountPage() {
        this.createAccountLinkText.click();
    }

    public void logIn(User user) {
        this.emailInput.sendKeys(user.getEmail());
        this.passwordInput.sendKeys(user.getPassword());
        this.submitLoginBtn.click();
    }

}