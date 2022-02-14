package TestTest;

import base.TestBase;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MyTest extends TestBase {
    @Test
    public void shouldConfirmRightWebsite(){
        Assert.assertEquals(driver.getCurrentUrl(), "http://146.59.32.4/index.php");
    }
}
