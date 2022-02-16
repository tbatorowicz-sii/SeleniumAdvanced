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
            softAssert.assertEquals(header.returnCategoryName(i), categoryPage.returnCategoryName());
            categoryPage.isLabelDisplayingCorrectAmount(softAssert);
            IntStream.range(0, header.getSubcategoryCurrent().size()).forEach(j -> {
                header.enterSubcategoryAndDisplayMenu(i, j, categoryPage.returnCategoryName());
                softAssert.assertEquals(header.getCategoryCurrent().getText(), categoryPage.returnCategoryName());
                categoryPage.isLabelDisplayingCorrectAmount(softAssert);
            });
        });
        softAssert.assertAll();
    }
}