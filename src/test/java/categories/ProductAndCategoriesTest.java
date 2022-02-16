package categories;

import base.TestBase;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import pages.categories.CategoryPage;
import pages.common.Header;

import java.util.stream.IntStream;

public class ProductAndCategoriesTest extends TestBase {
    @BeforeMethod
    public void initialize() {
        header = new Header(driver);
        categoryPage = new CategoryPage(driver);
        softAssert = new SoftAssert();
    }

    @Test
    public void shouldIterateThroughCategories() {
        IntStream.range(0, header.returnCategorySize()).forEach(i -> {
            header.enterCategory(i);
            categoryPage.assertions(softAssert, header.returnCategoryName(i));
            IntStream.range(0, header.getSubcategoryCurrent().size()).forEach(j -> {
                header.enterSubcategory(i, j, categoryPage.returnCategoryName());
                categoryPage.assertions(softAssert, header.getCategoryCurrent().getText());
            });
        });
        softAssert.assertAll();
    }
}