package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity5_Java {
    public static void main(String[] args) throws InterruptedException {

    WebDriverManager.firefoxdriver().setup();
    WebDriver driver = new FirefoxDriver();
    driver.get("https://v1.training-support.net/selenium/input-events");

    System.out.println("The title of the page is : " + driver.getTitle());

    Actions action=new Actions(driver);
    action.click().pause(1000).build().perform();
    WebElement activeSide= driver.findElement(By.className("active"));
    System.out.println("The side in the front is : " + activeSide.getText());

    action.doubleClick().pause(1000).build().perform();
    WebElement activeSide1= driver.findElement(By.className("active"));
    System.out.println("The side in the front after double click is : " + activeSide1.getText());

    action.contextClick().pause(1000).build().perform();
    WebElement activeSide2= driver.findElement(By.className("active"));
    System.out.println("The side in the front after right click is : " + activeSide2.getText());
    driver.quit();
}
}
