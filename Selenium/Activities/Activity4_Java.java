package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity4_Java {
    public static void main(String[] args) throws InterruptedException {
        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/target-practice");

        System.out.println("The title of the page is : " + driver.getTitle());
        WebElement Third= driver.findElement(By.xpath("//*[@id='third-header']"));
        System.out.println("The text of the 3rd header is : " + Third.getText());
        WebElement fifth= driver.findElement(By.xpath("//*[@class='ui green header']"));
        System.out.println("The color of the 5th header is : " + fifth.getCssValue("color"));
        WebElement Violet= driver.findElement(By.className("violet"));
        System.out.println("The classes of the Violet button is : " + Violet.getAttribute("class"));
        WebElement Grey= driver.findElement(By.className("grey"));
        System.out.println("The text of the Grey button is : " + Grey.getText());
        driver.quit();
    }

    }
