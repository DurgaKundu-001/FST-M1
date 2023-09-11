package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity3_Java {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/login-form");

        System.out.println("The title of the page is : " + driver.getTitle());

        driver.findElement(By.xpath("//*[@id='username']")).sendKeys("admin");
        driver.findElement(By.xpath("//*[@id='password']")).sendKeys("password");
        driver.findElement(By.xpath("//button[text()='Log in']")).click();
        String message = driver.findElement(By.xpath("//*[@id='action-confirmation']")).getText();
        System.out.println("Login message: " + message);

        driver.quit();

    }
}
