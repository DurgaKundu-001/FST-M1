package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class Activity3 {
    WebDriver driver;

    @BeforeClass
    public void driver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");

    }

    @Test
    public void testcase1() {
        driver.findElement(By.id("username")).sendKeys("admin");
        driver.findElement(By.id("password")).sendKeys("password");
        driver.findElement(By.xpath("//div[2]/div/div/button")).click();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        String msg= driver.findElement(By.id("action-confirmation")).getText();
        Assert.assertEquals("Welcome Back, admin",msg);
    }
    @AfterClass
    public void close(){
        driver.close();
    }
}

