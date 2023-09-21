package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.awt.*;
import java.util.concurrent.TimeUnit;

public class Activity5 {
    WebDriver driver;

    @BeforeTest(alwaysRun = true)
    public void driver() {
        WebDriverManager.firefoxdriver().setup();
        driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");

    }

    @Test (groups = {"HeaderTests", "ButtonTests"})

    public void pageTitleTest() {

        String title = driver.getTitle();

        System.out.println("Title is: " + title);

        Assert.assertEquals(title, "Target Practice");

    }
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})
    public void HeaderTests1() {
        String Third = driver.findElement(By.id("third-header")).getText();
        Assert.assertEquals("Third header", Third);
    }
    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"HeaderTests"})

    public void HeaderTest2() {
        String fifth=driver.findElement(By.xpath("//div[2]/div/div/div/div[1]/h5")).getCssValue("color");
        Assert.assertEquals("rgb(33, 186, 69)",fifth);

    }

    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})
    public void ButtonTest1() {

        WebElement button1 = driver.findElement(By.cssSelector("button.olive"));

        Assert.assertEquals(button1.getText(), "Olive");

    }



    @Test (dependsOnMethods = {"pageTitleTest"}, groups = {"ButtonTests"})

    public void ButtonTest2() {

        WebElement button2 = driver.findElement(By.cssSelector("button.brown"));

        Assert.assertEquals(button2.getCssValue("color"), "rgb(255, 255, 255)");

    }
    @AfterClass
    public void close(){
        driver.close();
    }
}
