package base;

import utils.DriverFactory;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utils.ConfigBrowser;
import utils.JsonJackson;

import java.io.IOException;

public class TestBase {
    protected WebDriver driver;
    protected ConfigBrowser configBrowser;

    @BeforeMethod
    public void setUp() throws IOException {
        configBrowser = new JsonJackson().deserializeJson("src\\property", ConfigBrowser.class);
        driver = new DriverFactory().getDriver(configBrowser.getBrowser());
        driver.get("http://146.59.32.4/");
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}