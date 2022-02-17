package pages.base;

import models.Basket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.asserts.SoftAssert;

import java.time.Duration;
import java.util.Random;

public abstract class BasePage {
    protected Random rand;
    protected Basket basket;
    protected WebDriverWait wait;
    protected Actions actions;
    protected SoftAssert softAssert;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        rand = new Random();
        basket = new Basket();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        actions = new Actions(driver);
        softAssert = new SoftAssert();
    }
}