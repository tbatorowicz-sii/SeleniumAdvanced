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
        IntStream.range(0, header.getCategoriesSize()).forEach(i -> {
            header.enterCategory(i);
            categoryPage.assertions(softAssert, header.getCurrentCategoryName());
            IntStream.range(0, header.getCurrentSubcategoriesSize()).forEach(j -> {
                header.enterSubcategory(i, j);
                categoryPage.assertions(softAssert, header.getCurrentCategoryName());
            });
        });
        softAssert.assertAll();
    }
}