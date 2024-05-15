// src/test/java/pages/HomePage.java

package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.IOException;
import java.time.Duration;

public class LoginPage {

    @FindBy(id = "loginusername")
    WebElement username;
    @FindBy(id = "loginpassword")
    WebElement enter_password;
    @FindBy(id = "login2")
    WebElement loginLink;
    @FindBy(id = "login2")
    WebElement loginButton;
    @FindBy(xpath = "//button[text()='Log in']")
    WebElement logoutButton;
    private WebDriver driver;

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void enterUserName(String userName) {
        username.sendKeys(userName);
    }

    public void enterPassword(String password) {
        Wait<WebDriver> wait = new FluentWait<>(this.driver)
                .withTimeout(Duration.ofMillis(2000))
                .pollingEvery(Duration.ofMillis(200))
                .ignoring(ElementNotInteractableException.class);

        wait.until(d -> {
            enter_password.sendKeys(password);
            return true;
        });

    }

    public void takeScreenShot() throws IOException {
        File src = ((TakesScreenshot) this.driver).getScreenshotAs(OutputType.FILE);
        File elementScr = loginLink.getScreenshotAs(OutputType.FILE);

        try {
            FileHandler.copy(src, new File(System.getProperty("user.dir") + "/screenshots/test.png"));
            FileHandler.copy(elementScr, new File(System.getProperty("user.dir") + "/screenshots/logoutButton.png"));

        } catch (IOException e) {
            System.out.println(e);
        }
    }

    public void clickLoginLink() {
        loginLink.click();
    }

    public void clickLoginButton() {
        //loginButton.click();
        Actions actions = new Actions(driver);
        actions.moveToElement(loginButton).click().perform();
    }

    public void waitForElement() {
        Wait<WebDriver> wait = new WebDriverWait(this.driver, Duration.ofMillis(10000));
        wait.until(d -> loginButton.getText().trim().equalsIgnoreCase("Logout"));
    }

    public WebElement getLoginLink() {
        return loginLink;
    }

}
