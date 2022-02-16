package pages.user;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class YourAccountPage extends BasePage {

    public YourAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#identity-link")
    private WebElement personalInformationBtn;

    public void enterPersonalInformationPage() {
        this.personalInformationBtn.click();
    }
}