package pages.categories;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.asserts.SoftAssert;
import pages.base.BasePage;

import java.util.List;

public class CategoryPage extends BasePage {

    public CategoryPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".h1")
    private WebElement categoryName;

    @FindBy(css = ".products img")
    private List<WebElement> categoryProducts;

    @FindBy(css = ".total-products > p")
    private WebElement amountInfoLabel;

    public void assertions(SoftAssert softAssert, String nameOfWhatWasClicked) {
        softAssert.assertEquals(nameOfWhatWasClicked, categoryName.getText());
        softAssert.assertEquals(amountInfoLabel.getText(), categoryProducts.size() == 1
                ? "There is " + categoryProducts.size() + " product." : "There are " + categoryProducts.size() + " products.");
    }
}
