package base;

import models.User;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.asserts.SoftAssert;
import pages.basket.BasketPage;
import pages.basket.ProductDetailsPage;
import pages.categories.CategoryPage;
import pages.common.Header;
import pages.common.MainPage;
import pages.user.LogInPage;
import pages.user.RegistrationPage;
import pages.user.YourAccountPage;
import pages.user.YourPersonalInformationPage;
import utils.ConfigBrowser;
import utils.DriverFactory;
import utils.JsonJackson;

import java.io.IOException;

public class TestBase {
    protected WebDriver driver;
    protected ConfigBrowser configBrowser;

    protected Header header;
    protected LogInPage logInPage;
    protected RegistrationPage registrationPage;
    protected YourAccountPage yourAccountPage;
    protected YourPersonalInformationPage yourPersonalInformationPage;
    protected MainPage mainPage;
    protected ProductDetailsPage productDetailsPage;
    protected BasketPage basketPage;
    protected CategoryPage categoryPage;

    protected User user;

    protected SoftAssert softAssert;

    @BeforeMethod
    public void setUp() throws IOException {
        configBrowser = new JsonJackson().deserializeJson("src\\property", ConfigBrowser.class);
        driver = new DriverFactory().getDriver(configBrowser.getBrowser());
        driver.get(configBrowser.getMainURL());
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}