package pages;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;

public class YourPersonalInformationPage extends BasePage {

    public YourPersonalInformationPage(WebDriver driver) {
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

    public String getFirstNameInputText() {
        return firstNameInput.getAttribute("value");
    }

    @FindBy(xpath = "//input[@name='lastname']")
    private WebElement lastNameInput;

    public WebElement getLastNameInput() {
        return lastNameInput;
    }

    public String getLastNameInputText() {
        return lastNameInput.getAttribute("value");
    }

    @FindBy(xpath = "//input[@name='email' and @class='form-control']")
    private WebElement emailInput;

    public WebElement getEmailInput() {
        return emailInput;
    }

    public String getEmailInputText() {
        return emailInput.getAttribute("value");
    }

    @FindBy(xpath = "//input[@name='password']")
    private WebElement passwordInput;

    public WebElement getPasswordInput() {
        return passwordInput;
    }

    @FindBy(xpath = "//input[@name='new_password']")
    private WebElement newPasswordInput;

    public WebElement getNewPasswordInput() {
        return newPasswordInput;
    }

    @FindBy(xpath = "//input[@name='birthday']")
    private WebElement birthdayInput;

    public WebElement getBirthdayInput() {
        return birthdayInput;
    }

    public String getBirthdayInputText() {
        return birthdayInput.getAttribute("value");
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

    public void isDataDisplayedCorrectly(User user) {
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(isAttribtuePresent(getSocialTitleMr(), "checked"), user.getSocialTitle().equals("Mr"));
        softAssert.assertEquals(getFirstNameInputText(), user.getFirstName());
        softAssert.assertEquals(getLastNameInputText(), user.getLastName());
        softAssert.assertEquals(getEmailInputText(), user.getEmail());
        softAssert.assertEquals(getBirthdayInputText(), user.getBirthDate());
        softAssert.assertEquals(getFirstNameInputText(), user.getFirstName());
        softAssert.assertEquals(isAttribtuePresent(getReceiveOffersCheckBox(), "checked"), user.getReceiveOffers().equals(true));
        softAssert.assertEquals(isAttribtuePresent(getNewsletterCheckBox(), "checked"), user.getNewsletter().equals(true));
        softAssert.assertAll();
    }

    private boolean isAttribtuePresent(WebElement element, String attribute) {
        try {
            if (element.getAttribute(attribute) != null) {
                return true;
            }
        } catch (Exception e) {

        }
        return false;
    }
}