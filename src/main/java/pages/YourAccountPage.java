package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class YourAccountPage extends BasePage {

    public YourAccountPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = "#identity-link")
    private WebElement personalInformationBtn;

    public void enterPersonalInformation() {
        personalInformationBtn.click();
    }
}