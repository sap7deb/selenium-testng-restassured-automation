package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;
import utils.DriverFactory;

import java.net.MalformedURLException;
import java.time.Duration;

public class BaseTest {

    WebDriver driver;

    @BeforeTest
    @Parameters({"url", "browser"})
    public void setup(String url, String browser) throws MalformedURLException {
        driver = DriverFactory.getDriver(browser);
        driver.manage().timeouts().implicitlyWait(Duration.ofMillis(5000));
        driver.get(url);
    }

    @AfterTest
    public void closeApplication() {
        driver.close();

    }

    public WebDriver getDriver() {
        return driver;
    }
}
