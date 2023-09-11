package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity8_Java {
    public static void main(String[] args){
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");
        System.out.println("The title of teh page is: " +driver.getTitle());

        driver.findElement(By.id("toggleCheckbox")).click();
        WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(3000));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("willDisappear")));
        driver.findElement(By.id("toggleCheckbox")).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.className("willDisappear")));
        driver.findElement(By.xpath("/html/body/div[3]/div/div[1]/div[1]/input")).click();
        driver.quit();


    }
}
