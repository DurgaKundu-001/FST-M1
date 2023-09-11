package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity12_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println("The title of the page is : " + driver.getTitle());
        WebElement Text1 = driver.findElement(By.id("input-text"));
        //check here
        System.out.println("Check if the textbox is enabled  : " + Text1.isEnabled());

       driver.findElement(By.id("toggleInput")).click();
        System.out.println("Check if the textbox is enabled after click on the toggle button : " + Text1.isEnabled());
        driver.quit();

    }
}
