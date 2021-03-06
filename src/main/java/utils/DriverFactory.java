package utils;

import enums.Browser;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class DriverFactory {

    public WebDriver getDriver(Browser browser) {
        switch (browser) {
            case CHROME:
                return getChromeDriver();
            case FIREFOX:
                return getFirefoxDriver();
            case IE:
                return getIEDriver();
            case EDGE:
                return getEdgeDriver();
            default:
                throw new IllegalArgumentException();
        }
    }

    private WebDriver getChromeDriver() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        return new ChromeDriver(options);
    }

    private WebDriver getFirefoxDriver() {
        WebDriverManager.firefoxdriver().setup();
        return new FirefoxDriver();
    }

    private WebDriver getIEDriver() {
        WebDriverManager.iedriver().setup();
        return new InternetExplorerDriver();
    }

    private WebDriver getEdgeDriver() {
        WebDriverManager.edgedriver().setup();
        return new EdgeDriver();
    }
}