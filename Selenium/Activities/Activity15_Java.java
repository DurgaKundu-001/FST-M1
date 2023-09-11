package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity15_Java {
    public static void main(String[] agrs){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("The title of the page is : "+driver.getTitle());
        driver.findElement(By.xpath("//input[starts-with(@class, 'username-')]")).sendKeys("admin");
        driver.findElement(By.xpath("//input[starts-with(@class, 'password-')]")).sendKeys("password");
        driver.findElement(By.xpath("//div[2]/div/div[1]/div/div/button")).click();

        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(By.id("action-confirmation")));
        WebElement msg= driver.findElement(By.id("action-confirmation"));
        System.out.println(msg.getText());

        driver.close();
    }
}
