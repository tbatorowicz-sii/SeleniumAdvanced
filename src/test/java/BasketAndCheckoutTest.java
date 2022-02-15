import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.BasketPage;
import pages.HeaderPageObject;
import pages.MainPage;
import pages.ProductDetailsPage;

import java.util.stream.IntStream;


public class BasketAndCheckoutTest extends TestBase {
    @BeforeMethod
    public void initPages() {
        mainPage = new MainPage(driver);
        productDetailsPage = new ProductDetailsPage(driver);
        header = new HeaderPageObject(driver);
        basketPage = new BasketPage(driver);
    }

    @Test
    public void shouldCorrectlyDisplayProductsInBasket() {
        mainPage.enterRandomPopularProduct();
        productDetailsPage.setRandomQuantity();
        productDetailsPage.addProductToBasket();
        productDetailsPage.isPopupTextDisplayedCorrect();
        productDetailsPage.closePopup();
        header.returnToMainPage();
        IntStream.range(0, 5).forEach(i -> {
            mainPage.enterRandomPopularProduct();
            productDetailsPage.setRandomQuantity();
            productDetailsPage.addProductToBasket();
            productDetailsPage.isPopupTextDisplayedCorrect();
            productDetailsPage.closePopup();
            header.returnToMainPage();
        });
        header.enterBasket();
        basketPage.isBasketDisplayingCorrectDetails(productDetailsPage.getBasket());
    }
}