package Activities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Activity16_Java {
    public static void main(String[] agrs) {

        WebDriverManager.firefoxdriver().setup();
        WebDriver driver = new FirefoxDriver();
        driver.get("https://v1.training-support.net/selenium/dynamic-attributes");
        System.out.println("The title of the page is : " + driver.getTitle());

        driver.findElement(By.xpath("//input[contains(@class, '-username')]")).sendKeys("DurgaK");
        driver.findElement(By.xpath("//input[contains(@class, '-password')]")).sendKeys("password");
        driver.findElement(By.xpath("//label[text() = 'Confirm Password']/following-sibling::input")).sendKeys("password");
        driver.findElement(By.xpath("//input[contains(@class, 'email-')]")).sendKeys("dk@gmail.com");
        driver.findElement(By.xpath("//div[2]/div/div[3]/div/div/button")).click();

        WebElement mes= driver.findElement(By.id("action-confirmation"));
        System.out.println("The success message is : "+ mes.getText());
        driver.close();

    }

}
