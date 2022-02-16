package basket;

import base.TestBase;
import models.Basket;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.basket.BasketPage;
import pages.basket.ProductDetailsPage;
import pages.common.Header;
import pages.common.MainPage;

import java.util.stream.IntStream;


public class BasketAndCheckoutTest extends TestBase {
    @BeforeMethod
    public void initialize() {
        mainPage = new MainPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        header = new Header(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    public void shouldCorrectlyDisplayProductsInBasket() {
        IntStream.range(0, 6).forEach(i -> {
            mainPage.enterRandomPopularProduct();
            productDetailsPage.addProductToBasket();
            header.returnToMainPage();
        });
        header.enterBasketPage();
        basketPage.isBasketDisplayingCorrectDetails(new Basket(),productDetailsPage.getBasket());
    }
}