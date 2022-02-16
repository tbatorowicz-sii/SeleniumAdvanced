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

    public void isLabelDisplaysCorrectAmount(SoftAssert softAssert) {
        if (this.categoryProducts.size() == 1)
            softAssert.assertEquals(this.amountInfoLabel.getText(), "There is " + this.categoryProducts.size() + " product.");
        else
            softAssert.assertEquals(this.amountInfoLabel.getText(), "There are " + this.categoryProducts.size() + " products.");
        System.out.println(this.amountInfoLabel.getText() + " " + this.categoryProducts.size());
    }

    public String returnCategoryName() {
        return this.categoryName.getText();
    }
}
