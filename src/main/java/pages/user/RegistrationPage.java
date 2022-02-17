package pages.user;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.base.BasePage;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement socialTitleMr;

    @FindBy(xpath = "//input[@name='id_gender' and @value='2']")
    private WebElement socialTitleMrs;

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    @FindBy(xpath = "//input[@name='email' and @class='form-control']")
    private WebElement emailInput;

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayInput;

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement receiveOffersCheckBox;

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerPrivacyCheckBox;

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckBox;

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement userAgreementCheckBox;

    @FindBy(xpath = "//button[contains(@class, 'form-control-submit')]")
    private WebElement submitBtn;


    public void registerRandomUser(User user) {
        if (user.getSocialTitle().equals("Mr")) socialTitleMr.click();
        else socialTitleMrs.click();
        firstNameInput.sendKeys(user.getFirstName());
        lastNameInput.sendKeys(user.getLastName());
        emailInput.sendKeys(user.getEmail());
        passwordInput.sendKeys(user.getPassword());
        birthdayInput.sendKeys(user.getBirthDate());
        if (user.getReceiveOffers()) receiveOffersCheckBox.click();
        if (user.getCustomerData()) customerPrivacyCheckBox.click();
        if (user.getNewsletter()) newsletterCheckBox.click();
        if (user.getUserAgreement()) userAgreementCheckBox.click();
        submitBtn.click();
    }
}