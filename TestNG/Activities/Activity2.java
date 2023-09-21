package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.SkipException;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class Activity2 {

    WebDriver driver;
@BeforeClass
public void driver(){
    WebDriverManager.firefoxdriver().setup();
    driver = new FirefoxDriver();
    driver.get("https://v1.training-support.net/selenium/target-practice");

}

@Test
public void Testcase1() {
    String Title = driver.getTitle();
    System.out.println(Title);
    Assert.assertEquals(Title, "Target Practice");

}
@Test
public void Testcase2(){
    WebElement black= driver.findElement(By.className("black"));
    System.out.println("Test case for black button");
    Assert.assertEquals("Black", black.getText());
    }
@Test(enabled = false)
public void Testcase3(){
    String subHeading = driver.findElement(By.className("sub")).getText();
    Assert.assertTrue(subHeading.contains("Practice"));

}

@Test
public void testCase4 () {
    throw new SkipException("Skipping test case");
}
@AfterClass
   public void close(){
    driver.close();
}
}
