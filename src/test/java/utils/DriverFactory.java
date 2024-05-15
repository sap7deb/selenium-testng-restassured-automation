package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.net.MalformedURLException;

public class DriverFactory {

    private static WebDriver driver;

    public static WebDriver getDriver(String browser) throws MalformedURLException {
        if (driver == null) {
            if ("chrome".equalsIgnoreCase(browser)) {
                WebDriverManager.chromedriver().clearDriverCache().setup();
                WebDriverManager.chromedriver().clearResolutionCache().setup();
                WebDriverManager.chromedriver().setup();
                ChromeOptions option = new ChromeOptions();
                option.addArguments("--headless");
                driver = new ChromeDriver(option);

                /*URL url = new URL("http://localhost:4444/wd/hub");
                RemoteWebDriver webDriver = new RemoteWebDriver(url,option);
                driver = webDriver;*/


            } else if ("firefox".equalsIgnoreCase(browser)) {
                WebDriverManager.firefoxdriver().setup();
                driver = new FirefoxDriver();
            } else {
                throw new IllegalArgumentException("Invalid browser specified");
            }
        }
        return driver;
    }

    public static void quitDriver() {
        if (driver != null) {
            driver.quit();
            driver = null;
        }
    }
}
