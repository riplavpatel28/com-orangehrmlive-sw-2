package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;

public class ForgotPasswordTest extends BaseTest {
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldNavigateToForgotPasswordPageSuccessfully() {
        // click on the ‘Forgot your password’ link
        driver.findElement(By.xpath("//p[@class = 'oxd-text oxd-text--p orangehrm-login-forgot-header']")).click();
        // Enter “Admin” username
        String expectedMessage = "Reset Password";
        String actualMessage = driver.findElement(By.xpath("//button [@type = 'submit']")).getText();
        Assert.assertEquals("Reset Password", expectedMessage, actualMessage);


    }

    @After
    public void teardown() {
        closeBrowser();
    }
}