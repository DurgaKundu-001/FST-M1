package Activities;

import org.junit.Assert;
//import dev.failsafe.internal.util.Assert;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

public class Activity7_Java {
    public static void main(String[] args) throws InterruptedException {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/drag-drop");

        System.out.println("The title of the page is : " + driver.getTitle());
        WebElement Football=driver.findElement(By.id("draggable"));
        WebElement drop1= driver.findElement(By.id("droppable"));
        WebElement drop2=driver.findElement(By.id("dropzone2"));
        Actions action= new Actions(driver);
        action.clickAndHold(Football).moveToElement(drop1).pause(2000).release().build().perform();
        String check1=driver.findElement(By.xpath("/html/body/div[2]/div/div[2]/div[1]/p")).getText();
        Assert.assertEquals("Ball is not dropped in Dropzone1", "Dropped!", check1);

        action.dragAndDrop(Football,drop2).build().perform();
        String check2=driver.findElement(By.xpath("//*[@id=\"dropzone2\"]/p")).getText();
        Assert.assertEquals("Ball is not dropped in Dropzone2", "Dropped!", check2);
        driver.close();
    }
}
