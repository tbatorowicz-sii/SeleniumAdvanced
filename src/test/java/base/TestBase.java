package base;

import models.Basket;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pages.*;
import utils.ConfigBrowser;
import utils.DriverFactory;
import utils.JsonJackson;

import java.io.IOException;

public class TestBase {
    protected WebDriver driver;
    protected ConfigBrowser configBrowser;

    protected HeaderPageObject header;
    protected LogInPage logInPage;
    protected RegistrationPage registrationPage;
    protected YourAccountPage yourAccountPage;
    protected YourPersonalInformationPage yourPersonalInformationPage;
    protected MainPage mainPage;
    protected ProductDetailsPage productDetailsPage;
    protected BasketPage basketPage;



    @BeforeMethod
    public void setUp() throws IOException {
        configBrowser = new JsonJackson().deserializeJson("src\\property", ConfigBrowser.class);
        driver = new DriverFactory().getDriver(configBrowser.getBrowser());
        driver.get(configBrowser.getMainURL());
    }

    @AfterMethod
    public void tearDown() {
        //driver.quit();
    }
}