package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import pages.base.BasePage;

public class YourPersonalInformationPage extends BasePage {

    public YourPersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement socialTitleMr;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email' and @class='form-control']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayInput;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement receiveOffersCheckBox;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckBox;


    public void isDataDisplayedCorrectly(User user) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(socialTitleMr.getAttribute("checked") != null, user.getSocialTitle().equals("Mr"));
        softAssert.assertEquals(firstNameInput.getAttribute("value"), user.getFirstName());
        softAssert.assertEquals(lastNameInput.getAttribute("value"), user.getLastName());
        softAssert.assertEquals(emailInput.getAttribute("value"), user.getEmail());
        softAssert.assertEquals(birthdayInput.getAttribute("value"), user.getBirthDate());
        softAssert.assertEquals(receiveOffersCheckBox.getAttribute("checked") != null, user.getReceiveOffers().equals(true));
        softAssert.assertEquals(newsletterCheckBox.getAttribute("checked") != null, user.getNewsletter().equals(true));
        softAssert.assertAll();
    }

}