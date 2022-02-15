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

    public void enterSignIn() {
        signInBtn.click();
    }

    public void signOut() {
        signOutBtn.click();
    }

    public void enterMyAccount() {
        myAccoutnBtn.click();
    }

    public String getMyAccountName() {
        return myAccoutnBtn.getText();
    }
}