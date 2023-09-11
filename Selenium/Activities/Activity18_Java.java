package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Activity18_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/selects");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        System.out.println("The title of the page is : " + driver.getTitle());

        WebElement selectElement = driver.findElement(By.id("multi-select"));
        // Pass the WebElement to the Select object
        Select multiSelect = new Select(selectElement);

        multiSelect.selectByVisibleText("Javascript");
        for(int i=4; i<=6; i++){
            multiSelect.selectByIndex(i);
        }
        multiSelect.selectByValue("node");
        multiSelect.deselectByIndex(5);

        driver.quit();
    }
}
