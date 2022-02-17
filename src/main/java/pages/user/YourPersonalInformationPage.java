package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class YourPersonalInformationPage extends BasePage {

    public YourPersonalInformationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@checked='']/ancestor::label")
    private WebElement socialTitle;

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


    public void dataAssertion(User expectedUser) {
        assertThat(new User.UserBuilder()
                .withSocialTitle(socialTitle.getText().replace(".", ""))
                .withFirstName(firstNameInput.getAttribute("value"))
                .withLastName(lastNameInput.getAttribute("value"))
                .withEmail(emailInput.getAttribute("value"))
                .withPassword(expectedUser.getPassword())
                .withBirthDate(birthdayInput.getAttribute("value"))
                .withReceiveOffers(receiveOffersCheckBox.getAttribute("checked") != null)
                .withCustomerData(true)
                .withNewsletter(newsletterCheckBox.getAttribute("checked") != null)
                .withUserAgreement(true)
                .build())
                .usingRecursiveComparison().isEqualTo(expectedUser);
    }

}