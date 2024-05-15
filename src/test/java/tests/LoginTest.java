package tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;
import pages.LoginPage;

import java.io.IOException;


public class LoginTest extends BaseTest {

    /*@BeforeMethod
    @Parameters("browser")
    public void setup(String browser) {
        driver = DriverFactory.getDriver(browser);
        homePage = new HomePage(driver);
    }*/

    public LoginPage loginPage;

    @BeforeMethod
    public void pageInitailization() {
        loginPage = new LoginPage(getDriver());
    }

    @Test
    @Parameters({"username", "password"})
    public void loginTest(String username, String password) throws InterruptedException, IOException {

        loginPage.clickLoginLink();
        Thread.sleep(2000);
        loginPage.enterUserName(username);
        loginPage.enterPassword(password);
        Thread.sleep(2000);

        loginPage.clickLoginButton();
        // loginPage.waitForElement();
        Thread.sleep(8000);
        loginPage.takeScreenShot();


        Assert.assertTrue(loginPage.getLoginLink().isDisplayed());
        System.out.println("Here----------------");
        // Perform login actions
    }

    @AfterMethod
    public void teardown() throws InterruptedException {
        Thread.sleep(3000);
       // driver.quit();
    }
}
