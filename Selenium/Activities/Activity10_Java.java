package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;


public class Activity10_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println("The title of the page is : " + driver.getTitle());
        WebElement check1=driver.findElement(By.xpath("//div[3]/div/div[1]/div[1]/input"));
        System.out.println("The check box is displayed : " + check1.isDisplayed());

        driver.findElement(By.id("toggleCheckbox")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("willDisappear")));
        System.out.println("After clicking on the toggle button, The check box is displayed : " + check1.isDisplayed());

        driver.quit();
    }
}
