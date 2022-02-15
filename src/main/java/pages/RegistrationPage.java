package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends BasePage {

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//input[@name='id_gender' and @value='1']")
    private WebElement socialTitleMr;

    public WebElement getSocialTitleMr() {
        return socialTitleMr;
    }

    @FindBy(xpath = "//input[@name='id_gender' and @value='2']")
    private WebElement socialTitleMrs;

    public WebElement getSocialTitleMrs() {
        return socialTitleMrs;
    }

    @FindBy(xpath = "//input[@name='firstname']")
    private WebElement firstNameInput;

    public WebElement getFirstNameInput() {
        return firstNameInput;
    }

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    @FindBy(xpath = "//input[@name='email' and @class='form-control']")
    private WebElement emailInput;

    public WebElement getEmailInput() {
        return emailInput;
    }

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayInput;

    public WebElement getBirthdayInput() {
        return birthdayInput;
    }

    @FindBy(xpath = "//input[@name='optin']")
    private WebElement receiveOffersCheckBox;

    public WebElement getReceiveOffersCheckBox() {
        return receiveOffersCheckBox;
    }

    @FindBy(xpath = "//input[@name='customer_privacy']")
    private WebElement customerPrivacyCheckBox;

    public WebElement getCustomerPrivacyCheckBox() {
        return customerPrivacyCheckBox;
    }

    @FindBy(xpath = "//input[@name='newsletter']")
    private WebElement newsletterCheckBox;

    public WebElement getNewsletterCheckBox() {
        return newsletterCheckBox;
    }

    @FindBy(xpath = "//input[@name='psgdpr']")
    private WebElement userAgreementCheckBox;

    public WebElement getUserAgreementCheckBox() {
        return userAgreementCheckBox;
    }

    @FindBy(xpath = "//button[contains(@class, 'form-control-submit')]")
    private WebElement submitBtn;

    public WebElement getSubmitBtn() {
        return submitBtn;
    }

    public void submit() {
        getSubmitBtn().click();
    }

    public void registerRandomUser(User user) {
        if (user.getSocialTitle().equals("Mr")) getSocialTitleMr().click();
        else getSocialTitleMrs().click();
        getFirstNameInput().sendKeys(user.getFirstName());
        getLastNameInput().sendKeys(user.getLastName());
        getEmailInput().sendKeys(user.getEmail());
        getPasswordInput().sendKeys(user.getPassword());
        getBirthdayInput().sendKeys(user.getBirthDate());
        if (user.getReceiveOffers()) getReceiveOffersCheckBox().click();
        if (user.getCustomerData()) getCustomerPrivacyCheckBox().click();
        if (user.getNewsletter()) getNewsletterCheckBox().click();
        if (user.getUserAgreement()) getUserAgreementCheckBox().click();
        submit();
    }
}