package pages.base;

import models.Basket;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;
import java.util.Random;

public abstract class BasePage {
    protected Random rand;
    protected Basket basket;
    protected WebDriverWait wait;

    public BasePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        rand = new Random();
        basket = new Basket();
        wait = new WebDriverWait(driver, Duration.ofSeconds(5));
    }
}