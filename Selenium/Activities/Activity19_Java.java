package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity19_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/javascript-alerts");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("The title of the page is : " + driver.getTitle());

        driver.findElement(By.id("confirm")).click();
        Alert confirmAlert = driver.switchTo().alert();
        System.out.println("Alert message is : "+ confirmAlert.getText());
        confirmAlert.accept();
        driver.findElement(By.id("confirm")).click();
        confirmAlert.dismiss();
        driver.close();

    }
}
