package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class MainPage extends BasePage {

    public MainPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(css = ".product")
    private List<WebElement> popularProducts;

    public List<WebElement> getPopularProducts() {
        return popularProducts;
    }

    public void enterRandomPopularProduct() {
        getPopularProducts().get(rand.nextInt(getPopularProducts().size())).click();
    }

}
