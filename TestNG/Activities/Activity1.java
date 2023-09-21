package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity1 {
    WebDriver driver;

    @BeforeClass
    public void driver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net");

    }

    @Test
    public void testcase1() {
        System.out.println("The tittle of the page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"Training Support");
        driver.findElement(By.id("about-link")).click();
        System.out.println("The tittle of the new page is : " + driver.getTitle());
        Assert.assertEquals(driver.getTitle(),"About Training Support");

    }

    @AfterMethod
    public void teardown() {
        driver.close();
    }
}

