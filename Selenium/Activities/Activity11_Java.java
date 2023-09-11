package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity11_Java {
    public static void main(String[] args){

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver= new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-controls");

        System.out.println("The title of the page is : " +driver.getTitle());
        WebElement check1=driver.findElement(By.xpath("//div[3]/div/div[1]/div[1]/input"));
        System.out.println("Check if the checkbox is selected : " + check1.isSelected());
        check1.click();

        System.out.println("Check if the checkbox is selected now : " + check1.isSelected());
        driver.quit();

    }
}
