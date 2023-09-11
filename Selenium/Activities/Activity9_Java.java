package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity9_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/ajax");

        System.out.println("The title of the page is : " + driver.getTitle());
        driver.findElement(By.className("violet")).click();
        WebDriverWait wait=new WebDriverWait(driver, Duration.ofSeconds(100));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax-content\"]/h1")));
        System.out.println("The message is: "+driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h1")).getText());
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//*[@id=\"ajax-content\"]/h3[contains(text(), \"I'm late!\")]")));
        System.out.println("The next message is: "+driver.findElement(By.xpath("//*[@id=\"ajax-content\"]/h3[contains(text(), \"I'm late!\")]")).getText());

        driver.quit();
    }
}
