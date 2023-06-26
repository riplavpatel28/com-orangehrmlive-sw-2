package testsuite;

import browserfactory.BaseTest;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class LogInTest extends BaseTest {
    String baseURL = "https://opensource-demo.orangehrmlive.com/";

    @Before
    public void setUp() {
        openBrowser(baseURL);
    }

    @Test
    public void userShouldLoginSuccessfullyWithValidCredentials() {
        //Enter “Admin” username
        WebElement findUserName = driver.findElement(By.name("username"));
        findUserName.sendKeys("Admin");

        // Enter “admin123 password
        driver.findElement(By.name("password")).sendKeys("admin123");

        //Click on ‘LOGIN’ button
        driver.findElement(By.xpath("//button[text()=' Login ']")).click();

        //Verify the ‘Dashboard’ text is display
        String expectedText="Dashboard";
        String actualText=driver.findElement(By.xpath("//h6[@class='oxd-text oxd-text--h6 oxd-topbar-header-breadcrumb-module']")).getText();
        Assert.assertEquals("verify dashboard text",expectedText,actualText);

    }
    @After
    public void teardown(){
        closeBrowser();
    }
}
